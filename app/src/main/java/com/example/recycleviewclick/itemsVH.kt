package com.example.recycleviewclick

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_lin.view.*

class itemsVH(view : View) : RecyclerView.ViewHolder(view) {

    val imageURL: String? =
        "https://a.d-cd.net/a590b1u-960.jpg"

    fun bind(item: ItemsData){

        Picasso.get().load(imageURL ?: "")
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(itemView.image)

        itemView.title.text = item.title
        itemView.desc.text = item.desc

    }
}

