package com.cc.demo.kotlin.base

import android.app.Application
import android.content.Context

/**
 * Created by zhangyu on 2017/8/26 19:52.
 */
class BaseApplication : Application() {
    internal companion object {
        var mContext : Context? = null
    }
     override fun onCreate() {
        super.onCreate()
         mContext = this
    }
}