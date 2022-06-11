package ru.harlion.newtime.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.models.Goal
import ru.harlion.newtime.models.Habit
import ru.harlion.newtime.models.Task

class MainViewModel: ViewModel() {

    private val repo = Repository.get()
    var habits = MutableLiveData<List<Habit>>()
    var tasks = MutableLiveData<List<Task>>()
    var goals = MutableLiveData<List<Goal>>()

    fun getHabits() {
        habits.value = repo.getHabits()
    }
}