package ru.harlion.newtime.ui.goals.edit


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import ru.harlion.newtime.AppActivity
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.databinding.FragmentAddGoalBinding


class EditGoalFragment : BindingFragment<FragmentAddGoalBinding>(FragmentAddGoalBinding::inflate) {

    private val viewModel : EditGoalViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicks()

    }

    private fun initClicks() {
        binding.save.setOnClickListener {
            viewModel.addGoal(
                binding.name.text.toString(),
                0,
                binding.unit.text.toString(),
                0,
                "",
                binding.prize.text.toString()
            )
            parentFragmentManager.popBackStack()
        }
    }

    override fun onStart() {
        super.onStart()
        (activity as AppActivity).setBottomNavigationVisible(false)
    }

    override fun onStop() {
        super.onStop()
        (activity as AppActivity).setBottomNavigationVisible(true)
    }

    companion object {
        fun newInstance(id : Long) = EditGoalFragment().apply {
            arguments = Bundle().apply {
                putLong("ID", id)
            }
        }
    }
}