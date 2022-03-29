package ru.harlion.newtime.ui.habits.habits_active


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.data.Repository
import ru.harlion.newtime.databinding.FragmentActiveHabitsBinding
import ru.harlion.newtime.ui.habits.adapters.AdapterHabits

class ActiveHabitsFragment : BindingFragment<FragmentActiveHabitsBinding>(FragmentActiveHabitsBinding::inflate) {

    private lateinit var adapterHabits : AdapterHabits

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.activeHabitsRv.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = AdapterHabits().also {
                adapterHabits = it
            }
        }
        adapterHabits.items = Repository.getHabits()
    }
}