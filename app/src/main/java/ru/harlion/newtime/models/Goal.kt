package ru.harlion.newtime.models

class Goal (
    val id : Long,
    val name: String,
    val createDate: Long,
    val deadline : Long,
    val category : String,
    val unit : Int, //единица измерения
    val measure: Int, // мера
    val image: String,
    val prize: String,
    val tasks: List <Task> = listOf()
    )