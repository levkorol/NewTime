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

    private val projectDao = database.goalDao()
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

        fun getTasks() = listOf(
            Task(1, "task 1", false),
            Task(1, "task 2", false),
            Task(1, "task 3", false),
            Task(1, "task 1", false),
            Task(1, "task 2", false),
            Task(1, "task 3", false),
            Task(1, "task 1", false),
            Task(1, "task 2", false),
            Task(1, "task 3", false),
        )

        fun getGoals() = listOf<Goal>(
//            Goal(1, "Цель", 1, 1, "", 1, 1, "", ""),
//            Goal(1, "Цель", 1, 1, "", 1, 1, "", ""),
//            Goal(1, "Цель", 1, 1, "", 1, 1, "", ""),
//            Goal(1, "Цель", 1, 1, "", 1, 1, "", ""),
//            Goal(1, "Цель", 1, 1, "", 1, 1, "", ""),
//            Goal(1, "Цель", 1, 1, "", 1, 1, "", ""),
//            Goal(1, "Цель", 1, 1, "", 1, 1, "", ""),
//            Goal(1, "Цель", 1, 1, "", 1, 1, "", ""),
//            Goal(1, "Цель", 1, 1, "", 1, 1, "", "")
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