package com.wys.home

import com.wys.base_lib.base.BaseRepository

/**
 *  author : wys
 *  date : 2020/4/20 23:22
 *  description :
 */
class HomeRepository : BaseRepository() {
    suspend fun getText():String{
        return "修改后的首页"
    }
}