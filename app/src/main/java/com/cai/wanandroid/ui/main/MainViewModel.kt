package com.cai.wanandroid.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cai.wanandroid.base.BaseViewModel
import com.cai.wanandroid.data.entity.banner.BannerEntity

class MainViewModel(application: Application) : BaseViewModel(application) {
    val bannerData by lazy { MutableLiveData<MutableList<BannerEntity>>() }

    fun getBanner() {
        requestWithBaseResponse(
            requestBlock = {
                apiService.getBanner()
            },
            successBlock = {
                bannerData.postValue(it)
            }
        )
    }

    fun getArticle() {
    }
}