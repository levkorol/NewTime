package ru.harlion.newtime.ui.goals.goals_active


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.databinding.FragmentGoalActiveBinding
import ru.harlion.newtime.ui.goals.adapters.AdapterGoals
import ru.harlion.newtime.ui.profile.life_skill.AdapterCategory


class GoalActiveFragment : BindingFragment<FragmentGoalActiveBinding>(FragmentGoalActiveBinding::inflate) {

    private lateinit var adapterGoal : AdapterGoals
    private lateinit var adapterCategory : AdapterCategory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.skillsRv.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = AdapterCategory().also {
                adapterCategory  = it
            }
        }

        adapterCategory.items = Repository.getSkill()

        binding.activeGoalsRv.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = AdapterGoals().also {
                adapterGoal = it
            }
        }
        adapterGoal.items = Repository.getGoals()
    }
}