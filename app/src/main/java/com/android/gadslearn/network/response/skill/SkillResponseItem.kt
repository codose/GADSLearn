package com.android.gadslearn.network.response.skill


import com.google.gson.annotations.SerializedName

data class SkillResponseItem(
    @SerializedName("badgeUrl")
    val badgeUrl: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: Int
)