package ru.harlion.newtime.ui.habits.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.models.Habit

class ActiveHabitsViewModel : ViewModel() {

    private val repo = Repository.get()

    val habits = MutableLiveData<List<Habit>>()

    fun getHabits () {
        habits.value = repo.getHabits()
    }
}