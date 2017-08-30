package com.cc.demo.kotlin.bean.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.text.TextUtils
import android.util.Log

/**
 * Created by zhangyu on 2016-06-07 10:28.
 */
class SqlHelper(private val context: Context, private val dbName: String     //数据库名
                , factory: SQLiteDatabase.CursorFactory, version: Int) : SQLiteOpenHelper(context, dbName, factory, version) {
    private var createTableOrder: String? = null//建表命令 //"create table tableName (id integer primary key autoincrement,pageNum int,itemNum int,isPass int,notPassInfo varchar(300))"

    override fun onCreate(db: SQLiteDatabase) {
        if (TextUtils.isEmpty(createTableOrder))
            Log.e("SqlHelper", "SqlHelper createTableOrder建表命令为空")
        else
            db.execSQL(createTableOrder)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    /**
     * 删除数据库
     * @return
     */
    fun deleteDatabase(): Boolean {
        return context.deleteDatabase(dbName)
    }

    /**
     * 设置建表命令
     *
     * @param createTableOrder
     */
    fun setCreateTableOrder(createTableOrder: String) {
        this.createTableOrder = createTableOrder
    }
}
