package com.ewind.boilerplate.domain.model

import android.os.Parcel
import android.os.Parcelable

class DLocation(
    var lat: String?, // 51.439705
    var lng: String? // 5.477976
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(lat)
        parcel.writeString(lng)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DLocation> {
        override fun createFromParcel(parcel: Parcel): DLocation {
            return DLocation(parcel)
        }

        override fun newArray(size: Int): Array<DLocation?> {
            return arrayOfNulls(size)
        }
    }
}