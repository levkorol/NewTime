package ru.harlion.newtime.ui.goals.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.harlion.newtime.base.BindingHolder
import ru.harlion.newtime.databinding.ItemGoalBinding
import ru.harlion.newtime.models.Goal


private typealias ItemHolderGoal = BindingHolder<ItemGoalBinding>

class AdapterGoals :
    RecyclerView.Adapter<ItemHolderGoal>() {

    var items: List<Goal> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemHolderGoal(ItemGoalBinding::inflate, parent).apply {
        }

    override fun onBindViewHolder(holder: ItemHolderGoal, position: Int) {
       holder.binding.apply {
           goalName.text = items[position].name
       }
    }

    override fun getItemCount() = items.size
}