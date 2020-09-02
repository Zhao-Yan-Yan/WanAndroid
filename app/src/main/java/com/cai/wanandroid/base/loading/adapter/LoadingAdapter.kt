package com.cai.wanandroid.base.loading.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.cai.wanandroid.base.loading.Adapter
import com.cai.wanandroid.base.loading.ViewHolder
import com.cai.wanandroid.databinding.LoadingLoadingLayoutBinding

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/2 15:31
 */
class LoadingAdapter : Adapter<LoadingAdapter.Holder>() {
    class Holder(viewBinding: LoadingLoadingLayoutBinding) : ViewHolder(viewBinding)

    override fun onCreateViewHolder(
        context: Context,
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): Holder {
        return Holder(LoadingLoadingLayoutBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: Holder) {
    }

}