package com.ewind.boilerplate.domain.repository

import com.ewind.boilerplate.data.remote.model.WorkModel
import io.reactivex.Observable

interface WorkRepository {
    fun getWorks(dates: String): Observable<List<WorkModel>>
}