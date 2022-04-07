package ru.harlion.newtime.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.harlion.newtime.models.Habit

@Dao
interface HabitDao {

    @Insert
    fun addHabit(habit: Habit)

    @Update
    fun updateHabit(habit: Habit)

    @Query("DELETE FROM habit WHERE id = :habitId")
    fun deleteHabitById(habitId : Long)

    @Query("SELECT * FROM habit")
    fun getHabits(): List<Habit>
}