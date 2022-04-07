package ru.harlion.newtime.ui.habits.habits_active


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels

import androidx.recyclerview.widget.LinearLayoutManager
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.databinding.FragmentActiveHabitsBinding
import ru.harlion.newtime.ui.habits.adapters.AdapterHabits
import ru.harlion.newtime.ui.profile.life_skill.AdapterCategory

class ActiveHabitsFragment : BindingFragment<FragmentActiveHabitsBinding>(FragmentActiveHabitsBinding::inflate) {

    private lateinit var adapterHabits : AdapterHabits
    private lateinit var adapterCategory: AdapterCategory
    private val viewModel : ActiveHabitsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getHabits()
        observe()
        initClicks()

        binding.skillsRv.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = AdapterCategory().also {
                adapterCategory  = it
            }
        }

        adapterCategory.items = Repository.getSkill()

        binding.activeHabitsRv.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = AdapterHabits().also {
                adapterHabits = it
            }
        }


    }

    private fun initClicks() {

    }

    private fun observe() {
         viewModel.habits.observe(viewLifecycleOwner, {
             adapterHabits.items = it
         })
    }
}