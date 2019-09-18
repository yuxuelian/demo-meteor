package com.kaibo.demo.meteor.controller

import com.kaibo.demo.meteor.dto.BaseResult
import com.kaibo.demo.meteor.dao.UserDao
import com.kaibo.demo.meteor.dao.pojo.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author kaibo
 * @date 2019/9/16 15:25
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@RestController
@RequestMapping("/open/user")
class UserController {

    @Autowired
    private lateinit var userDao: UserDao

    @GetMapping("/findOne")
    fun findOne(@RequestParam("id") id: Long): BaseResult<User?> {
        return BaseResult.of(userDao.findById(id))
    }

    @GetMapping("/findAll")
    fun findAll(): BaseResult<List<User>> {
        return BaseResult.of(userDao.findAll())
    }

    @PostMapping("/save")
    fun save(user: User): BaseResult<Boolean> {
        val save = userDao.save(user)
        return BaseResult.of(save)
    }

    @GetMapping("/delete")
    fun delete(@RequestParam("id") id: Long): BaseResult<Boolean> {
        val save = userDao.deleteById(id)
        return BaseResult.of(save)
    }

    @GetMapping("/test")
    fun getTest2(): String {
        return "其他接口测试"
    }
}
