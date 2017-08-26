package com.cc.demo.kotlin.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.cc.demo.kotlin.R

/**
 * Created by zhangyu on 2017/8/26 17:29.
 */
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tv: TextView = itemView.findViewById(R.id.mli_tv) as TextView
    internal var mOnHolderViewClick: OnHolderViewClick? = null

    var mOnClickListener: View.OnClickListener = View.OnClickListener() { v ->
        when (v.id) {
            R.id.mli_tv -> if (mOnHolderViewClick != null) {
                mOnHolderViewClick?.onTvClick(adapterPosition)
            }
        }
    }

    init {
        tv.setOnClickListener(mOnClickListener)
    }


    interface OnHolderViewClick {
        fun onTvClick(position: Int)
    }

    fun setOnHolderClick(holderOnClick: OnHolderViewClick) {
        mOnHolderViewClick = holderOnClick
    }
}