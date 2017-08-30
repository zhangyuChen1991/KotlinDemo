package com.cc.demo.kotlin.manager.song

import com.cc.demo.kotlin.bean.SongBean

/**
 * 歌曲管理接口
 * 管理播放器中所有存在的歌曲信息，包括本地的和离线的
 * 信息用数据库保存管理
 * Created by ZhangYu on 2017/8/30.
 */
interface ISongManager {

    /**
     * 根据歌单id获取歌曲列表
     */
    fun getSongListBySongBookId(songBookId: Int): List<SongBean>

    /**
     * 根据歌曲名获取歌曲信息
     */
    fun getSongListBySongName(songName: String): SongBean

    /**
     * 添加歌曲
     */
    fun addSong(song: SongBean): Boolean

    /**
     * 根据歌曲名删除歌曲
     */
    fun deleteSong(songName: String): Boolean

    /**
     * 根据歌单名删除所有符合条件的歌曲
     */
    fun deleteSongBySongBookId(songBookId: Int)

}