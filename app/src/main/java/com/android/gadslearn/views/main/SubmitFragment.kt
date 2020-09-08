package com.android.gadslearn.views.main

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.gadslearn.R
import com.android.gadslearn.views.main.tabs.MainViewModel
import com.codose.bgfs_android.utils.Resource
import com.android.gadslearn.views.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_submit.*

class SubmitFragment : BaseFragment() {
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_submit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frag_submit_back_btn.setOnClickListener {
            goBack()
        }
        frag_submit_btn.setOnClickListener {
            handleSubmission()
        }
    }

    private fun handleSubmission() {
        if(frag_submit_email_text_edit.text.isNullOrBlank()){
            frag_submit_email_text_layout.error = "Email Required"
            return
        }else{
            frag_submit_email_text_layout.error = ""
        }
        if(frag_submit_first_text_edit.text.isNullOrBlank()){
            frag_submit_first_text_layout.error = "First Name Required"
            return
        }else{
            frag_submit_first_text_layout.error = ""
        }
        if(frag_submit_last_text_edit.text.isNullOrBlank()){
            frag_submit_last_text_layout.error = "Last Name Required"
            return
        }else{
            frag_submit_last_text_layout.error = ""
        }
        if(frag_submit_link_text_edit.text.isNullOrBlank()){
            frag_submit_link_text_layout.error = "Submission Link Required"
            return
        }else{
            frag_submit_link_text_layout.error = ""
        }
        val fName = frag_submit_first_text_edit.text.toString()
        val lName = frag_submit_last_text_edit.text.toString()
        val email = frag_submit_email_text_edit.text.toString()
        val link = frag_submit_link_text_edit.text.toString()
        viewModel.submitApplication(fName, lName, email, link)
        Handler().postDelayed({
            showToast("Submission in progress")
            goBack()
        },3000)
        viewModel.submission.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading -> {
                    showProgress()
                }
                is Resource.Success -> {
                    val data = it.data
                    showToast(data)
                    goBack()
                    hideProgress()
                }
                is Resource.Failure -> {
                    hideProgress()
                }
            }
        })
    }

    private fun hideProgress() {
        submit_progress.visibility = View.GONE
    }

    private fun showProgress() {
        submit_progress.visibility = View.VISIBLE
    }

}