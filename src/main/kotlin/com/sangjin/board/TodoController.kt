package com.sangjin.board

import com.sangjin.board.repository.TodoRepository
import com.sangjin.board.repository.entity.Todo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class TodoController(

    private val todoRepository: TodoRepository,

) {

    @GetMapping("save")
    fun save(@RequestParam body: String?): String {
        return todoRepository.save(
            Todo(
                body = body ?: ""
            )
        ).toString()
    }

    @GetMapping("getAll")
    fun getAll(): String {
        return todoRepository.findAll().toString()
    }
}
