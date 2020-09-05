package com.codose.bgfs_android.utils

import android.app.Application

class BgfsApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        
    }
    
        private fun setAppTheme() {
        if(PrefsUtil.isDarkMode()){
            Converters.setThemeMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else{
            Converters.setThemeMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
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
