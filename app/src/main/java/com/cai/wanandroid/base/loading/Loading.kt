package com.cai.wanandroid.base.loading

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/1 16:50
 */
class Loading {

    private var adapters = mutableMapOf<Class<Adapter<out ViewHolder>>, Adapter<out ViewHolder>>()
    private var viewHolders = mutableMapOf<Adapter<out ViewHolder>, ViewHolder>()
    fun register(adapter: Adapter<*>): Loading {
        if (!adapters.containsKey(adapter.javaClass)) {
            adapters[adapter.javaClass] = adapter
        }
        return this
    }

    fun bind(targetView: View): LoadingControl {
        val contentParent = targetView.parent as ViewGroup?
        var childIndex = 0
        val childCount = contentParent?.childCount ?: 0
        for (i in 0 until childCount) {
            if (contentParent?.getChildAt(i) == targetView) {
                childIndex = i
                break
            }
        }
        contentParent?.removeView(targetView)
        val targetLayoutParams = targetView.layoutParams
        val loadingLayout = LoadingLayout(targetView.context)
        loadingLayout.setOriginContentView(targetView)
        contentParent?.addView(loadingLayout, childIndex, targetLayoutParams)
        handleVH(targetView.context, contentParent)
        return LoadingControl(adapters, viewHolders, loadingLayout)
    }

    fun bind(activity: Activity): LoadingControl {
        val contentParent = activity.findViewById<ViewGroup>(android.R.id.content)
        val childIndex = 0
        val originContentView = contentParent.getChildAt(childIndex)
        contentParent.removeView(originContentView)
        val layoutParams = originContentView.layoutParams
        val loadingLayout = LoadingLayout(originContentView.context)
        loadingLayout.setOriginContentView(originContentView)
        contentParent.addView(loadingLayout, childIndex, layoutParams)
        handleVH(activity, contentParent)
        return LoadingControl(adapters, viewHolders, loadingLayout)
    }

    private fun handleVH(
        context: Context,
        contentParent: ViewGroup?
    ) {
        adapters.forEach {
            val viewHolder = viewHolders[it.value]
            if (viewHolder == null) {
                viewHolders[it.value] =
                    it.value.onCreateViewHolder(context,LayoutInflater.from(context), contentParent)
            }
        }
    }
}