package com.ewind.boilerplate.data.remote.model


import com.google.gson.annotations.SerializedName

data class Format(
  @SerializedName("cdn_url")
  var cdnUrl: String // https://tmpr-photos.ams3.digitaloceanspaces.com/hero/53070.jpg
)