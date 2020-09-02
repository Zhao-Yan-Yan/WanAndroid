package com.cai.wanandroid.net

import com.google.gson.annotations.SerializedName

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/2 17:36
 */
data class BaseResponseWithPage<T>(
    @SerializedName("curPage") val curPage: Int,
    @SerializedName("datas") val datas: MutableList<T>,
    @SerializedName("offset") val offset: Int,
    @SerializedName("over") val over: Boolean,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("total") val total: Int
)