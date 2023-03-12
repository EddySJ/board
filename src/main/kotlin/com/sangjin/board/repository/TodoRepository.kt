package com.sangjin.board.repository

import com.sangjin.board.repository.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface TodoRepository : JpaRepository<Todo, Long> {

}
