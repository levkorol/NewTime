package ru.harlion.newtime.ui.goals.adding


import ru.harlion.newtime.AppActivity
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.databinding.FragmentAddGoalBinding


class AddGoalFragment : BindingFragment<FragmentAddGoalBinding>(FragmentAddGoalBinding::inflate) {

    override fun onStart() {
        super.onStart()
        (activity as AppActivity).setBottomNavigationVisible(false)
    }

    override fun onStop() {
        super.onStop()
        (activity as AppActivity).setBottomNavigationVisible(true)
    }
}