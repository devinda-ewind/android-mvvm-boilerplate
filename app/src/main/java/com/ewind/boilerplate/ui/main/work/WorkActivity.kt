package com.ewind.boilerplate.ui.main.work

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewind.boilerplate.R
import com.ewind.boilerplate.domain.model.DShift
import com.ewind.boilerplate.ui.component.adapter.ShiftAdapter
import com.ewind.boilerplate.ui.main.base.BaseActivity
import kotlinx.android.synthetic.main.activity_work.*
import org.koin.androidx.viewmodel.ext.android.viewModel

const val EXTRA_NAME = "name"
const val EXTRA_SHIFT = "shift"
const val EXTRA_LOCATIONS = "location"

class WorkActivity : BaseActivity() {

    private val viewMod by viewModel<WorkViewModule>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        val name = intent.extras?.getString(EXTRA_NAME)
        val shifts = intent.extras?.getParcelableArrayList<DShift>(EXTRA_SHIFT)

        supportActionBar?.title = name

        rv_sift.layoutManager = LinearLayoutManager(this)
        if (!shifts.isNullOrEmpty()) {
            rv_sift.adapter = ShiftAdapter(shifts.toMutableList())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
