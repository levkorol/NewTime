package ru.harlion.newtime.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Habit (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val countDays: Int,
    val intervalDays: Int,
    val prize: String,
    val iconId : Int,
    val checkedToday: Boolean = false,
    val dateStart : Long,
    val skill : String = "",
    val skillCount: Int = 0,
    val isActive: Boolean = true
)