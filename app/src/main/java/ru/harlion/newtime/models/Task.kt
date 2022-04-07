package ru.harlion.newtime.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Task (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val checked: Boolean,
    val skill : String = "",
    val skillCount: Int = 0
)