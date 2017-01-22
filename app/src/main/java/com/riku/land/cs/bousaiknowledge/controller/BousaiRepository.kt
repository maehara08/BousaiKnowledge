package com.riku.land.cs.wanointernprototype.controller

import com.riku.land.cs.bousaiknowledge.model.MyItem
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import rx.Observable

/**
 * Created by riku_maehara on 16/11/24.
 */

public interface BousaiRepository {

//    @GET("releases.json")
//    fun getAlbumList(): Observable<Relese>
    @FormUrlEncoded
    @POST("votes")
    fun postContent(@Field("kind")kind :Int,
                    @Field("vote_type")voteType:Int,
                    @Field("opinion")opinion:String,
                    @Field("content")content:String) :Observable<MyItem>

    @GET("result?kind=earthquake&vote_type=trouble&age=eighties&area=city&family_structure=has_child")
    fun getContent() :Observable<MyItem>

}