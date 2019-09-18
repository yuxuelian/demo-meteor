package com.kaibo.demo.meteor.dto

import com.kaibo.demo.meteor.annotation.OpenNoArg

/**
 * @author kaibo
 * @date 2019/9/16 16:58
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@OpenNoArg
data class BaseResult<T>(
        val code: Int,
        val status: String,
        val data: T?
) {

    companion object {
        val OK = BaseResult<Any>(0, "ok", null)
        val ERR = BaseResult<Any>(-1, "error", null)
        fun <T> of(data: T?): BaseResult<T> {
            return BaseResult(0, "ok", data)
        }
    }

}
