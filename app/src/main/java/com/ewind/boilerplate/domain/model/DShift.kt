package com.ewind.boilerplate.domain.model

import android.os.Parcel
import android.os.Parcelable

data class DShift(
    var currency: String?, // EUR
    var duration: Int?, // 7
    var earningsPerHour: Float?, // 19
    var endDatetime: String?, // 2019-11-02 01:00:00
    var endTime: String?, // 01:00
    var id: String?, // prqzqpe
    var isAutoAcceptedWhenAppliedFor: Int?, // 0
    var startDate: String?, // 2019-11-01
    var startDatetime: String?, // 2019-11-01 18:00:00
    var startTime: String?, // 18:00
    var tempersNeeded: Int? // 2
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(currency)
        parcel.writeValue(duration)
        parcel.writeValue(earningsPerHour)
        parcel.writeString(endDatetime)
        parcel.writeString(endTime)
        parcel.writeString(id)
        parcel.writeValue(isAutoAcceptedWhenAppliedFor)
        parcel.writeString(startDate)
        parcel.writeString(startDatetime)
        parcel.writeString(startTime)
        parcel.writeValue(tempersNeeded)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DShift> {
        override fun createFromParcel(parcel: Parcel): DShift {
            return DShift(parcel)
        }

        override fun newArray(size: Int): Array<DShift?> {
            return arrayOfNulls(size)
        }
    }
}