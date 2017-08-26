package com.cc.demo.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cc.demo.kotlin.R
import com.cc.demo.kotlin.bean.MainListItemBean
import com.cc.demo.kotlin.holder.ViewHolder

/**
 * Created by zhangyu on 2017/8/26 17:05.
 */
class MainListAdapter constructor(context: Context) : RecyclerView.Adapter<ViewHolder>() {
    var mContext: Context = context
    internal var mOnHolderViewClick: ViewHolder.OnHolderViewClick? = null


    var mDatas: List<MainListItemBean> = ArrayList<MainListItemBean>()
    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (position < mDatas.size)
            holder?.tv?.text = mDatas[position].itemName
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(mContext).inflate(R.layout.main_list_item, parent, false)
        var holder = ViewHolder(view)
        holder.mOnHolderViewClick = mOnHolderViewClick;
        return holder
    }

    internal fun setViewClickListener(viewClickListener:ViewHolder.OnHolderViewClick){
        mOnHolderViewClick = viewClickListener
    }
}