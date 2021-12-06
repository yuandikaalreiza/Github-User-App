package com.dicoding.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dicoding.githubuserapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<GithubUser>(EXTRA_USERNAME) as GithubUser
        Glide.with(this)
            .load(user.photo)
            .circleCrop()
            .into(binding.imgDetailPhoto)
        binding.tvDetailName.text = user.name
        binding.tvDetailUsername.text = user.userName
        binding.tvFollowersNum.text = user.follower
        binding.tvFollowingNum.text = user.following
        binding.tvRepoNum.text = user.repository
        binding.tvDetailLocation.text = user.location
        binding.tvDetailCompany.text = user.company
    }

}