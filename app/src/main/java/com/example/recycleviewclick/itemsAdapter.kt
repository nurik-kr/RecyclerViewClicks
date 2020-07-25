package com.example.recycleviewclick

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class itemsAdapter() : RecyclerView.Adapter<itemsVH>() {

    private var data = arrayListOf<ItemsData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemsVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lin, parent, false)
        return itemsVH(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: itemsVH, position: Int) {
        holder.bind(data[position])
    }

    fun update(data: ArrayList<ItemsData>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun delete(pos: Int) {
        if (pos > -1 && data.size > pos) {
            data.removeAt(pos)
            notifyItemRemoved(pos)
            notifyItemRangeChanged(pos, data.size)
        }
    }

    fun add(item: ItemsData) {
        data.add(1, item)
        notifyItemInserted(1)
    }
}