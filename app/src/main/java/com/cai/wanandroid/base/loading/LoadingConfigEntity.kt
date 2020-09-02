package com.cai.wanandroid.base.loading

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/2 18:20
 */
data class LoadingConfigEntity(
    var showToolBar: Boolean = false,
    var enableEmptyReLoad: Boolean = true,
    var enableErrorReLoad: Boolean = true,
    var loadingMessage: String? = "拼命加载中...",
    var emptyMessage: String? = "这里什么都没有",
    var errorMessage: String? = "好像出了点问题"
)