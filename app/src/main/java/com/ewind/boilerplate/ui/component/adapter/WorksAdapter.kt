package com.ewind.boilerplate.ui.component.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ewind.boilerplate.data.remote.model.WorkModel
import com.ewind.boilerplate.util.ext.*
import kotlinx.android.synthetic.main.item_work.view.*
import java.util.*


class WorksAdapter(val worksList: MutableList<WorkModel>) :
    RecyclerView.Adapter<WorksAdapter.ViewHolder>() {

    var listener: WorkListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(com.ewind.boilerplate.R.layout.item_work, false))
    }

    override fun getItemCount(): Int = worksList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.run { onBind(position) }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(position: Int) {

            val work = worksList[position]
            if (work.photo != null) {
                itemView.iv_work_image.loadImageCornerRound(work.photo, 10)
            } else {
                if (work.client.photos.isNotEmpty() && work.client.photos[0].formats.isNotEmpty()) {
                    itemView.iv_work_image.loadImageCornerRound(
                        work.client.photos[0].formats[0].cdnUrl, 10
                    )
                }
            }
            itemView.tv_work_name.text = work.client.name
            itemView.tv_work_type.text = work.jobCategory.description
            if (work.shifts.isNotEmpty()) {
                work.shifts[0].let {
                    itemView.tv_work_time.text = "${it.startTime} - ${it.endTime}"
                    val currencyCode = Currency.getInstance(it.currency).symbol
                    itemView.tv_work_price.text =
                        "$currencyCode ${String.format("%.2f", it.earningsPerHour)}"
                }
            }

            if (work.visibleDate) {
                itemView.tv_date.text = work.date.date.toDateWithTime()?.toCustomDate(EEEE_DD_MMMM)
                itemView.tv_date.visible()
            } else {
                itemView.tv_date.gone()
            }

            itemView.setOnClickListener {
                listener?.onWorkSelected(worksList[adapterPosition])
            }
        }
    }

    fun clearDate() {
        worksList.clear()
        notifyDataSetChanged()
    }

    fun addWorks(list: MutableList<WorkModel>) {
        worksList.addAll(list)
        notifyDataSetChanged()
    }

    interface WorkListener {
        fun onWorkSelected(work: WorkModel)
    }
}