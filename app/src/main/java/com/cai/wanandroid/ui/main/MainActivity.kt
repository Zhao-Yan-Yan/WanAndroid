package com.cai.wanandroid.ui.main

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.FragmentUtils
import com.blankj.utilcode.util.ToastUtils
import com.cai.wanandroid.R
import com.cai.wanandroid.base.activity.BaseActivityVB
import com.cai.wanandroid.base.activity.BaseActivityVBVM
import com.cai.wanandroid.base.loading.adapter.ErrorAdapter
import com.cai.wanandroid.base.loading.adapter.LoadingAdapter
import com.cai.wanandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivityVBVM<ActivityMainBinding, MainViewModel>() {

    override fun initPage() {
        FragmentUtils.replace(supportFragmentManager, MainFragment(), R.id.frame)
    }

    override fun bindViewEvent() {
        super.bindViewEvent()
        viewBinding.msg.setOnClickListener {
            viewModel.getBanner()
        }
    }

    override fun registerObserve() {
        super.registerObserve()
        viewModel.bannerData.observe(this, Observer {
            ToastUtils.showShort(it.size)
        })
    }
}