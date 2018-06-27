package skullper.world.selector.api

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import skullper.world.selector.api.responses.GameWorldsResponse

/**
 * Created by skullper on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

interface Api {

    @POST("BKLoginServer.woa/wa/worlds")
    @FormUrlEncoded
    fun signIn(@Field("login") login: String,
               @Field("password") password: String,
               @Field("deviceType") type: String,
               @Field("deviceId") uniqueId: String): Call<GameWorldsResponse>
}