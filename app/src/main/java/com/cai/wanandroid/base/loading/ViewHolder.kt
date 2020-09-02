package com.cai.wanandroid.base.loading

import android.view.View
import androidx.viewbinding.ViewBinding

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/1 17:18
 */
open class ViewHolder constructor(view: View) {
    constructor(viewBinding: ViewBinding) : this(viewBinding.root)

    val rootView: View = view
}
