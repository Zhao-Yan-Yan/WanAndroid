package com.cai.wanandroid.data.entity.article

import com.google.gson.annotations.SerializedName

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: 文章item tag
 * @CreateDate: 2020/9/2 17:49
 */
data class Tag(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)