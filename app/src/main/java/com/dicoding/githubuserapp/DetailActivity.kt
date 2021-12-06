package com.dicoding.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dicoding.githubuserapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<GithubUser>(EXTRA_USERNAME) as GithubUser
        Glide.with(this)
            .load(user.photo)
            .circleCrop()
            .into(binding.imgDetailPhoto)
        binding.apply {
            tvDetailName.text = user.name
            tvDetailUsername.text = user.userName
            tvFollowersNum.text = user.follower
            tvFollowingNum.text = user.following
            tvRepoNum.text = user.repository
            tvDetailLocation.text = user.location
            tvDetailCompany.text = user.company
        }
    }

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }
}