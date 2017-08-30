package com.cc.demo.kotlin.util

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.Log
import com.cc.demo.kotlin.base.BaseApplication

/**
 * SharedPreferences二次封装工具类，方便put get各类数据
 * Created by zhangyu on 2016-06-20 14:26.
 */
object SharedPreferencesUtil {
    private val TAG = "SpUtil"
    private val context = BaseApplication.mContext
    private val sp = context!!.getSharedPreferences("cache", Context.MODE_PRIVATE)
    private val editor = sp.edit()

    fun put(key: String, value: String) {
        Log.d(TAG, "key = $key,value = $value")
        editor.putString(key, value)
        editor.commit()
    }

    fun put(key: String, value: Int) {
        editor.putInt(key, value)
        editor.commit()
    }

    fun put(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.commit()
    }

    fun put(key: String, value: Long) {
        editor.putLong(key, value)
        editor.commit()
    }

    fun put(key: String, value: Float) {
        editor.putFloat(key, value)
        editor.commit()
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun put(key: String, value: Set<String>) {
        editor.putStringSet(key, value)
        editor.commit()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sp.getBoolean(key, defaultValue)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return sp.getInt(key, defaultValue)
    }

    fun getFloat(key: String, defaultValue: Float): Float {
        return sp.getFloat(key, defaultValue)
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return sp.getLong(key, defaultValue)
    }

    fun getString(key: String, defaultValue: String): String? {
        return sp.getString(key, defaultValue)
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    fun getStringSet(key: String, defaultValue: Set<String>): Set<String>? {
        return sp.getStringSet(key, defaultValue)
    }

}
