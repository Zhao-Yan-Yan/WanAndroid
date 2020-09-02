package com.cai.wanandroid.base.loading

import com.cai.wanandroid.base.loading.adapter.ContentAdapter
import com.cai.wanandroid.base.loading.adapter.EmptyAdapter
import com.cai.wanandroid.base.loading.adapter.ErrorAdapter
import com.cai.wanandroid.base.loading.adapter.LoadingAdapter

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/2 15:53
 */

class LoadingControl(
    private val adapters: MutableMap<Class<Adapter<out ViewHolder>>, Adapter<out ViewHolder>>,
    val viewHolders: MutableMap<Adapter<out ViewHolder>, ViewHolder>,
    val loadingLayout: LoadingLayout
) {
    fun showLoading() = show(LoadingAdapter::class.java)

    fun showError() = show(ErrorAdapter::class.java)

    fun showEmpty() = show(EmptyAdapter::class.java)

    fun showSuccess() = show(ContentAdapter::class.java)

    fun show(adapterCls: Class<out Adapter<*>>) {
        checkAdapter(adapterCls)
        for (key in adapters.keys) {
            if (key == adapterCls) {
                val adapter = adapters[key]
                adapter?.let {
                    loadingLayout.show(getAdapter(key), viewHolders[it])
                }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Adapter<out ViewHolder>> getAdapter(adapterCls: Class<out Adapter<*>>) =
        adapters[adapterCls] as T

    private fun checkAdapter(adapterCls: Class<out Adapter<*>>) {
        if (!adapters.containsKey(adapterCls)) {
            throw IllegalArgumentException("${adapterCls.simpleName} adapter未注册")
        }
    }
}