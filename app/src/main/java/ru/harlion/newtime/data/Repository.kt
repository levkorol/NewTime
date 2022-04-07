package ru.harlion.newtime.data

import android.content.Context
import androidx.room.Room
import ru.harlion.newtime.models.Goal
import ru.harlion.newtime.models.Habit
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

        //tests
        fun getHabits() = listOf(
            Habit(1, "name habit", false),
            Habit(1, "meditation at morning meditation at morning meditation at morning meditation at morning meditation at morning", true),
            Habit(1, "name", false),
            Habit(1, "name habit", false),
            Habit(1, "meditation at morning", true),
            Habit(1, "name", false),
        )

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

        fun getGoals() = listOf(
            Goal(1, "Цель", 1,1, "",1,1,"","", listOf()),
            Goal(1, "Цель", 1,1, "",1,1,"","", listOf()),
            Goal(1, "Цель", 1,1, "",1,1,"","", listOf()),
            Goal(1, "Цель", 1,1, "",1,1,"","", listOf()),
            Goal(1, "Цель", 1,1, "",1,1,"","", listOf()),
            Goal(1, "Цель", 1,1, "",1,1,"","", listOf()),
            Goal(1, "Цель", 1,1, "",1,1,"","", listOf()),
            Goal(1, "Цель", 1,1, "",1,1,"","", listOf()),
            Goal(1, "Цель", 1,1, "",1,1,"","", listOf())
        )
    }
}