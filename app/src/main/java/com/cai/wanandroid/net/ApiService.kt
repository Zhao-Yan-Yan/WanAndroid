package com.cai.wanandroid.net

import com.cai.wanandroid.data.entity.article.ArticleEntity
import com.cai.wanandroid.data.entity.banner.BannerEntity
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: Api
 * @CreateDate: 2020/9/2 17:28
 */
interface ApiService {

    /**
     * 首页banner
     */
    @GET("banner/json")
    suspend fun getBanner(): BaseResponse<MutableList<BannerEntity>>

    /**
     * 首页文章列表
     */
    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int = 1): BaseResponse<BaseResponseWithPage<ArticleEntity>>

}