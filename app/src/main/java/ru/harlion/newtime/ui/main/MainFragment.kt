package ru.harlion.newtime.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.databinding.FragmentMainBinding
import ru.harlion.newtime.ui.dialogs.DialogBottomMenu
import ru.harlion.newtime.ui.goals.add_or_edit.AddGoalFragment
import ru.harlion.newtime.ui.habits.adapters.AdapterSmallHabits
import ru.harlion.newtime.ui.habits.add_or_edit.AddHabitFragment
import ru.harlion.newtime.ui.tasks.adapters.AdapterTask
import ru.harlion.newtime.ui.tasks.add_or_edit.AddTaskFragment
import ru.harlion.newtime.utils.replaceFragment


class MainFragment : BindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private lateinit var adapterHabits: AdapterSmallHabits
    private lateinit var adapterTasks: AdapterTask
    private val viewModel : MainViewModel by viewModels()

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

        viewModel.getHabits()
        initClicks()
        observe()

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

    }

    private fun observe() {
        viewModel.habits.observe(viewLifecycleOwner, {
            if(it.isNotEmpty()) {
                adapterHabits.items = it
                binding.textEmptyHabits.visibility = View.GONE
                binding.habitsProgressBar.visibility = View.VISIBLE
                binding.titleHabits.visibility = View.VISIBLE
                binding.habitsRecyclerView.visibility = View.VISIBLE
            } else {
                binding.textEmptyHabits.visibility = View.VISIBLE
                binding.habitsProgressBar.visibility = View.GONE
                binding.habitsRecyclerView.visibility = View.GONE
                binding.titleHabits.visibility = View.GONE
            }
        })
    }

    private fun initClicks() {
        binding.addBtn.setOnClickListener {
            DialogBottomMenu().show(parentFragmentManager, null)
        }
    }
}