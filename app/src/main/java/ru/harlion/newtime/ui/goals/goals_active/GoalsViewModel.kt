package ru.harlion.newtime.ui.goals.goals_active

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.models.Goal

class GoalsViewModel : ViewModel() {

    private val repo = Repository.get()

    val goals = MutableLiveData<List<Goal>>()

    fun getGoals () {
        goals.value = repo.getGoals()
    }
}