

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


/*
Created by
Oshodin Osemwingie

on 20/07/2020.
*/
class TempRecyclerAdapter(val context : Context, val clickListener: TempClickListener) : ListAdapter<String , TempRecyclerAdapter.MyViewHolder>(
    TempDiffCallback()
) {

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(
            context: Context,
            item: String,
            clickListener: TempClickListener
        ) {
            itemView.setOnClickListener {
                clickListener.onClick(item)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return from(parent)
    }
    private fun from(parent: ViewGroup) : MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.activity_main,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(context,item,clickListener)
    }
}

class TempClickListener(val clickListener: (item : String) -> Unit){
    fun onClick(item: String) = clickListener(item)
}

class TempDiffCallback : DiffUtil.ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}

