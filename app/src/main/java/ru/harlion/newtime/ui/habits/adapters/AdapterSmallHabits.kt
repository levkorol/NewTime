package ru.harlion.newtime.ui.habits.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.harlion.newtime.base.BindingHolder
import ru.harlion.newtime.databinding.ItemSmallHabitsBinding
import ru.harlion.newtime.models.Habit

private typealias ItemHolderSmallHabits = BindingHolder<ItemSmallHabitsBinding>

class AdapterSmallHabits :
    RecyclerView.Adapter<ItemHolderSmallHabits>() {

    var items: List<Habit> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemHolderSmallHabits(ItemSmallHabitsBinding::inflate, parent).apply {

    }

    override fun onBindViewHolder(holder: ItemHolderSmallHabits, position: Int) {
       holder.binding.apply {
           habitName.text = items[position].name
           habitCheckBox.isChecked = items[position].checkedToday
       }
    }

    override fun getItemCount() = items.size
}