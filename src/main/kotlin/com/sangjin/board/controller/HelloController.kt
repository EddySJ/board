package com.sangjin.board.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(): List<String> {
        return listOf("안녕하세요", "Hello")
    }

}
