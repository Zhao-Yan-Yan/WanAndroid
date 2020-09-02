package com.cai.config

object GlobalDependency {
    const val kotlin_version = "1.3.72"

    object Google {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
        const val appcompat = "androidx.appcompat:appcompat:1.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.3.0"
        const val material = "com.google.android.material:material:1.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val vectorDrawable = "androidx.vectordrawable:vectordrawable:1.1.0"
        const val navigationFragment = "androidx.navigation:navigation-fragment:2.2.2"
        const val navigationUi = "androidx.navigation:navigation-ui:2.2.2"
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
        const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.2.2"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:2.2.2"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
        const val viewpager2 = "androidx.viewpager2:viewpager2:1.1.0-alpha01"
        const val Gson = "com.google.code.gson:gson:2.8.6"
        const val flexBox = "com.google.android:flexbox:2.0.1"
    }

    const val lottie = "com.airbnb.android:lottie:3.4.1"
    const val litePal = "org.litepal.guolindev:core:3.2.1"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.4"
    const val immersionBar = "com.gyf.immersionbar:immersionbar:3.0.0"
    const val bannerViewPager = "com.github.zhpanvip:BannerViewPager:3.1.4"
    const val magicIndicator = "com.github.hackware1993:MagicIndicator:1.5.0"
    const val autoSize = "me.jessyan:autosize:1.2.1"
    const val bugly = "com.tencent.bugly:crashreport:3.2.33"
    const val PickerView = "com.contrarywind:Android-PickerView:4.1.9"
    const val MMKV = "com.tencent:mmkv-static:1.2.0"
    const val androidUtilCode = "com.blankj:utilcodex:1.29.0"
    const val QMUI = "com.qmuiteam:qmui:2.0.0-alpha10"
    const val multiType = "com.drakeet.multitype:multitype:4.2.0"

    object Retrofit {
        private const val ver = "2.9.0"
        const val retrofit2 = "com.squareup.retrofit2:retrofit:${ver}"
        const val retrofit2ConverterGson = "com.squareup.retrofit2:converter-gson:${ver}"
    }

    object MaterialDialog {
        private const val ver = "3.3.0"
        const val core = "com.afollestad.material-dialogs:core:${ver}"
        const val input = "com.afollestad.material-dialogs:input:${ver}"
        const val files = "com.afollestad.material-dialogs:files:${ver}"
        const val color = "com.afollestad.material-dialogs:color:${ver}"
        const val datetime = "com.afollestad.material-dialogs:datetime:${ver}"
        const val bottomSheets = "com.afollestad.material-dialogs:bottomsheets:${ver}"
    }

    object Aria {
        private const val ver = "3.8.5"
        const val core = "com.arialyy.aria:core:${ver}"
        const val compiler = "com.arialyy.aria:compiler:${ver}"
    }

    object Room {
        private const val ver = "2.2.5"
        const val RunTime = "androidx.room:room-runtime:${ver}"
        const val ktx = "androidx.room:room-ktx:${ver}"
        const val compiler = "androidx.room:room-compiler:${ver}"
    }

    object PermissionsDispatcher {
        private const val ver = "4.7.0"
        const val permissionsDispatcher = "org.permissionsdispatcher:permissionsdispatcher:${ver}"
        const val processor = "org.permissionsdispatcher:permissionsdispatcher-processor:${ver}"
    }

    object OkHttp {
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.7.2"
    }

    object SmartRefreshLayout {
        private const val ver = "2.0.1"
        const val kernel = "com.scwang.smart:refresh-layout-kernel:${ver}"
        const val headerClassics = "com.scwang.smart:refresh-header-classics:${ver}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:4.11.0"
        const val transformations = "jp.wasabeef:glide-transformations:4.1.0"
    }

    object AliYun {
        const val Player = "com.aliyun.sdk.android:AliyunPlayer:4.5.0-full"
        const val Conan = "com.alivc.conan:AlivcConan:0.9.5"

    }

    object Test {
        const val junit = "junit:junit:4.12"
        const val junitExt = "androidx.test.ext:junit:1.1.1"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
        const val AndroidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

}