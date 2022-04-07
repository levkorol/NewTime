package ru.harlion.newtime.ui.profile.life_skill

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.harlion.newtime.base.BindingHolder
import ru.harlion.newtime.databinding.ItemCategoryBinding
import ru.harlion.newtime.models.Skill

private typealias ItemHolderCategory = BindingHolder<ItemCategoryBinding>

class AdapterCategory :
    RecyclerView.Adapter<ItemHolderCategory>() {

    var items: List<Skill> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemHolderCategory(ItemCategoryBinding::inflate, parent).apply {}

    override fun onBindViewHolder(holder: ItemHolderCategory, position: Int) {
        holder.binding.apply {
            category.text = items[position].name

            category.setOnClickListener {
                category.isChecked = !category.isChecked
            }
        }
    }

    override fun getItemCount() = items.size
}