package com.kaibo.demo.meteor.controller

import com.kaibo.demo.meteor.dto.BaseResult
import lombok.extern.log4j.Log4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Duration

/**
 * @author kaibo
 * @date 2019/9/16 18:18
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@RestController
@RequestMapping("/open/redis")
class RedisTestController {

    @Autowired
    private lateinit var redisTemplate: RedisTemplate<String, String>

    @PostMapping("/saveTest")
    fun saveTest(@RequestBody map: Map<String, String>): BaseResult<Any> {
        val operations: ValueOperations<String, String> = redisTemplate.opsForValue()
        map.forEach { (key, value) ->
            operations.set(key, value, Duration.ofSeconds(10))
        }
        return BaseResult.OK
    }

}
