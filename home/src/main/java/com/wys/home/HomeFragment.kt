package com.wys.home

import androidx.lifecycle.Observer
import com.wys.base_lib.base.BaseVMFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.title_layout.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *  author : wys
 *  date : 2020/4/20 14:42
 *  description :
 */
class HomeFragment : BaseVMFragment<HomeViewModel>(useDataBinding = false){
    override fun initVM(): HomeViewModel =getViewModel ()

    override fun startObserve() {
        mViewModel.run { name.observe(viewLifecycleOwner, Observer {
            it?.let {
                tv_home.text = it
            }
        }) }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        tv_toolbar.setText(R.string.home)
        btn_home.setOnClickListener{
            mViewModel .getName()
        }
    }

    override fun initData() {

    }
}