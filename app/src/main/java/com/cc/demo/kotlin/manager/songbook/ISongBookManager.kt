package com.cc.demo.kotlin.manager.songbook

import com.cc.demo.kotlin.bean.SongBookBean

/**
 * 歌单列表管理接口
 * Created by ZhangYu on 2017/8/30.
 */
interface ISongBookManager {
    /**
     * 获取全部已创建歌单
     */
    fun getAllBook(): List<SongBookBean>

    /**
     * 创建一个新的歌单
     * @return true 创建成功;  false 创建失败
     */
    fun createSongBook(listBean: SongBookBean): Boolean

    /**
     * 根据id删除一个歌单
     * @return true 删除成功;  false 删除失败
     */
    fun deleteSongBook(id: Int): Boolean

    /**
     * 根据列表名删除一个歌单
     * @return true 删除成功;  false 删除失败
     */
    fun deleteSongBook(bookName: String): Boolean

    /**
     * 根据id替换列表名
     */
    fun renameSongBook(id: Int, newBookName: String): Boolean

    /**
     * 根据列表名替换歌单名
     * (列表名不允许重复)
     */
    fun renameSongBook(oldBookName: String, newBookName: String): Boolean
}