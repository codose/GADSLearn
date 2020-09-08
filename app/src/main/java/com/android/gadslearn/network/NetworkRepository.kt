package com.android.gadslearn.network

import com.android.gadslearn.network.api.RetrofitClient
import com.android.gadslearn.network.response.hours.HoursResponse
import com.android.gadslearn.network.response.skill.SkillResponse
import com.codose.bgfs_android.utils.Resource

class NetworkRepository {
    private val api = RetrofitClient.apiService()
    private val gApi = RetrofitClient.googleApiService()
    suspend fun getHours() : Resource<HoursResponse>{
        return try {
            val data = api.getHours().await()
            Resource.Success(data)
        }catch (t : Throwable){
            Resource.Failure(t.message!!)
        }
    }

    suspend fun getSkills() : Resource<SkillResponse>{
        return try {
            val data = api.getSkills().await()
            Resource.Success(data)
        }catch (t : Throwable){
            Resource.Failure(t.message!!)
        }
    }

    suspend fun submitApplication(fName : String, lName : String, email : String, link : String) : Resource<String>{
        return try {
            gApi.submitApplication(fName,lName,email,link).await()
            Resource.Success("Submission Successful")
        }catch (t : Throwable){
            Resource.Failure(t.message!!)
        }
    }
}