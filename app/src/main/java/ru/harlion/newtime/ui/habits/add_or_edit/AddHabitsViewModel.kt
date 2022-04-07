package ru.harlion.newtime.ui.habits.add_or_edit

import androidx.lifecycle.ViewModel
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.models.Habit

class AddHabitsViewModel : ViewModel() {

    private val repo = Repository.get()

    fun addHabit(
        name: String,
        countDays: Int,
        intervalDays: Int,
        iconId: Int,
        skill: String,
        prize: String,
        skillCount: Int
    ) {
        val habit = Habit(
            name = name,
            countDays = countDays,
            intervalDays = intervalDays,
            iconId = iconId,
            skill = skill,
            prize = prize,
            skillCount = skillCount,
            dateStart = System.currentTimeMillis()
        )

        repo.addHabit(habit)
    }
}