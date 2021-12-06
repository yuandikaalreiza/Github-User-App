package com.dicoding.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    val name: String,
    val userName: String,
    val location: String,
    val photo: Int,
    val follower: String,
    val following: String,
    val repository: String,
    val company: String,
): Parcelable
