package com.android.gadslearn.views.main.tabs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.gadslearn.network.NetworkRepository
import com.android.gadslearn.network.response.hours.HoursResponse
import com.android.gadslearn.network.response.skill.SkillResponse
import com.codose.bgfs_android.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val repository = NetworkRepository()
    val skills = MutableLiveData<Resource<SkillResponse>>()
    val hours = MutableLiveData<Resource<HoursResponse>>()
    val submission = MutableLiveData<Resource<String>>()


    fun getSkills(){
        skills.value = Resource.Loading()
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val data = repository.getSkills()
                skills.postValue(data)
            }
        }
    }

    fun getHours(){
        hours.value = Resource.Loading()
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val data = repository.getHours()
                hours.postValue(data)
            }
        }
    }

    fun submitApplication(fName : String, lName : String, email : String, link : String){
        submission.value = Resource.Loading()
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val data = repository.submitApplication(fName, lName, email, link)
                submission.postValue(data)
            }
        }
    }

}