package com.kaibo.demo.meteor

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.kaibo.demo.meteor.dao")
class DemoMeteorApplication

fun main(args: Array<String>) {
    runApplication<DemoMeteorApplication>(*args)
}
