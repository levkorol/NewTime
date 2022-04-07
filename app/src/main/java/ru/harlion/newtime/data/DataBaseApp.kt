package ru.harlion.newtime.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.harlion.newtime.data.dao.GoalDao
import ru.harlion.newtime.data.dao.HabitDao
import ru.harlion.newtime.data.dao.TaskDao
import ru.harlion.newtime.models.Goal
import ru.harlion.newtime.models.Habit
import ru.harlion.newtime.models.Task


@Database(entities = [Goal::class, Habit::class, Task::class], exportSchema = false, version = 1)
abstract class DataBaseApp : RoomDatabase() {

    abstract fun goalDao() : GoalDao
    abstract fun habitDao() : HabitDao
    abstract fun taskDao() : TaskDao
}