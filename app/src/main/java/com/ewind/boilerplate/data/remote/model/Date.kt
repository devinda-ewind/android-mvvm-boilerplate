package com.ewind.boilerplate.data.remote.model


import com.google.gson.annotations.SerializedName

data class Date(
  @SerializedName("date")
  var date: String, // 2019-11-01 18:00:00

  @SerializedName("timezone")
  var timezone: String, // Europe/Amsterdam

  @SerializedName("timezone_type")
  var timezoneType: Int // 3
)