package com.cai.wanandroid.base.loading

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/1 17:17
 */
abstract class Adapter<VH : ViewHolder> {
    internal lateinit var listener: (adapter: Adapter<ViewHolder>) -> Unit

    abstract fun onCreateViewHolder(
        context: Context,
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): VH

    abstract fun onBindViewHolder(holder: VH)

    @Suppress("UNCHECKED_CAST")
    fun notifyDataSetChanged() = listener.invoke(this as Adapter<ViewHolder>)
}