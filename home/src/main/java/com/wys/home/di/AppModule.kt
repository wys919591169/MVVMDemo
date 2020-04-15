package com.wys.home.di

import com.wys.home.api.RetrofitClient
import com.wys.home.api.ApiService
import org.koin.dsl.module

/**
 * Created by luyao
 * on 2019/11/15 15:44
 */

val viewModelModule = module {
}

val repositoryModule = module {
    single { RetrofitClient.getService(ApiService::class.java, ApiService.BASE_URL) }
}

val appModule = listOf(viewModelModule, repositoryModule)