package com.example.tomaszmatusik.gitfinder.activities.details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.tomaszmatusik.gitfinder.utils.Constants
import com.example.tomaszmatusik.gitfinder.R
import com.example.tomaszmatusik.gitfinder.factories.ViewModelFactory
import com.example.tomaszmatusik.gitfinder.dagger.DaggApp
import com.example.tomaszmatusik.gitfinder.data.models.User
import com.example.tomaszmatusik.gitfinder.data.responses.UserDetailResponse
import com.example.tomaszmatusik.gitfinder.databinding.ActivityDetailBinding
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    var binding: ActivityDetailBinding? = null
    var user: User? = null

    private var detailViewModel: DetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        (getApplication() as DaggApp).getAppComponent()!!.inject(this)
        detailViewModel = ViewModelProviders.of(this, viewModelFactory)[DetailViewModel::class.java]
        user = intent.getSerializableExtra(Constants.USER_DATA) as User
        Glide.with(this).load(user?.avatar_url).into(binding!!.detailAvatar)

        detailViewModel?.getUserDetails(user?.login)?.observe(this, object : Observer<UserDetailResponse> {
            override fun onChanged(t: UserDetailResponse?) {
                binding?.userDetails = t
            }
        })
    }
}
