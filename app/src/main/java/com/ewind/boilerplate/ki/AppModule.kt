package com.ewind.boilerplate.ki

import com.ewind.boilerplate.BuildConfig
import com.ewind.boilerplate.data.remote.apis.WorksApi
import com.ewind.boilerplate.util.network.createNetworkClient
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit

val networkModule: Module = module {
    single { worksApi }
}

val retrofit: Retrofit =
    createNetworkClient(
        BuildConfig.API_URL,
        BuildConfig.DEBUG
    )

val worksApi: WorksApi = retrofit.create(WorksApi::class.java)
