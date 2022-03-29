package ru.harlion.newtime.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.harlion.newtime.R
import ru.harlion.newtime.databinding.FragmentDialogMenuBinding
import ru.harlion.newtime.ui.goals.adding.AddGoalFragment
import ru.harlion.newtime.utils.replaceFragment

class DialogBottomMenu: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDialogMenuBinding.bind(view)

        binding.addTask.setOnClickListener { setResultMenu("task") }
        binding.addGoal.setOnClickListener { setResultMenu("goal") }
        binding.addHabit.setOnClickListener { setResultMenu("habit") }
    }

    private fun setResultMenu(value : String) {
        setFragmentResult("menu", Bundle().apply {
            putString("name_menu", value)
        })
        dismiss()
    }
}