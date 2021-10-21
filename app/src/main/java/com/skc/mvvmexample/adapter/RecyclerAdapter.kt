package com.skc.mvvmexample.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skc.mvvmexample.R
import com.skc.mvvmexample.model.IceCream

/**

@author Saravana kumar Chinnaraj
@Date 18,October,2021
@version 1.0
 */
class RecyclerAdapter(context : Context, iceCreamList : List<IceCream>) : RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

    var iceCreamList = iceCreamList
    var context      = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val item = this.iceCreamList.get(position)

       holder.nameTxtView.text = item.name
       holder.descTxtView.text = item.description
       Glide.with(context).load(item.image).into(holder.imageView)
    }

    fun refreshAdapter(iceCreamList : List<IceCream>) {
        this.iceCreamList = iceCreamList
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return this.iceCreamList.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView    = itemView.findViewById<ImageView>(R.id.item_image_tv)
        val nameTxtView  = itemView.findViewById<TextView>(R.id.item_name_tv)
        val descTxtView  = itemView.findViewById<TextView>(R.id.item_desc_tv)
    }
}