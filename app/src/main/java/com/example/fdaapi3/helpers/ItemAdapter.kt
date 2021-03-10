package com.example.fdaapi3.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fdaapi3.R
import com.example.fdaapi3.models.Item
import com.example.fdaapi3.models.RecalledItem
import java.util.*

class ItemAdapter(private val itemList: List<Item>) :RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${itemList.size} ")
        return holder.bind(itemList[position])
    }

    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        var itemDate = itemView.findViewById<TextView>(R.id.itemDate)
        var itemTitle = itemView.findViewById<TextView>(R.id.itemTitle)
        var recallReason = itemView.findViewById<TextView>(R.id.recallReason)

        fun bind(item: Item) {
            itemDate.text = item.recall_initiation_date
            itemTitle.text = item.product_description
            recallReason.text = item.reason_for_recall
        }

    }
}