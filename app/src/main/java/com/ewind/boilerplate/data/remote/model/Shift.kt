package com.ewind.boilerplate.data.remote.model


import com.google.gson.annotations.SerializedName

data class Shift(
  @SerializedName("currency")
  var currency: String, // EUR

  @SerializedName("duration")
  var duration: Int, // 7

  @SerializedName("earnings_per_hour")
  var earningsPerHour: Float, // 19

  @SerializedName("end_datetime")
  var endDatetime: String, // 2019-11-02 01:00:00

  @SerializedName("end_time")
  var endTime: String, // 01:00

  @SerializedName("id")
  var id: String, // prqzqpe

  @SerializedName("is_auto_accepted_when_applied_for")
  var isAutoAcceptedWhenAppliedFor: Int, // 0

  @SerializedName("start_date")
  var startDate: String, // 2019-11-01

  @SerializedName("start_datetime")
  var startDatetime: String, // 2019-11-01 18:00:00

  @SerializedName("start_time")
  var startTime: String, // 18:00
  @SerializedName("tempers_needed")

  var tempersNeeded: Int // 2
)