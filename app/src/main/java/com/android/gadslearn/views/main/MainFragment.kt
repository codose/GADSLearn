package com.android.gadslearn.views.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.android.gadslearn.R
import com.android.gadslearn.adapter.MainTabAdapter
import com.android.gadslearn.views.main.tabs.LearningFragment
import com.android.gadslearn.views.main.tabs.SkillFragment
import com.android.gadslearn.views.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {
    private lateinit var adapter : MainTabAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frag_main_submit_btn.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToSubmitFragment())
        }
        val fragments = ArrayList<Fragment>()
        fragments.add(LearningFragment())
        fragments.add(SkillFragment())
        adapter = MainTabAdapter(this)
        adapter.fragments = fragments
        frag_main_viewpager.adapter = adapter
        TabLayoutMediator(frag_main_tab_layout, frag_main_viewpager) { tab, position ->
            when(position){
                0 -> tab.text = "Learning Leaders"
                1 -> tab.text = "Skill IQ Leaders"
            }
        }.attach()
    }

}