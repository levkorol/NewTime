package ru.harlion.newtime.ui.habits


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import ru.harlion.newtime.R
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.databinding.FragmentHabitsBinding
import ru.harlion.newtime.ui.habits.adding.AddHabitFragment
import ru.harlion.newtime.ui.habits.habits_active.ActiveHabitsFragment
import ru.harlion.newtime.ui.habits.habits_completed.CompletedHabitsFragment
import ru.harlion.newtime.utils.replaceFragment


class HabitsFragment : BindingFragment<FragmentHabitsBinding>(FragmentHabitsBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = HabitsViewPager(childFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabTasks, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.actives)
                }
                else -> {
                    tab.text = getString(R.string.comleted_habits)
                }
            }
        }.attach()

        binding.addBtn.setOnClickListener {
            replaceFragment(AddHabitFragment(), true)
        }
    }

    class HabitsViewPager(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {

        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> ActiveHabitsFragment()
                else -> CompletedHabitsFragment()
            }
        }
    }
}