package com.android.gadslearn.utils

import android.app.Application
import android.content.ContextWrapper
import com.codose.bgfs_android.utils.Converters
import com.pixplicity.easyprefs.library.Prefs

class GadsApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        initPref()
    }

    private fun initPref() {
        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
    }
}
