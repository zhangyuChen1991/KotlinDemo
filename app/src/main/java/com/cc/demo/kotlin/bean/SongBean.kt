package com.cc.demo.kotlin.bean

/**
 * Created by ZhangYu on 2017/8/30.
 */
class SongBean {

    //所属歌单id
    var songBookId: Int? = 0

    //歌曲名
    var name: String = ""

    //播放时长
    var duration: Int = 0

    //本地文件路径
    var filePath: String? = ""

    //是否有本地文件
    var isLocalFile: Boolean? = false
}