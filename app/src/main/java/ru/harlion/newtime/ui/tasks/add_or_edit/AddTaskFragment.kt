package ru.harlion.newtime.ui.tasks.add_or_edit


import ru.harlion.newtime.AppActivity
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.databinding.FragmentAddTaskBinding


class AddTaskFragment : BindingFragment<FragmentAddTaskBinding>(FragmentAddTaskBinding::inflate) {

    override fun onStart() {
        super.onStart()
        (activity as AppActivity).setBottomNavigationVisible(false)
    }

    override fun onStop() {
        super.onStop()
        (activity as AppActivity).setBottomNavigationVisible(true)
    }
}