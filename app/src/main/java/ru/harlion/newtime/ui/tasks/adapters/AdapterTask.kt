package ru.harlion.newtime.ui.tasks.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.harlion.newtime.base.BindingHolder
import ru.harlion.newtime.databinding.ItemTaskBinding
import ru.harlion.newtime.models.Task


private typealias ItemHolderTasks = BindingHolder<ItemTaskBinding>

class AdapterTask :
 RecyclerView.Adapter<ItemHolderTasks>(){

    var items: List<Task> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemHolderTasks(ItemTaskBinding::inflate, parent).apply {

    }

    override fun onBindViewHolder(holder: ItemHolderTasks, position: Int) {
        holder.binding.apply {
            taskName.text = items[position].name
            taskChecked.isChecked = items[position].checked
        }
    }

    override fun getItemCount() = items.size
}