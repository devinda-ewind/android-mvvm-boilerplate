package com.ewind.boilerplate.ui.main.work

import com.ewind.boilerplate.ui.main.base.BaseViewModel
import com.google.android.gms.maps.model.LatLng

class WorkViewModule() : BaseViewModel() {

    private var latLng: LatLng? = null

    fun setLocation(latLng: LatLng) {
        this.latLng = latLng
    }

    override fun start() {

    }

    override fun stop() {

    }
}