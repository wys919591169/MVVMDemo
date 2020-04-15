package com.wys.base_lib.util

import android.util.Log

/**
 *  author : wys
 *  date : 2020/4/15 22:37
 *  description :
 */
object Timer {

    private val tagMap = hashMapOf<String, Long>()

    fun start(tag: String) {
        tagMap[tag] = System.currentTimeMillis()
    }

    fun stop(tag: String) {
        if (!tagMap.containsKey(tag)) return
        val cost = System.currentTimeMillis() - (tagMap[tag] ?: 0)
        tagMap.remove(tag)
        Log.e("timer", "$tag cost : $cost")
    }
}