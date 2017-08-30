package com.cc.demo.kotlin.manager.songlist

import com.cc.demo.kotlin.bean.SongBean

/**
 * 歌单管理接口
 * Created by ZhangYu on 2017/8/30
 */
interface ISongList {

    /**
     * 获取歌单名称
     */
    fun getSongBookName(): String

    /**
     * 获取歌单id
     */
    fun getSongBookId(): Int

    /**
     * 获取歌单内的歌曲列表
     */
    fun getSongList(): List<SongBean>

    /**
     * 向歌单添加歌曲
     */
    fun addSong(song: SongBean)

    /**
     * 从歌单删除歌曲
     */
    fun deleteSong(song: SongBean)

    /**
     * 从歌单获取歌曲
     */
    fun getSong(songName: String)
}