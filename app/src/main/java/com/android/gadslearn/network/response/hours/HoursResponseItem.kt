package com.android.gadslearn.network.response.hours


import com.google.gson.annotations.SerializedName

data class HoursResponseItem(
    @SerializedName("badgeUrl")
    val badgeUrl: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("hours")
    val hours: Int,
    @SerializedName("name")
    val name: String
)