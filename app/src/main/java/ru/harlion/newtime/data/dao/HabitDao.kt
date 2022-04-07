package ru.harlion.newtime.data.dao

import androidx.room.Dao
import androidx.room.Insert
import ru.harlion.newtime.models.Habit

@Dao
interface HabitDao {

    @Insert
    fun addHabit(habit: Habit)


}