package com.ewind.boilerplate.data.remote.apis


import com.ewind.boilerplate.data.remote.model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WorksApi {
    @GET("contractor/shifts")
    fun getJobs(@Query("dates") date: String): Observable<Response>
}