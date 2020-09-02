package com.cai.wanandroid.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.cai.wanandroid.base.BaseViewModel
import com.cai.wanandroid.base.PageStateDelegate
import com.cai.wanandroid.base.getVmClazz

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/1 15:21
 */
abstract class BaseFragmentVBVM<VB : ViewBinding, VM : BaseViewModel> : BaseFragmentVB<VB>() {
    lateinit var viewModel: VM
    private lateinit var pageStateDelegate: PageStateDelegate

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel = createViewModel()
        pageStateDelegate = PageStateDelegate(this, viewModel)
        pageStateDelegate.bind(viewBinding.root)
        return pageStateDelegate.loadingLayout
    }

    override fun registerObserve() {
        pageStateDelegate.register()
        super.registerObserve()
    }

    /**
     *  @return 复用Activity ViewModel 重写此方法且 return activityViewModels<VM>().value
     */
    open fun createViewModel(): VM = ViewModelProvider(
        this, ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
    ).get(getVmClazz(this))
}