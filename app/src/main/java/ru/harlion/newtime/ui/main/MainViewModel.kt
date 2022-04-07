package ru.harlion.newtime.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.models.Habit

class MainViewModel: ViewModel() {

    private val repo = Repository.get()
    var habits = MutableLiveData<List<Habit>>()

    fun getHabits() {
        habits.value = repo.getHabits()
    }
}