package ru.harlion.newtime.data

import android.content.Context
import ru.harlion.newtime.models.Goal
import ru.harlion.newtime.models.Habit
import ru.harlion.newtime.models.Task

class Repository private constructor(context: Context) {

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
            Habit(1, "meditation at morning", true),
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