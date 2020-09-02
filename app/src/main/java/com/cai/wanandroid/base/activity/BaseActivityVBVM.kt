package com.cai.wanandroid.base.activity

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.cai.wanandroid.base.BaseViewModel
import com.cai.wanandroid.base.PageStateDelegate
import com.cai.wanandroid.base.getVmClazz

abstract class BaseActivityVBVM<VB : ViewBinding, VM : BaseViewModel> : BaseActivityVB<VB>() {
    private lateinit var pageStateDelegate: PageStateDelegate
    lateinit var viewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = createViewModel()
        pageStateDelegate = PageStateDelegate(this, viewModel)
        super.onCreate(savedInstanceState)
        pageStateDelegate.bind(this)
    }

    override fun registerObserve() {
        pageStateDelegate.register()
        super.registerObserve()
    }

    open fun createViewModel(): VM = ViewModelProvider(
        this, ViewModelProvider.AndroidViewModelFactory(application)
    ).get(getVmClazz(this))
}