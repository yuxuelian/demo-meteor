package com.kaibo.demo.meteor.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * @author kaibo
 * @date 2019/9/16 15:50
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */


@RestController
class Index {

    @GetMapping("/")
    fun index(): Any {
        return "首页"
    }

    @GetMapping("/ping")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun ping() {
    }

}
