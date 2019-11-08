package com.ewind.boilerplate.data.repository

import com.ewind.boilerplate.data.remote.apis.WorksApi
import com.ewind.boilerplate.data.remote.model.WorkModel
import com.ewind.boilerplate.domain.repository.WorkRepository
import com.ewind.boilerplate.util.ext.jsonStringMapTo
import com.ewind.boilerplate.util.ext.toJsonString
import io.reactivex.Observable
import org.json.JSONObject

class WorkRepositoryImpl(val worksApi: WorksApi) : WorkRepository {
    override fun getWorks(dates: String): Observable<List<WorkModel>> {
        return worksApi.getJobs(dates).map {
            val worklist = mutableListOf<WorkModel>()
            val jsonArray = JSONObject(it.data?.toJsonString()!!).getJSONArray(dates)
            for (i in 0 until jsonArray.length()) {
                val work = jsonArray[i].toString().jsonStringMapTo<WorkModel>()
                worklist.add(work)
            }
            return@map worklist
        }
    }
}