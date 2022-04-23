package ru.harlion.newtime.ui.goals.goals_active


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.databinding.FragmentGoalActiveBinding
import ru.harlion.newtime.ui.goals.adapters.AdapterGoals
import ru.harlion.newtime.ui.profile.life_skill.AdapterCategory


class GoalActiveFragment : BindingFragment<FragmentGoalActiveBinding>(FragmentGoalActiveBinding::inflate) {

    private lateinit var adapterGoal : AdapterGoals
    private lateinit var adapterCategory : AdapterCategory
    private val viewModel : GoalsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()

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

    }

    private fun observe() {
        viewModel.getGoals()

        viewModel.goals.observe(viewLifecycleOwner, {
            if(it.isEmpty()) {
                binding.activeGoalsRv.visibility = View.GONE
                binding.listEmpty.visibility = View.VISIBLE
            } else {
                adapterGoal.items = it
                binding.activeGoalsRv.visibility = View.VISIBLE
                binding.listEmpty.visibility = View.GONE
            }
        })
    }
}