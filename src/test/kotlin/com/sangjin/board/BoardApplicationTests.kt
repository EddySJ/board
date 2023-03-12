package com.sangjin.board

import com.sangjin.board.repository.TodoRepository
import com.sangjin.board.repository.entity.Todo
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BoardApplicationTests(

	private val todoRepository: TodoRepository,

) {


	@Test
	fun contextLoads() {

		todoRepository.save(Todo(
			body = "TEST_123"
		))

		val a = 1

	}

}
