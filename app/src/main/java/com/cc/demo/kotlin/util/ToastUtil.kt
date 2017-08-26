package com.cc.demo.kotlin.util

import android.widget.Toast
import com.cc.demo.kotlin.base.BaseApplication

/**
 * Created by zhangyu on 2017/8/26 19:51.
 */
class ToastUtil {
    //companion object 静态变量和方法
    companion object {

        var mToast: Toast? = null
        internal fun showToastShort(text: String) {
            mToast?.cancel()
            mToast = Toast.makeText(BaseApplication.mContext, text, Toast.LENGTH_SHORT)
            mToast?.show()
        }
    }

}