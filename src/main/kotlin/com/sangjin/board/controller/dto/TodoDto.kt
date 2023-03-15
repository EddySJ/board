package com.sangjin.board.controller.dto

import com.sangjin.board.repository.entity.Todo

data class TodoDto(

    val id: Long? = null,
    val text: String,
    val checked: Boolean,

    ) {

    fun toEntity() = Todo(
        seq = id,
        completed = checked,
        body = text
    )

}
