package com.sangjin.board.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "todo", catalog = "study")
data class Todo (

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq: Long? = null,

    @Column(name = "body")
    var body: String,

) {

}
