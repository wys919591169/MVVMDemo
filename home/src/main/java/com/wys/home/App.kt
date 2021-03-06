package com.wys.home

import android.app.Application
import android.content.Context
import com.wys.base_lib.APP_START
import com.wys.base_lib.util.Timer
import com.wys.home.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import kotlin.properties.Delegates

/**
 *  author : wys
 *  date : 2020/4/15 18:28
 *  description :
 */
class App : Application() {

    companion object {
        var CONTEXT: Context by Delegates.notNull()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Timer.start(APP_START)
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }

    }
}