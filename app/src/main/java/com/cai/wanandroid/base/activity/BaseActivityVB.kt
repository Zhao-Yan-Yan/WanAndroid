package com.cai.wanandroid.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.cai.wanandroid.base.BaseViewModel
import com.cai.wanandroid.base.PageStateDelegate
import com.cai.wanandroid.base.getViewBindingForActivity
import com.cai.wanandroid.base.loading.Adapter
import com.cai.wanandroid.base.loading.Loading
import com.cai.wanandroid.base.loading.ViewHolder
import com.cai.wanandroid.base.loading.adapter.ContentAdapter
import com.cai.wanandroid.base.loading.adapter.ErrorAdapter
import com.cai.wanandroid.base.loading.adapter.LoadingAdapter

/**
 *
 * ViewModel初始化
 * 正常情况
 * ```
 * class MyComponentActivity : ComponentActivity() {
 *     val viewModel: MyViewModel by viewModels()
 * }
 * ```
 */
abstract class BaseActivityVB<VB : ViewBinding> : AppCompatActivity() {
    lateinit var viewBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = getViewBindingForActivity(layoutInflater)
        setContentView(viewBinding.root)
        initStatusBar()
        initPage()
        bindViewEvent()
        registerObserve()
    }

    abstract fun initPage()

    open fun initStatusBar() {}

    open fun bindViewEvent() {}

    open fun registerObserve() {}

}