package com.riku.land.cs.wanointernprototype.controller

import com.google.gson.Gson
import com.riku.land.cs.bousaiknowledge.model.MyItem
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable


/**
 * Created by riku_maehara on 16/11/24.>
 */
class BousaiService() {
    val BASE_URL = "https://bousai4-sasurai-usagi3.c9users.io/"

    fun BousaiService(): Unit {
    }


    fun bousaiGetContentClient(): Observable<MyItem> {
        var gson: Gson = Gson()
        val okClient = OkHttpClient()
        var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        return retrofit.create(BousaiRepository::class.java).getContent()
    }

    fun bousaiClient(opinion: String, content: String): Observable<MyItem> {
        var gson: Gson = Gson()
        val okClient = OkHttpClient()
        var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        return retrofit.create(BousaiRepository::class.java).postContent(0, 0, opinion, content)
    }
}

