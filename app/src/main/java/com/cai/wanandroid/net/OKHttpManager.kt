package com.cai.wanandroid.net

import android.annotation.SuppressLint
import com.cai.wanandroid.App
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*
/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/2 17:18
 */
object OKHttpManager {

    private var mMyTrustManager = MyTrustManager()

    var okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .cache(getCache())
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        //.addInterceptor(TokenInterceptor())
        .sslSocketFactory(createSSLSocketFactory(), mMyTrustManager)
        //.proxy(Proxy.NO_PROXY)
        .hostnameVerifier(TrustAllHostnameVerifier())
        .build()

    private fun getCache(): Cache {
        val size: Long = 10 * 1024 * 1024
        val httpCacheDirectory = File(App.globalContext.externalCacheDir, "net_cache")
        return Cache(httpCacheDirectory, size)
    }

    private fun createSSLSocketFactory(): SSLSocketFactory {
        var ssfFactory: SSLSocketFactory? = null
        try {
            val sc = SSLContext.getInstance("TLS")
            sc.init(null, arrayOf(mMyTrustManager), SecureRandom())
            ssfFactory = sc.socketFactory
        } catch (ignored: Exception) {
            ignored.printStackTrace()
        }
        return ssfFactory!!
    }

    class MyTrustManager : X509TrustManager {
        @SuppressLint("TrustAllX509TrustManager")
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {

        }

        @SuppressLint("TrustAllX509TrustManager")
        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        }

        override fun getAcceptedIssuers(): Array<X509Certificate> {
            return arrayOf()
        }
    }

    class TrustAllHostnameVerifier : HostnameVerifier {
        @SuppressLint("BadHostnameVerifier")
        override fun verify(hostname: String?, session: SSLSession?): Boolean {
            return true
        }
    }

}