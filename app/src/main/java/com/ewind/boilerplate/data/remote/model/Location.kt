package com.ewind.boilerplate.data.remote.model


import com.google.gson.annotations.SerializedName

data class Location(
  @SerializedName("lat")
  var lat: String, // 51.439705

  @SerializedName("lng")
  var lng: String // 5.477976
)