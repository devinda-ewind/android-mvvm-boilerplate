package com.ewind.boilerplate

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.ewind.boilerplate.ki.networkModule
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import org.koin.android.ext.android.startKoin

/**
 * Created by cuongpm on 11/29/18.
 */

open class AssApplication: Application() {

    private lateinit var androidInjector: AndroidInjector<out DaggerApplication>

    override fun onCreate() {
        super.onCreate()

        // Initialize Stetho
        Stetho.initializeWithDefaults(this)
        startKoin(this, listOf(networkModule))
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}