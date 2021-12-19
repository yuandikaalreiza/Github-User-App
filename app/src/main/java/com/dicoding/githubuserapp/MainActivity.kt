package com.dicoding.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private var list = ArrayList<GithubUser>()
//hmm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_user)
        rvUsers.setHasFixedSize(true)

        list.addAll(listGithubUsers)
        showRecyclerList()
    }

    private val listGithubUsers: ArrayList<GithubUser>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataFollower = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)

            val listGithubUser = ArrayList<GithubUser>()
            for (i in dataName.indices) {
                val githubUser = GithubUser(
                    dataName[i],
                    dataUsername[i],
                    dataLocation[i],
                    dataPhoto.getResourceId(i, -1),
                    dataFollower[i],
                    dataFollowing[i],
                    dataRepository[i],
                    dataCompany[i]
                )
                listGithubUser.add(githubUser)
            }
            return listGithubUser
        }

    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listGithubUserAdapter = ListGithubUserAdapter(list)
        rvUsers.adapter = listGithubUserAdapter

        listGithubUserAdapter.setOnItemClickCallback(object: ListGithubUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GithubUser) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: GithubUser){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_USERNAME, user)
        startActivity(intent)
    }
}