package com.cai.wanandroid.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.ToastUtils
import com.cai.wanandroid.base.loading.LoadingConfigEntity
import com.cai.wanandroid.net.BaseResponse
import com.cai.wanandroid.net.ExceptionHandle
import com.cai.wanandroid.net.NetException
import com.cai.wanandroid.net.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/1 16:15
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    val apiService by lazy { RetrofitFactory.mainApiService }

    val pageStateChange: PageStateChange = PageStateChange()

    inner class PageStateChange {
        val showLoadingDialog by lazy { MutableLiveData<String>() }
        val dismissLoadingDialog by lazy { MutableLiveData<Void>() }
        val showEmpty by lazy { MutableLiveData<LoadingConfigEntity>() }
        val showContent by lazy { MutableLiveData<Boolean>() }
        val showError by lazy { MutableLiveData<LoadingConfigEntity>() }
        val showLoading by lazy { MutableLiveData<LoadingConfigEntity>() }
    }

    fun <T> request(
        requestBlock: suspend () -> T,
        successBlock: (T) -> Unit = {},
        errorBlock: (t: Throwable) -> Unit = {}
    ) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) { requestBlock.invoke() }
                successBlock.invoke(response)
            } catch (e: Exception) {
                handleException(errorBlock, e)
            }
        }
    }

    fun <T> requestWithBaseResponse(
        requestBlock: suspend () -> BaseResponse<T>,
        successBlock: (T) -> Unit = {},
        errorBlock: (t: Throwable) -> Unit = {},
        loadingConfig: LoadingConfigEntity = LoadingConfigEntity()
    ) {
        viewModelScope.launch {
            try {
                pageStateChange.showLoading.postValue(loadingConfig)
                val response = withContext(Dispatchers.IO) { requestBlock.invoke() }
                when {
                    response.isSuccess() -> {
                        pageStateChange.showContent.postValue(true)
                        successBlock.invoke(response.data)
                    }
                    else -> throw NetException(response.errorCode, response.errorMsg)
                }
            } catch (e: Exception) {
                val tipStr = handleException(errorBlock, e)
                pageStateChange.showError.postValue(loadingConfig.also {
                    it.errorMessage = tipStr
                })
            }
        }
    }

    private fun handleException(
        errorBlock: (t: Throwable) -> Unit,
        e: Exception
    ): String {
        errorBlock.invoke(e)
        e.printStackTrace()
        val handleException = ExceptionHandle.handleException(e)
        val tipStr = "${handleException.errorMsg} + (${handleException.errorCode})"
        ToastUtils.showShort(tipStr)
        return tipStr
    }
}