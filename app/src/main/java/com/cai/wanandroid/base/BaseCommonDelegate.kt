package com.cai.wanandroid.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.cai.wanandroid.base.activity.BaseActivityVB
import com.cai.wanandroid.base.fragment.BaseFragmentVB
import java.lang.reflect.ParameterizedType

/**
 * @ProjectName: WanAndroid
 * @Author: 赵岩
 * @Description: TODO
 * @CreateDate: 2020/9/1 15:23
 */
@Suppress("UNCHECKED_CAST")
fun <VB : ViewBinding> BaseActivityVB<VB>.getViewBindingForActivity(
    layoutInflater: LayoutInflater
): VB {
    val type = javaClass.genericSuperclass as ParameterizedType
    val aClass = type.actualTypeArguments[0] as Class<*>
    val method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
    return method.invoke(null, layoutInflater) as VB
}

@Suppress("UNCHECKED_CAST")
fun <VB : ViewBinding> BaseFragmentVB<VB>.getViewBindingForFragment(
    layoutInflater: LayoutInflater,
    container: ViewGroup?
): VB {
    val type = javaClass.genericSuperclass as ParameterizedType
    val aClass = type.actualTypeArguments[0] as Class<*>
    val method = aClass.getDeclaredMethod(
        "inflate",
        LayoutInflater::class.java,
        ViewGroup::class.java,
        Boolean::class.java
    )
    return method.invoke(null, layoutInflater, container, false) as VB
}

@Suppress("UNCHECKED_CAST")
fun <VM> getVmClazz(obj: Any): VM {
    val type = obj.javaClass.genericSuperclass as ParameterizedType
    return type.actualTypeArguments[1] as VM
}