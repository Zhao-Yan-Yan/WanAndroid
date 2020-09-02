package com.cai.wanandroid.base.loading

import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.cai.wanandroid.base.loading.adapter.ContentAdapter

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/1 19:06
 */
class LoadingLayout(context: Context) : FrameLayout(context) {
    private var contentView: View? = null
    private var alphaAnimation: ObjectAnimator? = null

    fun setOriginContentView(targetView: View) {
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        contentView = targetView
        addView(targetView, layoutParams)
    }

    fun show(adapter: Adapter<ViewHolder>?, viewHolder: ViewHolder?) {
        //保证只用一个Content
        if (childCount > 1) {
            removeViewAt(1)
        }
        if (adapter != null && viewHolder != null) {
            if (adapter is ContentAdapter && contentView != null) {
                contentView?.visibility = View.VISIBLE
                val alphaAnimation = ObjectAnimator.ofFloat(contentView, "alpha", 0.0f, 1.0f)
                alphaAnimation.duration = 300
                alphaAnimation.start()
            } else {
                addView(viewHolder.rootView)
                contentView?.visibility = View.INVISIBLE
                viewHolder.rootView.visibility = View.VISIBLE
                rootView.clearAnimation()
                if (alphaAnimation == null) {
                    alphaAnimation = ObjectAnimator.ofFloat(viewHolder.rootView, "alpha", 0.0f, 1.0f)
                    alphaAnimation?.duration = 150
                }
                alphaAnimation?.start()
                adapter.onBindViewHolder(viewHolder)
            }
        }
    }
}
