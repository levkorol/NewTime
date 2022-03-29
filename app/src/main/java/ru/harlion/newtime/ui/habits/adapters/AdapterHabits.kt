package ru.harlion.newtime.ui.habits.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.harlion.newtime.base.BindingHolder
import ru.harlion.newtime.databinding.ItemHabitsBinding
import ru.harlion.newtime.models.Habit


private typealias ItemHolderHabits = BindingHolder<ItemHabitsBinding>
class AdapterHabits :
      RecyclerView.Adapter<ItemHolderHabits>()
{

    var items : List <Habit> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemHolderHabits(ItemHabitsBinding::inflate, parent).apply {}

    override fun onBindViewHolder(holder: ItemHolderHabits, position: Int) {
        holder.binding.apply {
            habitIcon
            habitName.text = items[position].name
            habitArrow
            habitPrize
            habitSkill.text = items[position].name
            habitCheckBox.isChecked = items[position].checked


        }
    }

    override fun getItemCount() = items.size
}