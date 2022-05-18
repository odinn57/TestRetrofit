package com.odinn.testretrofit.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {
    private var mInstance: NetworkService? = null

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private var mRetrofit:Retrofit

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInstance(): NetworkService {
        if (mInstance == null){
            mInstance = NetworkService()
        }
        return mInstance as NetworkService
    }

    fun getJSONApi(): JSONPlaceHolderApi = mRetrofit.create(JSONPlaceHolderApi::class.java)
}