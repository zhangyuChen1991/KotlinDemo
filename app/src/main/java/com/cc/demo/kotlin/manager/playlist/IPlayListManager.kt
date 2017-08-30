package com.cc.demo.kotlin.manager.playlist

import com.cc.demo.kotlin.bean.SongBean
import com.cc.demo.kotlin.bean.SongBookBean

/**
 * 播放列表管理接口
 * Created by ZhangYu on 2017/8/30.
 */
interface IPlayListManager {


    /**
     * 设置当前播放列表
     */
    fun setCurPlayList(playList: SongBookBean)

    /**
     * 将指导歌曲移动到指定位置
     */
    fun moveSongTo(song: SongBean, targetPosition: Int)

    /**
     * 设置当前播放歌曲
     */
    fun setCurPlaySong(song: SongBean)

    /**
     * 设置下一曲播放歌曲(考虑用 moveSongTo()实现 )
     */
    fun setNextPlaySong()


}