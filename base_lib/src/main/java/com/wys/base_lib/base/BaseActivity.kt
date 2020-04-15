package com.wys.base_lib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *  author : wys
 *  date : 2020/4/15 18:33
 *  description :
 */
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initView()
//        setSupportActionBar(mToolbar)
        initData()
    }

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()

}