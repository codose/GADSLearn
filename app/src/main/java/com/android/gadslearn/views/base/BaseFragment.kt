package com.android.gadslearn.views.base

import android.os.Build
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.android.gadslearn.R
import com.google.android.material.snackbar.Snackbar

open class BaseFragment : Fragment() {

    fun showToast(message : String){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }

    fun showSnackBar(message: String){
        view?.let {
            Snackbar.make(it, message, Snackbar.LENGTH_LONG).show()
        }
    }

    fun goBack(){
        requireActivity().onBackPressed()
    }

//    fun hideBottomNav() {
//        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        bottomNavigationView?.visibility = View.GONE
//        val header = activity?.findViewById<TextView>(R.id.main_header_text)
//        val imgBtn = activity?.findViewById<ImageButton>(R.id.main_header_toggle)
//        header?.visibility = View.GONE
//        imgBtn?.visibility = View.GONE
//    }

    fun setDarkStatusBar() {
        @RequiresApi(Build.VERSION_CODES.M)
        activity?.window?.statusBarColor = activity!!.getColor(R.color.colorPrimary)
        @RequiresApi(Build.VERSION_CODES.M)
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
    }

    fun setLightStatusBar() {
        @RequiresApi(Build.VERSION_CODES.M)
        activity?.window?.statusBarColor = activity!!.getColor(R.color.colorPrimary)
        @RequiresApi(Build.VERSION_CODES.M)
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

//    fun showBottomNav() {
//        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        bottomNavigationView?.visibility = View.VISIBLE
//        val header = activity?.findViewById<TextView>(R.id.main_header_text)
//        val imgBtn = activity?.findViewById<ImageButton>(R.id.main_header_toggle)
//        header?.visibility = View.VISIBLE
//        imgBtn?.visibility = View.VISIBLE
//    }

}