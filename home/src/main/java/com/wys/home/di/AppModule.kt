package com.wys.home.di

import com.wys.home.HomeRepository
import com.wys.home.HomeViewModel
import com.wys.home.api.RetrofitClient
import com.wys.home.api.ApiService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by WYS
 * on 2019/11/15 15:44
 */

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}

val repositoryModule = module {
    single { RetrofitClient.getService(ApiService::class.java, ApiService.BASE_URL) }
    single { HomeRepository() }
}

val appModule = listOf(viewModelModule, repositoryModule)