package com.cai.wanandroid.base

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.cai.wanandroid.base.loading.Loading
import com.cai.wanandroid.base.loading.LoadingControl
import com.cai.wanandroid.base.loading.adapter.ContentAdapter
import com.cai.wanandroid.base.loading.adapter.ErrorAdapter
import com.cai.wanandroid.base.loading.adapter.LoadingAdapter

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/2 18:31
 */
class PageStateDelegate(
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: BaseViewModel
) {
    val loading = Loading().register(LoadingAdapter())
        .register(ContentAdapter())
        .register(ErrorAdapter())
    private lateinit var loadingControl: LoadingControl
    val loadingLayout: ViewGroup by lazy { loadingControl.loadingLayout }

    fun bind(activity: Activity) {
        loadingControl = loading.bind(activity)
    }

    fun bind(view: View) {
        loadingControl = loading.bind(view)
    }

    fun register() {
        viewModel.pageStateChange.showLoading.observe(lifecycleOwner, Observer {
            loadingControl.showLoading()
        })
        viewModel.pageStateChange.showEmpty.observe(lifecycleOwner, Observer {
            loadingControl.showEmpty()
        })
        viewModel.pageStateChange.showError.observe(lifecycleOwner, Observer {
            loadingControl.showError()
        })
        viewModel.pageStateChange.showContent.observe(lifecycleOwner, Observer {
            loadingControl.showSuccess()
        })
    }
}