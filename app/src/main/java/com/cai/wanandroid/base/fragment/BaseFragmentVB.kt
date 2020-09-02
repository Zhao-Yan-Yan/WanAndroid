package com.cai.wanandroid.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.cai.wanandroid.base.getViewBindingForFragment

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/1 15:19
 *
 * ViewModel初始化
 * 正常情况
 * ```
 * class MyFragment : Fragment() {
 *     val viewModel: MYViewModel by viewModels()
 * }
 * ```
 *
 * 复用Activity的ViewModels
 * ```
 * class MyFragment : Fragment() {
 *     val viewModel: MyViewModel by activityViewModels()
 * }
 * ```
 */
abstract class BaseFragmentVB<VB : ViewBinding> : Fragment() {

    private var enableLoadPage = true
    lateinit var viewBinding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = getViewBindingForFragment(inflater, container)
        initStatusBar()
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        if (enableLoadPage) {
            initPageLazy()
            bindViewEvent()
            registerObserve()
            enableLoadPage = false
        }
    }

    abstract fun initPageLazy()

    open fun initStatusBar() {}

    open fun registerObserve() {}

    open fun bindViewEvent() {}
}
