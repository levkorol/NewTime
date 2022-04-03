package ru.harlion.newtime.ui.goals


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import ru.harlion.newtime.R
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.databinding.FragmentGoalsBinding
import ru.harlion.newtime.ui.goals.adding.AddGoalFragment
import ru.harlion.newtime.ui.goals.goals_active.GoalActiveFragment
import ru.harlion.newtime.ui.goals.goals_completed.GoalsCompletedFragment
import ru.harlion.newtime.ui.habits.adding.AddHabitFragment
import ru.harlion.newtime.utils.replaceFragment


class GoalsFragment : BindingFragment<FragmentGoalsBinding>(FragmentGoalsBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = GoalsViewPager(childFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabTasks, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.actives)
                }
                else -> {
                    tab.text = getString(R.string.comleted)
                }
            }
        }.attach()

        binding.addBtn.setOnClickListener {
            replaceFragment(AddGoalFragment(), true)
        }
    }

    class GoalsViewPager(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {

        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> GoalActiveFragment()
                else -> GoalsCompletedFragment()
            }
        }
    }
}