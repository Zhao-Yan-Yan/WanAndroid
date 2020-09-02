package com.cai.wanandroid.base.loading.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cai.wanandroid.base.loading.Adapter
import com.cai.wanandroid.base.loading.ViewHolder

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/2 16:56
 */
class ContentAdapter : Adapter<ViewHolder>() {
    override fun onCreateViewHolder(
        context: Context,
        inflater: LayoutInflater, parent: ViewGroup?
    ): ViewHolder {
        return ViewHolder(View(context))
    }

    override fun onBindViewHolder(holder: ViewHolder) = Unit
}