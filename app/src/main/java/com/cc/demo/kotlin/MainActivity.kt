package com.cc.demo.kotlin

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.cc.demo.kotlin.adapter.MainListAdapter
import com.cc.demo.kotlin.bean.MainListItemBean
import com.cc.demo.kotlin.holder.ViewHolder
import com.cc.demo.kotlin.util.ToastUtil

class MainActivity : AppCompatActivity() {
    val mContext by lazy { this } //这里使用了委托，表示只有使用到mContext才会执行该段代码
    //? 说明变量可为空
    var mRcv: RecyclerView? = null
    var mTitleTv: TextView? = null

    var mAdapter: MainListAdapter? = null
    var mDatas: ArrayList<MainListItemBean> = ArrayList<MainListItemBean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initView()

    }

    private fun initData() {
        for (i in 0..19) {
            var data = MainListItemBean()
            data.itemName = "" + i
            mDatas.add(data)
        }
    }

    private fun initView() {
        mRcv = findViewById(R.id.main_rcv) as RecyclerView
        mTitleTv = findViewById(R.id.main_tv1) as TextView
        mTitleTv?.setText("主页目录")


        var mLinearLayoutManager = LinearLayoutManager(this)
        mAdapter = MainListAdapter(this)
        mAdapter?.setViewClickListener(HolderViewClickListener())

        mRcv?.layoutManager = mLinearLayoutManager
        mRcv?.adapter = mAdapter

        mAdapter?.mDatas = mDatas
        mAdapter?.notifyDataSetChanged()

    }

    inner class HolderViewClickListener : ViewHolder.OnHolderViewClick {
        override fun onTvClick(position: Int) {
            ToastUtil.showToastShort("$position")
        }
    }
}
