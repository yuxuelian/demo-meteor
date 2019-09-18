package com.kaibo.demo.meteor.dao

import com.kaibo.demo.meteor.dao.pojo.User

/**
 * @author kaibo
 * @date 2019/9/16 16:15
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

interface UserDao {

    fun findById(id: Long): User?

    fun findAll(): List<User>

    fun save(user: User): Boolean

    fun deleteById(id: Long): Boolean
}
