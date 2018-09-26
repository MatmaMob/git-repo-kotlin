package com.example.tomaszmatusik.gitfinder.activities.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.tomaszmatusik.gitfinder.utils.Constants
import com.example.tomaszmatusik.gitfinder.activities.details.DetailActivity
import com.example.tomaszmatusik.gitfinder.R
import com.example.tomaszmatusik.gitfinder.factories.ViewModelFactory
import com.example.tomaszmatusik.gitfinder.adapter.GitRecyclerAdapter
import com.example.tomaszmatusik.gitfinder.dagger.DaggApp
import com.example.tomaszmatusik.gitfinder.data.models.Repository
import com.example.tomaszmatusik.gitfinder.data.models.User
import com.example.tomaszmatusik.gitfinder.data.responses.RepositoryResponse
import com.example.tomaszmatusik.gitfinder.data.responses.UsersResponse
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), GitRecyclerAdapter.OnItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var mainViewModel: MainViewModel? = null
    private var users: MutableList<User>? = null
    private var repositories: MutableList<Repository>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (getApplication() as DaggApp).getAppComponent()!!.inject(this)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]

        searchInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                loadingBar.visibility = View.VISIBLE
                var query = s.toString()
                setSearchFuncionality(query)
                if (s!!.isEmpty()) {
                    Toast.makeText(applicationContext, "empty search shows nothing", Toast.LENGTH_SHORT).show()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

    fun setSearchFuncionality(query: String) {
        if (!query.isEmpty()) {
            repositories?.clear()
            users?.clear()
            mainViewModel?.getRepositoriesSearchResults(query, "", "")?.observe(this@MainActivity, object : Observer<RepositoryResponse> {
                override fun onChanged(repositoryResponse: RepositoryResponse?) {
                    repositories = repositoryResponse!!.items

                    if (repositories != null) {
                        mainViewModel?.getUserSearchResults(query, "", "")?.observe(this@MainActivity, object : Observer<UsersResponse> {
                            override fun onChanged(usersResponse: UsersResponse?) {
                                users = usersResponse!!.items
                                if (repositories != null && users != null) {
                                    setGitRecycler(users!!, repositories!!)
                                }
                            }
                        })
                    }
                }
            })
        }
    }

    fun setGitRecycler(users: MutableList<User>, repositories: MutableList<Repository>) {
        Collections.sort(users)
        Collections.sort(repositories)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        val adapter: GitRecyclerAdapter? = GitRecyclerAdapter(this, users, repositories, this)
        gitRecycler.layoutManager = layoutManager
        gitRecycler.adapter = adapter
        loadingBar.visibility = View.GONE
    }

    override fun onItemClick(user: User) {
        var intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(Constants.USER_DATA, user)
        startActivity(intent)
    }
}
