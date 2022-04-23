package ru.harlion.newtime.ui.goals.add_or_edit

import androidx.lifecycle.ViewModel
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.models.Goal

class EditGoalViewModel : ViewModel() {

    private val repo = Repository.get()

    fun addGoal(
        name: String,
        deadline: Long,
        unit: String,
        measure: Int,
        image: String,
        prize: String,
        ) {
        val goal = Goal(
            name = name,
            createDate = System.currentTimeMillis(),
            deadline = deadline,
            unit = unit,
            measure = measure,
            image = "",
            prize = prize,
            skill = "",
            skillCount = 0
        )
        repo.addGoal(goal)
    }
}