package com.android.gadslearn.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.gadslearn.R
import com.android.gadslearn.network.response.skill.SkillResponseItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_leaderboard_item.view.*

/*
Created by
Oshodin Osemwingie

on 03/09/2020.
*/
class SkillsRecyclerAdapter(val context : Context, val clickListener: SkillsClickListener) : ListAdapter<SkillResponseItem, SkillsRecyclerAdapter.MyViewHolder>(
    SkillsDiffCallback()
) {

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(
            context: Context,
            item: SkillResponseItem,
            clickListener: SkillsClickListener
        ) {
            itemView.setOnClickListener {
                clickListener.onClick(item)
            }
            itemView.item_leader_name.text = item.name
            itemView.item_leader_score.text = "${item.score} Skill IQ Score, ${item.country}"
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

class SkillsClickListener(val clickListener: (item : SkillResponseItem) -> Unit){
    fun onClick(item: SkillResponseItem) = clickListener(item)
}

class SkillsDiffCallback : DiffUtil.ItemCallback<SkillResponseItem>(){
    override fun areItemsTheSame(oldItem: SkillResponseItem, newItem: SkillResponseItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SkillResponseItem, newItem: SkillResponseItem): Boolean {
        return oldItem == newItem
    }
}

