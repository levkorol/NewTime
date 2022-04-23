package ru.harlion.newtime.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.harlion.newtime.models.Goal

@Dao
abstract class GoalDao {

    @Insert
    abstract fun addGoal(goal: Goal)

    @Query("SELECT * FROM goal")
    abstract  fun getGoals(): List<Goal>

}