package com.sangjin.board.controller.dto

sealed class ResponseDto<T> (

    val success: Boolean,
    val data: T? = null,


    ) {

    class Success<T>(data: T): ResponseDto<T>(true, data)

    class Error<T>(): ResponseDto<T>(false)

}
