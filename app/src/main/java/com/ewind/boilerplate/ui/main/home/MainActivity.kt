package com.ewind.boilerplate.ui.main.home

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewind.boilerplate.R
import com.ewind.boilerplate.data.remote.model.WorkModel
import com.ewind.boilerplate.databinding.ActivityMainBinding
import com.ewind.boilerplate.domain.model.DShift
import com.ewind.boilerplate.domain.model.toViewModel
import com.ewind.boilerplate.ui.component.adapter.WorksAdapter
import com.ewind.boilerplate.ki.injectFeature
import com.ewind.boilerplate.ui.main.base.BaseActivity
import com.ewind.boilerplate.ui.main.work.EXTRA_LOCATIONS
import com.ewind.boilerplate.ui.main.work.EXTRA_NAME
import com.ewind.boilerplate.ui.main.work.EXTRA_SHIFT
import com.ewind.boilerplate.ui.main.work.WorkActivity
import com.ewind.boilerplate.util.PaginationScrollListener
import com.ewind.boilerplate.util.Resource
import com.ewind.boilerplate.util.ResourceState
import com.ewind.boilerplate.util.ext.YYYY_MM_DD
import com.ewind.boilerplate.util.ext.startActivity
import com.ewind.boilerplate.util.ext.toCustomDate
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : BaseActivity(), WorksAdapter.WorkListener {

    private lateinit var worksAdapter: WorksAdapter
    private val viewMod by viewModel<MainViewModel>()
    private var calendar = Calendar.getInstance()

    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        injectFeature()
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        worksAdapter = WorksAdapter(mutableListOf())
        worksAdapter.listener = this
        dataBinding.apply {
            adapter = worksAdapter
            viewModel = viewMod
        }

        viewMod.workliveDate.observe(this, androidx.lifecycle.Observer { updateView(it) })

        rv_works.addOnScrollListener(object :
            PaginationScrollListener(rv_works.layoutManager as LinearLayoutManager) {
            override fun loadMoreItems() {
                calendar = calendar.apply {
                    add(Calendar.DATE, 1)
                }
                getWorks()
            }

            override fun isLastPage(): Boolean {
                return false
            }

            override fun isLoading(): Boolean {
                return viewMod.isLoading
            }

        })

        pull_refresh.setOnRefreshListener {
            refreshData()
            getWorks()
        }

        getWorks()
    }

    private fun getWorks() {
        val date = calendar.time.toCustomDate(YYYY_MM_DD)
        viewMod.getWorks(date)
    }

    private fun refreshData() {
        worksAdapter.clearDate()
        calendar = Calendar.getInstance()
    }

    private fun updateView(resource: Resource<MutableList<WorkModel>>?) {
        resource?.let {
            when (it.state) {
                ResourceState.LOADING -> {
                }
                ResourceState.SUCCESS -> {
                    it.data?.let { it1 ->
                        worksAdapter.addWorks(it1)
                    }
                }
                ResourceState.ERROR -> {
                    Toast.makeText(this, it.message.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onWorkSelected(work: WorkModel) {
        val dLocation = work.location.toViewModel()
        val dShift = ArrayList<DShift>()
        dShift.addAll(work.shifts.map { it.toViewModel() })

        startActivity<WorkActivity> {
            putExtra(EXTRA_NAME, work.client.name)
            putExtra(EXTRA_LOCATIONS, dLocation)
            putExtra(EXTRA_SHIFT, dShift)
        }
    }
}
