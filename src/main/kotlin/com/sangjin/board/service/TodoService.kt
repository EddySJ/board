package com.sangjin.board.service

import com.sangjin.board.repository.TodoRepository
import com.sangjin.board.repository.entity.Todo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class TodoService(

    private val todoRepository: TodoRepository,

    ) {

    @Transactional
    fun getAll(): List<Todo> {
        val ret = todoRepository.findAll().filter {
            !it.deleted
        }

        return ret
    }

    @Transactional
    @OptIn(ExperimentalStdlibApi::class)
    fun get(todoSeq: Long): Todo? {
        val ret = todoRepository.findById(todoSeq).getOrNull()

        if (ret?.deleted == false) {
            return ret
        }

        return null
    }

    fun update(todo: Todo): Todo {
        val origin = get(todo.seq!!)!!
        origin.completed = todo.completed
        origin.deleted = todo.deleted
        origin.body = todo.body

        return save(origin)
    }

    fun save(todo: Todo): Todo {
        return todoRepository.save(todo)
    }

    fun delete(todoSeq: Long): Todo? {
        val ret = get(todoSeq) ?: return null

        ret.deleted = true
        return save(ret)
    }

}
