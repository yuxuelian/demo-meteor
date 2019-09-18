package com.kaibo.demo.meteor.config

import com.kaibo.demo.meteor.retrofit.RetrofitApi
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.time.Duration

/**
 * @author kaibo
 * @date 2019/9/17 12:08
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@Configuration
class RetrofitConfig {

    companion object {
        private const val baseURL = "https://www.kaibo123.com/"

        private const val timeout = 30000L
    }

    @Bean
    fun retrofit(): Retrofit {
        val okHttpClient: OkHttpClient = OkHttpClient
                .Builder()
                .readTimeout(Duration.ofMillis(timeout))
                .writeTimeout(Duration.ofMillis(timeout))
                .callTimeout(Duration.ofMillis(timeout))
                .connectTimeout(Duration.ofMillis(timeout))
                .build()
        return Retrofit
                .Builder()
                .baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .client(okHttpClient)
                .build()
    }

    @Bean
    fun retrofitApi(retrofit: Retrofit): RetrofitApi {
        return retrofit.create(RetrofitApi::class.java)
    }
}
