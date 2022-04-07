package ru.harlion.newtime.ui.habits.add_or_edit


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import ru.harlion.newtime.AppActivity
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.databinding.FragmentAddHabitBinding


class AddHabitFragment :
    BindingFragment<FragmentAddHabitBinding>(FragmentAddHabitBinding::inflate) {

    private val viewModel: AddHabitsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicks()
    }

    private fun initClicks() {
        binding.save.setOnClickListener {
            addNewHabit()
            parentFragmentManager.popBackStack()
        }
    }

    private fun addNewHabit() {
        viewModel.addHabit(
            binding.name.text.toString(),
            0,
            0,
            0,
            binding.prize.text.toString(),
            binding.skill.text.toString(),
            0
        )
    }

    private fun editHabit() {

    }

    override fun onStart() {
        super.onStart()
        (activity as AppActivity).setBottomNavigationVisible(false)
    }

    override fun onStop() {
        super.onStop()
        (activity as AppActivity).setBottomNavigationVisible(true)
    }
}