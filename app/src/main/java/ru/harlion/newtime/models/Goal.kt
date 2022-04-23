package ru.harlion.newtime.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Goal (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val name: String,
    val createDate: Long,
    val deadline : Long,
    val unit : String, //единица измерения
    val measure: Int, // мера
    val image: String,
    val prize: String,
    val skill : String = "",
    val skillCount: Int = 0
    )