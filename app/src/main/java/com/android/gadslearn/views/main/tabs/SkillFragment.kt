package com.android.gadslearn.views.main.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.gadslearn.R
import com.android.gadslearn.adapter.SkillsClickListener
import com.android.gadslearn.adapter.SkillsRecyclerAdapter
import com.codose.bgfs_android.utils.Resource
import com.android.gadslearn.views.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_skill.*

class SkillFragment : BaseFragment() {
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private lateinit var adapter : SkillsRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getSkills()
        adapter = SkillsRecyclerAdapter(requireContext(), SkillsClickListener {

        })
        skill_rv.adapter = adapter
        viewModel.skills.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading -> {
                    showProgress()
                }
                is Resource.Success -> {
                    val data = it.data
                    adapter.submitList(data)
                    hideProgress()
                }
                is Resource.Failure -> {
                    hideProgress()
                }
            }
        })
    }

    private fun hideProgress() {
        skill_progress.visibility = View.GONE
    }

    private fun showProgress() {
        skill_progress.visibility = View.VISIBLE
    }

}