package com.ewind.boilerplate.data.remote.model

import com.google.gson.annotations.SerializedName

data class WorkModel(
    @SerializedName("allows_factoring")
    var allowsFactoring: Boolean, // false

    @SerializedName("client")
    var client: Client,

    @SerializedName("date")
    var date: Date,

    @SerializedName("distance")
    var distance: Any?, // null

    @SerializedName("id")
    var id: Int, // 9302

    @SerializedName("job_category")
    var jobCategory: JobCategory,

    @SerializedName("key")
    var key: String, // xqazq9

    @SerializedName("location")
    var location: Location,

    @SerializedName("max_possible_earnings_hour")
    var maxPossibleEarningsHour: Float, // 19

    @SerializedName("max_possible_earnings_total")
    var maxPossibleEarningsTotal: Float, // 133

    @SerializedName("new_matches_count")
    var newMatchesCount: Int, // 0

    @SerializedName("open_positions")
    var openPositions: Int, // 2

    @SerializedName("photo")
    var photo: String, // https://tmpr-photos.ams3.digitaloceanspaces.com/hero/50809.jpg

    @SerializedName("shifts")
    var shifts: List<Shift>,

    @SerializedName("title")
    var title: String, // Toppers voor in de bediening!

    @SerializedName("url")
    var url: String // https://temper.works/werken-bij/hmf-events/bediening/toppers-voor-in-de-bediening
) {
    var visibleDate: Boolean = false
}