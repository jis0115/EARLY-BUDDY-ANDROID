package com.devaon.early_buddy_android.feature.route

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devaon.early_buddy_android.R

class RouteAdapter(
    var context: Context,
    var clicked: ArrayList<Boolean>,
    var routeList: ArrayList<ArrayList<String>>
) : RecyclerView.Adapter<RouteViewHolder>() {

    private lateinit var routeDetailAdapter: RouteDetailAdapter

    override fun getItemCount(): Int {
        return routeList.size
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        holder.dropDown.setOnClickListener {
            if (clicked[position]) {
                holder.detailList.visibility = View.GONE
                holder.dropDownUp.setImageResource(R.drawable.ic_dropbox_down)
                clicked[position] = false
            } else {
                routeDetailAdapter = RouteDetailAdapter(routeList[position])
                holder.detailList.visibility = View.VISIBLE
                holder.detailList.adapter = routeDetailAdapter
                holder.detailList.layoutManager = LinearLayoutManager(context)
                holder.dropDownUp.setImageResource(R.drawable.ic_dropbox_up)
                clicked[position] = true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pass_through_route, parent, false)
        return RouteViewHolder(view)
    }
}


class RouteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var dropDown: ConstraintLayout = itemView.findViewById(R.id.item_pass_cl_drop_down_up)
    var detailList: RecyclerView = itemView.findViewById(R.id.item_pass_rv_riding_info_detail)
    var dropDownUp : ImageView= itemView.findViewById(R.id.item_pass_iv_drop_down_up_icon)
}