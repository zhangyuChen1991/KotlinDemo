package com.cc.demo.kotlin.manager.player

/**
 * 播放管理接口
 * Created by ZhangYu on 2017/8/30.
 */
interface IPlayerManager {

    /**
     * 播放
     */
    fun play()

    /**
     * 暂停
     */
    fun pause()

    /**
     * 停止
     */
    fun stop()

    /**
     * 获取当前播放状态
     */
    fun getNowPlayState()

    /**
     * 播放上一曲
     */
    fun playLast()

    /**
     * 播放下一曲
     */
    fun playNext()
}