package com.gox.basemodule

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.lifecycle.MutableLiveData
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import com.gox.basemodule.data.Constant
import com.gox.basemodule.di.component.BaseComponent
import com.gox.basemodule.di.component.DaggerBaseComponent
import com.gox.basemodule.di.modules.NetworkModule
import com.gox.basemodule.utils.LocaleUtils
import com.gox.monitorinternet.InternetConnectivityListener
import com.gox.monitorinternet.MonitorInternet

open class BaseApplication : Application(), InternetConnectivityListener {

    private var mMonitorInternet: MonitorInternet? = null

    val baseComponent: BaseComponent = DaggerBaseComponent.builder()
            .networkModule(NetworkModule())
            .build()

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        baseApplication = this
        MonitorInternet.init(this)
        mMonitorInternet = MonitorInternet.instance!!
        mMonitorInternet!!.addInternetConnectivityListener(this)
        preferences = getSharedPreferences(Constant.CUSTOM_PREFERENCE, Context.MODE_PRIVATE)
        //TestFairy.begin(this, "SDK-OHDYC1Nx");
    }

    companion object {
        lateinit var baseApplication: Context
        private lateinit var preferences: SharedPreferences
        val getCustomPreference: SharedPreferences? get() = preferences
        private val monitorInternetLiveData = MutableLiveData<Boolean>()
        val getInternetMonitorLiveData: MutableLiveData<Boolean> get() = monitorInternetLiveData
    }

    override fun onInternetConnectivityChanged(isConnected: Boolean) {
        println("isConnected = $isConnected")
        getInternetMonitorLiveData.value = isConnected
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(LocaleUtils.setLocale(base!!))
        MultiDex.install(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        LocaleUtils.setLocale(this)
    }

}