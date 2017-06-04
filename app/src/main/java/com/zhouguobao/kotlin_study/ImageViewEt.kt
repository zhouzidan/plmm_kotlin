package com.zhouguobao.kotlin_study

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by zhou on 2017/6/4.
 */

fun ImageView.loadUrl(url: String) {
    //图片框架
    Picasso.with(GlobalApp.instance())
            .load(url)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher_round).into(this)
}
