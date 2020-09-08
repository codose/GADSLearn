package com.android.gadslearn.views.main

import android.app.Dialog
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
import kotlinx.android.synthetic.main.confirm_dialog.view.*
import kotlinx.android.synthetic.main.fragment_submit.*
import kotlinx.android.synthetic.main.success_dialog.view.*

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
        showSubmissionDialog(fName, lName, email, link)

    }

    private fun showSubmissionDialog(
        fName: String,
        lName: String,
        email: String,
        link: String
    ) {
        val dialog = Dialog(requireContext())
        val view = layoutInflater.inflate(R.layout.confirm_dialog,null)
        dialog.setContentView(view)
        view.cancel_button.setOnClickListener {
            dialog.dismiss()
        }
        view.dialog_submit_btn.setOnClickListener {
            viewModel.submitApplication(fName, lName, email, link)
            Handler().postDelayed({
                showSucessDialog()
            },3000)
            viewModel.submission.observe(viewLifecycleOwner, Observer {
                when(it){
                    is Resource.Loading -> {
                        dialog.dismiss()
                        showProgress()
                    }
                    is Resource.Success -> {
                        val data = it.data
                        showToast(data)
                        showSucessDialog()
                        hideProgress()
                    }
                    is Resource.Failure -> {
                        hideProgress()
                        showFailureDialog()
                    }
                }
            })
        }
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    private fun showFailureDialog() {
        val dialog = Dialog(requireContext())
        val view = layoutInflater.inflate(R.layout.success_dialog,null)
        dialog.setContentView(view)
        view.success_image.setImageResource(R.drawable.ic_warn)
        view.success_text_ii.text = "Submission Failed"
        view.success_cancel_button.setOnClickListener {
            dialog.dismiss()
        }
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    private fun showSucessDialog() {
        val dialog = Dialog(requireContext())
        val view = layoutInflater.inflate(R.layout.success_dialog,null)
        dialog.setContentView(view)
        view.success_cancel_button.setOnClickListener {
            dialog.dismiss()
            goBack()
        }
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }


    private fun hideProgress() {
        submit_progress.visibility = View.GONE
    }

    private fun showProgress() {
        submit_progress.visibility = View.VISIBLE
    }

}