package com.kaibo.demo.meteor.retrofit

import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

/**
 * @author kaibo
 * @date 2019/9/17 13:27
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

interface RetrofitApi {

    @POST("http://upload.chaojiying.net/Upload/Processing.php")
    fun base64VerDiscern(@Body requestBody: RequestBody): Single<ResponseBody>

    @Multipart
    @POST("http://upload.chaojiying.net/Upload/Processing.php")
    fun fileVerDiscern(@Part parts: List<MultipartBody.Part>): Single<ResponseBody>
}
