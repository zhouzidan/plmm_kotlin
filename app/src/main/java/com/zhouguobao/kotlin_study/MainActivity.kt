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

        recyclerView.layoutManager = GridLayoutManager(this, 1)
        var datas = ArrayList<ImgGroup>()
        datas.add(ImgGroup(1, 1, "https://imgsa.baidu.com/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=b214b363d754564ef168ec6bd2b7f7e7/7e3e6709c93d70cfc087257df2dcd100baa12b45.jpg", ""))
        datas.add(ImgGroup(1, 1, "https://imgsa.baidu.com/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=b214b363d754564ef168ec6bd2b7f7e7/7e3e6709c93d70cfc087257df2dcd100baa12b45.jpg", ""))
        datas.add(ImgGroup(1, 1, "https://imgsa.baidu.com/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=b214b363d754564ef168ec6bd2b7f7e7/7e3e6709c93d70cfc087257df2dcd100baa12b45.jpg", ""))
        datas.add(ImgGroup(1, 1, "https://imgsa.baidu.com/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=80a0e826da160924c828aa49b56e5e9f/f636afc379310a5585445184bd4543a982261059.jpg", ""))
        datas.add(ImgGroup(1, 1, "http://i.uu87657.com/k/880_55m/T/UGirls/T23/t23_001_s2r_3840_5760.jpg", ""))
        datas.add(ImgGroup(1, 1, "http://i.uu87657.com/k/880_55m/T/UGirls/T23/t23_001_s2r_3840_5760.jpg", ""))
        datas.add(ImgGroup(1, 1, "http://i.uu87657.com/k/880_55m/T/UGirls/T23/t23_001_s2r_3840_5760.jpg", ""))
        datas.add(ImgGroup(1, 1, "http://i.uu87657.com/k/880_55m/T/UGirls/T23/t23_001_s2r_3840_5760.jpg", ""))
        datas.add(ImgGroup(1, 1, "http://i.uu87657.com/k/880_55m/T/UGirls/T23/t23_001_s2r_3840_5760.jpg", ""))
        datas.add(ImgGroup(1, 1, "http://i.uu87657.com/k/880_55m/T/UGirls/T23/t23_001_s2r_3840_5760.jpg", ""))
        datas.add(ImgGroup(1, 1, "http://i.uu87657.com/k/880_55m/T/UGirls/T23/t23_001_s2r_3840_5760.jpg", ""))
        datas.add(ImgGroup(1, 1, "http://i.uu87657.com/k/880_55m/T/UGirls/T23/t23_001_s2r_3840_5760.jpg", ""))
        datas.add(ImgGroup(1, 1, "http://i.uu87657.com/k/880_55m/T/UGirls/T23/t23_001_s2r_3840_5760.jpg", ""))
        recyclerView.adapter = GridAdapter(this, datas) {
            Toast.makeText(this, "点击的那个imageGroup是：$it", Toast.LENGTH_SHORT).show()
        }
    }

    class ClickCallback(val imgGroup: ImgGroup)
}
