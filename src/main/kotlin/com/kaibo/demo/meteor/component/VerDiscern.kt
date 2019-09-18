package com.kaibo.demo.meteor.component

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.kaibo.demo.meteor.retrofit.RetrofitApi
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.HashMap

/**
 * @author kaibo
 * @date 2019/9/17 16:55
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@Component
class VerDiscern {
    companion object {
        private val baseRequestParm = mapOf(
                "user" to "yuxuelian",
                "pass" to "qwert12345",
                "softid" to "901498",
                "codetype" to "1004")
    }

    @Autowired
    private lateinit var retrofitApi: RetrofitApi

    @Autowired
    private lateinit var gson: Gson

    /**
     * base64格式的验证码图片 获取验证码字符串
     */
    fun base64ParseVer(base64Data: String): Single<String> {
        val parmMap = HashMap(baseRequestParm)
        parmMap["file_base64"] = base64Data
        val requestBody = okhttp3.RequestBody.create(MediaType.get("application/json"), gson.toJson(parmMap))
        return retrofitApi.base64VerDiscern(requestBody).map { responseBody: ResponseBody ->
            // 获取 pic_str 字段
            gson.fromJson(responseBody.string(), JsonObject::class.java)["pic_str"].asString
        }
    }

    /**
     * 字节数组格式的验证码图片  获取验证码字符串
     */
    fun fileParseVer(fileData: ByteArray): Single<String> {
        val parts: MutableList<MultipartBody.Part> = LinkedList()
        // 基础参数
        baseRequestParm.forEach { (key, value) ->
            parts.add(MultipartBody.Part.createFormData(key, value))
        }
        // 文件
        val fileRequestBody = okhttp3.RequestBody.create(null, fileData)
        // filename必须填写
        val filePart = MultipartBody.Part.createFormData("userfile", "userfile.png", fileRequestBody)
        parts.add(filePart)
        // 异步请求
        return retrofitApi.fileVerDiscern(parts).map { responseBody: ResponseBody ->
            // 获取 pic_str 字段
            gson.fromJson(responseBody.string(), JsonObject::class.java)["pic_str"].asString
        }
    }
}


