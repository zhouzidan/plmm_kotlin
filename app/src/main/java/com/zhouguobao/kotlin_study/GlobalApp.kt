package com.zhouguobao.kotlin_study

import android.app.Application

/**
 * Created by zhou on 2017/6/4.
 */
class GlobalApp : Application() {
    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}