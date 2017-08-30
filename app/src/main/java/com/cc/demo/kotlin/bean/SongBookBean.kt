package com.cc.demo.kotlin.bean

import com.cc.demo.kotlin.manager.songlist.ISongList

/**
 * 歌单
 * Created by ZhangYu on 2017/8/30.
 */
class SongBookBean {
    var listName: String = ""
    var id: Int = 0
    var songList: ISongList? = null
}