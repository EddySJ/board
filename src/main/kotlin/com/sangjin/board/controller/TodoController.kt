package com.sangjin.board.controller

import com.sangjin.board.controller.dto.ResponseDto
import com.sangjin.board.controller.dto.TodoDto
import com.sangjin.board.service.TodoService
import org.springframework.web.bind.annotation.*


@CrossOrigin(originPatterns = ["http://localhost:3000"])
@RestController
@RequestMapping("/todo")
class TodoController(

    private val todoService: TodoService,

    ) {

    @GetMapping("/getAll")
    fun getAll(): ResponseDto<List<TodoDto>> {
        return ResponseDto.Success(todoService.getAll().map { it.toDto() })
    }

    @GetMapping("/get")
    fun get(@RequestParam id: Long): ResponseDto<TodoDto?> {
        return ResponseDto.Success(todoService.get(id)?.toDto())
    }

    @PostMapping("/create")
    fun create(@RequestBody dto: TodoDto): ResponseDto<TodoDto> {
        return ResponseDto.Success(todoService.save(dto.toEntity()).toDto())
    }

    @PostMapping("/update")
    fun update(@RequestBody dto: TodoDto): ResponseDto<TodoDto> {
        return ResponseDto.Success(todoService.update(dto.toEntity()).toDto())
    }

    @PostMapping("/delete")
    fun delete(@RequestParam id: Long): ResponseDto<TodoDto?> {
        return ResponseDto.Success(todoService.delete(id)?.toDto())
    }


}
