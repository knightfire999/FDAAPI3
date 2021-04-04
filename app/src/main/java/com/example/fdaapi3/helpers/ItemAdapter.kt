package com.example.fdaapi3.helpers

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fdaapi3.R
import com.example.fdaapi3.activities.ItemDetailActivity
import com.example.fdaapi3.models.Item
import com.example.fdaapi3.models.RecalledItem
import org.w3c.dom.Text
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
        Log.d("Response", "List Count :${itemList.size}")
        return holder.bind(itemList[position])
    }

    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        var type = itemView.findViewById<TextView>(R.id.type)
        var description = itemView.findViewById<TextView>(R.id.description)
        var reason = itemView.findViewById<TextView>(R.id.reason)
        var state = itemView.findViewById<TextView>(R.id.state)
        var address1 = itemView.findViewById<TextView>(R.id.address1)

        fun bind(item: Item) {
            type.text = item.product_type
            description.text = item.product_description
            reason.text = item.reason_for_recall
            state.text = item.state
            address1.text = item.address_1

            itemView.setOnClickListener {
                val specificItemIntent = Intent(itemView.context, ItemDetailActivity::class.java)
                specificItemIntent.putExtra(ItemDetailActivity.EXTRA_ITEM, item)
                itemView.context.startActivity(specificItemIntent)
            }
        }

    }
}