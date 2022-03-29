package ru.harlion.newtime.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.databinding.FragmentMainBinding
import ru.harlion.newtime.ui.dialogs.DialogBottomMenu
import ru.harlion.newtime.ui.goals.adding.AddGoalFragment
import ru.harlion.newtime.ui.habits.adapters.AdapterSmallHabits
import ru.harlion.newtime.ui.habits.adding.AddHabitFragment
import ru.harlion.newtime.ui.tasks.TasksFragment
import ru.harlion.newtime.ui.tasks.adapters.AdapterTask
import ru.harlion.newtime.ui.tasks.adding.AddTaskFragment
import ru.harlion.newtime.utils.replaceFragment


class MainFragment : BindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private lateinit var adapterHabits: AdapterSmallHabits
    private lateinit var adapterTasks: AdapterTask

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener("menu") { _, bundle ->
            when (bundle.getString("name_menu", "")) {
                "task" -> replaceFragment(AddTaskFragment(), true)
                "habit" -> replaceFragment(AddHabitFragment(), true)
                else -> replaceFragment(AddGoalFragment(), true)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicks()

        binding.tasksRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = AdapterTask().also {
                adapterTasks = it
            }
        }
        adapterTasks.items = Repository.getTasks()

        binding.habitsRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = AdapterSmallHabits().also {
                adapterHabits = it
            }
        }
        adapterHabits.items = Repository.getHabits()
    }

    private fun initClicks() {
        binding.addBtn.setOnClickListener {
            DialogBottomMenu().show(parentFragmentManager, null)
        }
    }
}