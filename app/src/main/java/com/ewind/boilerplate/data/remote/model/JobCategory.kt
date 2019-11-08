package com.ewind.boilerplate.data.remote.model


import com.google.gson.annotations.SerializedName

data class JobCategory(
  @SerializedName("description")
  var description: String, // Bediening

  @SerializedName("icon_path")
  var iconPath: String, // /assets/img/web/icons/categories/white-line/icon-bediening.svg

  @SerializedName("slug")
  var slug: String // bediening
)