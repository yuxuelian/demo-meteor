package com.kaibo.demo.meteor.dao.pojo

import com.kaibo.demo.meteor.annotation.OpenNoArg
import java.io.Serializable

/**
 * @author kaibo
 * @date 2019/9/16 16:12
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@OpenNoArg
data class User(
        val username: String,
        val password: String,
        val id: Long = -1
) : Serializable {

    companion object {
        val EMPTY = User("", "")
    }
}
