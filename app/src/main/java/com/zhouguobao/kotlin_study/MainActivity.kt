package com.zhouguobao.kotlin_study


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.addItemDecoration(SpacesItemDecoration(8))
        var datas = DBManager.instance.getImageGroupList()
        recyclerView.adapter = GridAdapter(this, datas) {
            Toast.makeText(this, "点击的那个imageGroup是：$it", Toast.LENGTH_SHORT).show()
        }
    }

    class ClickCallback(val imgGroup: ImgGroup)
}
