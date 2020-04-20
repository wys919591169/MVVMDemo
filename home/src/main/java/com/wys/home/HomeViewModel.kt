package com.wys.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wys.base_lib.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *  author : wys
 *  date : 2020/4/20 23:21
 *  description :
 */
class HomeViewModel(private val homeRepository: HomeRepository) : BaseViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name
    fun getName(){
        launchOnUI {
            _name.value = withContext(Dispatchers.IO){
                homeRepository.getText()
            }
        }
    }
}