package com.cai.wanandroid

import android.app.Application
import org.litepal.LitePal

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/1 16:25
 */

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        globalContext = this
        LitePal.initialize(this)
    }

    companion object {
        lateinit var globalContext: Application
    }
}