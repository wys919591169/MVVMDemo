package com.wys.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wys.base_lib.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  author : wys
 *  date : 2020/4/15 18:28
 *  description :
 */
class MainActivity : BaseActivity() {
    private val fragmentList = arrayListOf<Fragment>()
    private val homeFragment by lazy { HomeFragment() }
    private val homeFragment2 by lazy { HomeFragment() }
    private val homeFragment3 by lazy { HomeFragment() }
    private val homeFragment4 by lazy { HomeFragment() }

    init {
        fragmentList.run {
            add(homeFragment)
            add(homeFragment2)
            add(homeFragment3)
            add(homeFragment4)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        initViewPager()
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelected)
    }

    override fun initData() {
    }

    private fun switchFragment(position: Int): Boolean {
        main_viewpager.setCurrentItem(position, false)
        return true
    }

    private val onNavigationItemSelected = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.tab_home -> {
                switchFragment(0)
            }
            R.id.tab_category -> {
                switchFragment(1)
            }
            R.id.tab_cart -> {
                switchFragment(2)
            }
            R.id.tab_mine -> {
                switchFragment(3)
            }
        }
        true
    }

    private fun initViewPager() {
        main_viewpager.isUserInputEnabled = false
        main_viewpager.offscreenPageLimit = 2
        main_viewpager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int) = fragmentList[position]

            override fun getItemCount() = fragmentList.size
        }
    }
}