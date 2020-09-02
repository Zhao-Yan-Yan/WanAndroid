package com.cai.wanandroid.ui.main

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.ToastUtils
import com.cai.wanandroid.base.fragment.BaseFragmentVBVM
import com.cai.wanandroid.databinding.FragmentMainBinding

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/2 18:56
 */
class MainFragment : BaseFragmentVBVM<FragmentMainBinding, MainViewModel>() {
    override fun initPageLazy() {

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

    override fun createViewModel(): MainViewModel {
        return activityViewModels<MainViewModel>().value
    }
}