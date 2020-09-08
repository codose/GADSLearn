package com.android.gadslearn.network.api

import com.android.gadslearn.network.response.hours.HoursResponse
import com.android.gadslearn.network.response.skill.SkillResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("api/hours")
    fun getHours() : Deferred<HoursResponse>

    @GET("api/skilliq")
    fun getSkills() : Deferred<SkillResponse>

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    fun submitApplication(@Field("entry.1877115667") firstName : String,
                          @Field("entry.2006916086") lastName : String,
                          @Field("entry.1824927963") email : String,
                          @Field("entry.284483984") gitHub : String) : Deferred<Void>
}