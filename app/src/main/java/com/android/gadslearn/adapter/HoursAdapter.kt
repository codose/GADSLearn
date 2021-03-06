package com.android.gadslearn.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.gadslearn.R
import com.android.gadslearn.network.response.hours.HoursResponseItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_leaderboard_item.view.*


/*
Created by
Oshodin Osemwingie

on 03/09/2020.
*/
class HoursRecyclerAdapter(val context : Context, val clickListener: HoursClickListener) : ListAdapter<HoursResponseItem, HoursRecyclerAdapter.MyViewHolder>(
    HoursDiffCallback()
) {

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(
            context: Context,
            item: HoursResponseItem,
            clickListener: HoursClickListener
        ) {
            itemView.setOnClickListener {
                clickListener.onClick(item)
            }
            itemView.item_leader_name.text = item.name
            itemView.item_leader_score.text = "${item.hours} Learning hours, ${item.country}"
            Glide.with(context)
                .load(item.badgeUrl)
                .into(itemView.item_leader_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return from(parent)
    }
    private fun from(parent: ViewGroup) : MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_leaderboard_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(context,item,clickListener)
    }
}

class HoursClickListener(val clickListener: (item : HoursResponseItem) -> Unit){
    fun onClick(item: HoursResponseItem) = clickListener(item)
}

class HoursDiffCallback : DiffUtil.ItemCallback<HoursResponseItem>(){
    override fun areItemsTheSame(oldItem: HoursResponseItem, newItem: HoursResponseItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HoursResponseItem, newItem: HoursResponseItem): Boolean {
        return oldItem == newItem
    }
}

