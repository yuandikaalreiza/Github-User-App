package com.dicoding.githubuserapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubuserapp.databinding.ItemRowUserBinding

class ListGithubUserAdapter(private val listGithubUser: ArrayList<GithubUser>): RecyclerView.Adapter<ListGithubUserAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, username, location, photo) = listGithubUser[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemUsername.text = username
        holder.binding.tvItemLocation.text = location
    }

    override fun getItemCount(): Int = listGithubUser.size
}