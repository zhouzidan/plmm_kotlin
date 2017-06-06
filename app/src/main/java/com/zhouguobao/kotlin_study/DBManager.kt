package com.zhouguobao.kotlin_study

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.RowParser
import org.jetbrains.anko.db.SqlOrderDirection
import org.jetbrains.anko.db.select
import java.io.File

class DBManager() {
    var database: SQLiteDatabase? = null

    init {
        initDatabase()
    }

    companion object {
        val DB_NAME = "plmm.db"
        val DB_PATH = "/data/data/" + GlobalApp.instance().packageName + "/databases/" + DB_NAME;
        val instance by lazy { DBManager() }
    }

    fun initDatabase() {
        if (database == null || !database?.isOpen!!) {
            val dbFile = File(DB_PATH);
            if (dbFile.exists() == false){
                dbFile.parentFile.mkdirs()
                dbFile.createNewFile()
               val ios = GlobalApp.instance().assets.open(DB_NAME)
                dbFile.writeBytes(ios.readBytes())
                ios.close()
            }
            database = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READONLY)
        }
    }

    /**
     * 关闭数据库
     */
    fun closeDatabase() {
        if (database != null && database!!.isOpen) {
            database?.close()
            database = null
        }
    }

    fun getImageGroupList(): ArrayList<ImgGroup> {
        var results = ArrayList<ImgGroup>()
        database!!.select("img_group")
                .orderBy("star", SqlOrderDirection.DESC)
                .limit(100)
                .columns("id", "first_url", "alt")
                .parseList(object : RowParser<ImgGroup> {
                    override fun parseRow(columns: Array<Any?>): ImgGroup {
                        val id = columns[0] as Long
                        val firstImgUrl = columns[1] as String
                        val alt = columns[2] as String
                        val imgGroup = ImgGroup(id, firstImgUrl, alt)
                        results.add(imgGroup)
                        return imgGroup
                    }
                })
        return results

    }


}