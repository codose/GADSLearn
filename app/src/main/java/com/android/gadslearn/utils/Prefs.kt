package com.codose.gamebucks.utils

import com.pixplicity.easyprefs.library.Prefs

object PrefsUtil
{

    const val PREF_USER_ID = "UserId"
    const val PREF_STUDENT = "isStudent"
    const val GOOGLE_LOGIN = "GoogleLogin"
    const val USER_NAME = "username"
    const val EMAIL = "email"
    const val PHONE = "phone"
    const val ONBOARDING = "Is_Onboarding"

    fun storeUser(id : String, isStudent : Boolean,username : String,email :String, google : Boolean = false){
        Prefs.putString(PREF_USER_ID,id)
        Prefs.putBoolean(PREF_STUDENT, isStudent)
        Prefs.putString(USER_NAME,username)
        Prefs.putBoolean(GOOGLE_LOGIN,google)
        Prefs.putString(EMAIL,email)
    }

    fun isDarkMode() : Boolean{
        return Prefs.getBoolean("themeMode",true)
    }
    fun isOnboardingDone() : Boolean{
        return Prefs.getBoolean(ONBOARDING,false)
    }

    fun setOnboarding() {
        Prefs.putBoolean(ONBOARDING,true)
    }

    fun setPhone(phone : String){
        Prefs.putString(PHONE,phone)
    }

    fun getPhone() : String{
        return  Prefs.getString(PHONE,"NULL")
    }

    fun isStudent() : Boolean{
        return Prefs.getBoolean(PREF_STUDENT, true)
    }

    fun isGoogleLogin() : Boolean{
        return Prefs.getBoolean(GOOGLE_LOGIN, false)
    }

    fun getUserId() : String{
        return Prefs.getString(PREF_USER_ID,"NULL")
    }

    fun getEmail() : String{
        return Prefs.getString(EMAIL,"NULL")
    }

    fun getUserName() : String{
        return Prefs.getString(USER_NAME,"NULL")
    }
}
