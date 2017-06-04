package com.zhouguobao.kotlin_study

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_img.view.*

/**
 * Created by zhou on 2017/6/4.
 */
class GridAdapter(val context: Context
                  , val datas: List<ImgGroup>
                  , val listener: (ImgGroup) -> Unit) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_img, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(position, datas, listener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int
                 , datas: List<ImgGroup>
                 , listener: (ImgGroup) -> Unit)
                = with(itemView) {
            val imgGroup = datas.get(position)
            imageView.loadUrl(imgGroup.firstImgUrl)
//            Picasso.with(GlobalApp.instance()).load(imgGroup.firstImgUrl).into(imageView)
            setOnClickListener { listener(imgGroup) }
        }
    }
}