package com.sangjin.board.repository.entity

import com.sangjin.board.controller.dto.TodoDto
import jakarta.persistence.*

@Entity
@Table(name = "todo", catalog = "study")
data class Todo (

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq: Long? = null,

    @Column(name = "completed")
    var completed: Boolean = false,

    @Column(name = "deleted")
    var deleted: Boolean = false,


    @Column(name = "body")
    var body: String,

) {

    fun toDto() = TodoDto(
        id = seq,
        checked = completed,
        text = body,
    )
}
