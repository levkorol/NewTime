package ru.harlion.newtime.data

import android.content.Context
import androidx.room.Room
import ru.harlion.newtime.models.Goal
import ru.harlion.newtime.models.Habit
import ru.harlion.newtime.models.Skill
import ru.harlion.newtime.models.Task
import java.util.concurrent.Executors


private const val DATABASE_NAME = "new_time-database"

class Repository private constructor(context: Context) {

    private val database: DataBaseApp = Room.databaseBuilder(
        context.applicationContext,
        DataBaseApp::class.java,
        DATABASE_NAME
    ).allowMainThreadQueries()
        .build()

    private val goalDao = database.goalDao()
    private val taskDao = database.taskDao()
    private val habitDao = database.habitDao()
    private val executor = Executors.newSingleThreadExecutor()


    fun addHabit(habit: Habit) {
        executor.execute {
            habitDao.addHabit(habit)
        }
    }

    fun getHabits(): List<Habit> {
        return habitDao.getHabits()
    }

    fun addGoal(goal : Goal) {
        executor.execute {
            goalDao.addGoal(goal)
        }
    }

    fun getGoals(): List<Goal> {
        return goalDao.getGoals()
    }

    companion object {
        private var INSTANCE: Repository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = Repository(context)
            }
        }

        fun get(): Repository {
            return INSTANCE ?: throw IllegalStateException("Repository must be init")
        }

        fun getTasks() = listOf<Task>(

        )

        fun getSkill() = listOf(
            Skill(1, "Работа"),
            Skill(1, "Здоровье"),
            Skill(1, "Карьера"),
            Skill(1, "Отдых"),
            Skill(1, "Личная жизнь"),
        )
    }
}