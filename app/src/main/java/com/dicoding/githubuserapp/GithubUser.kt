package com.dicoding.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    var name: String,
    var userName: String,
    var location: String,
    var photo: Int,
    val follower: String,
    val following: String,
    val repository: String,
    val company: String,
): Parcelable
