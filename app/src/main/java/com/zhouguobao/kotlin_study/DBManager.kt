package com.zhouguobao.kotlin_study

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper

class CityCodeDbHelper(ctx: Context = GlobalApp.instance()) : ManagedSQLiteOpenHelper(ctx,
        DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {}
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    companion object {
        val DB_NAME = "plmm.db"
        val DB_VERSION = 1
        val instance by lazy { CityCodeDbHelper() }
    }
}