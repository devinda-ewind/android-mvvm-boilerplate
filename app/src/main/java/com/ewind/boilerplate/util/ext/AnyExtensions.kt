package com.ewind.boilerplate.util.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.google.gson.Gson

inline fun <reified T : Any> Any.mapTo(): T {
    val gson = Gson()
    val toJson = gson.toJson(this@mapTo)
    return gson.fromJson(toJson, T::class.java)
}

inline fun <reified T : Any> String.jsonStringMapTo(): T =
    Gson().fromJson(this@jsonStringMapTo, T::class.java)


fun Any.toJsonString(): String = Gson().toJson(this@toJsonString)

inline fun <reified T : Activity> Context?.startActivity(func: Intent.() -> Unit) {
    val intent = Intent(this, T::class.java).apply {
        func()
    }
    this?.startActivity(intent)
}