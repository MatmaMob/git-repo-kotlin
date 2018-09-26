package com.example.tomaszmatusik.gitfinder.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.tomaszmatusik.gitfinder.R
import com.example.tomaszmatusik.gitfinder.data.models.Repository
import com.example.tomaszmatusik.gitfinder.data.models.User
import com.example.tomaszmatusik.gitfinder.databinding.GitRowBinding

class GitRecyclerAdapter(var context: Context, var users: MutableList<User>, var repositories: MutableList<Repository>, var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<GitRecyclerAdapter.GitViewHolder>() {

    inner class GitViewHolder(binding: GitRowBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: GitRowBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: GitRowBinding = DataBindingUtil.inflate(inflater, R.layout.git_row, parent, false)
        return GitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GitViewHolder, position: Int) {

        if (users.isNotEmpty() && repositories.isNotEmpty()) {
            holder.setIsRecyclable(false)
            if (position <= 29) {
                holder.binding.user = users[position]
                Glide.with(context).load(users[position].avatar_url).into(holder.binding.avatarImage)
                holder.binding.root.setOnClickListener {
                    onItemClickListener.onItemClick(users[position])
                }
            } else {
                holder.binding.repository = repositories[position - users.size]
            }
        }
    }

    override fun getItemCount(): Int = users.size + repositories.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    interface OnItemClickListener {
        fun onItemClick(user: User)
    }
}