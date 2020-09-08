package com.android.gadslearn.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/*
Created by
Oshodin Osemwingie

on 20/07/2020.
*/

class MainTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){
    var fragments = ArrayList<Fragment>()
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}