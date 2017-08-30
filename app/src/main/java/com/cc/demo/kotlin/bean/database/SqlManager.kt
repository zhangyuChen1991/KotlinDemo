package com.cc.demo.kotlin.bean.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase

/**
 * 一个Manager对应一个数据库，对库内的表进行管理操作
 * Created by zhangyu on 2016-06-07 11:08.
 */
class SqlManager(context: Context, name: String) {
    internal var sqlHelper: SqlHelper ? = null

    init {
        sqlHelper = SqlHelper(context, name, null!!, 1)
    }

    /**
     * 执行sql语句命令 实现增、删、改等功能
     *
     * @param sql sql语句
     */
    fun doSql(sql: String): Boolean {
        try {
            val db = sqlHelper?.writableDatabase
            db?.execSQL(sql)
            db?.close()
            //insert into table ("列名1",itemNum,exceptedRst) values("值1",0,"vvvYes");
            return true
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }

    }

    /**
     * 执行sql语句命令 实现增、删、改等功能
     *
     * @param sql    sql语句
     * @param params 参数
     */
    fun doSql(sql: String, params: Array<Any>): Boolean {

        try {
            val db = sqlHelper?.writableDatabase
            db?.execSQL(sql, params)
            db?.close()
            //"update " + table + " set exceptedRst = ?,realRst = ?,isPass = ? where pageNum = ? and itemNum = ?;", new Object[]{}
            //"delete from " + table + " where pageNum = ? and itemNum = ?;", new Integer[]{pageNum, itemNum}
            return true
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }

    }


    /**
     * 插入数据
     *
     * @param table
     * @param values
     * @return
     */
    fun insertData(table: String, values: ContentValues): Boolean {
        val ret: Boolean
        val db = sqlHelper?.writableDatabase
        val result = db?.insert(table, "nullColumn", values)
        db?.close()
        return if (result == -1L) false else true
    }


    /**
     * 删除所有数据
     * @param table 表名
     * @return
     */
    fun deleteAllDatas(table: String): Boolean {
        try {
            val db = sqlHelper?.writableDatabase
            db?.execSQL("delete from  $table where 1=1;")
            db?.close()
            return true
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }

    }

    /**
     * 查找数据
     *
     * @return
     */
    fun seleteDatas(sql: String, params: Array<String>): Cursor? {
        var cursor: Cursor? = null//"select * from " + table + " where pageNum = ? and itemNum =?;"
        try {
            val db = sqlHelper?.readableDatabase

            cursor = db?.rawQuery(sql, params)
            cursor!!.close()
            db?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return cursor
    }

    /**
     * 取出所有数据
     *
     * @return
     */
    fun getAllDatas(table: String): Cursor? {
        var cursor: Cursor? = null
        try {
            val db = sqlHelper?.readableDatabase
            cursor = db?.rawQuery("select * from  $table ;", null)
            db?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return cursor
    }
}
