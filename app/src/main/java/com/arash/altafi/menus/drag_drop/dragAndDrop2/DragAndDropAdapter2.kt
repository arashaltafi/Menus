package com.arash.altafi.menus.drag_drop.dragAndDrop2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.item_drag_and_drop2.view.*

class DragAndDropAdapter2 : RecyclerView.Adapter<DragAndDropAdapter2.DragAndDrop2ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragAndDrop2ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_drag_and_drop2, parent, false)
        return DragAndDrop2ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DragAndDrop2ViewHolder, position: Int) {
        val movieItem= differ.currentList[position]
        holder.bindView(movieItem)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private val differCallback = object: DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    fun moveItem(fromPosition: Int, toPosition: Int) {
        val list = differ.currentList.toMutableList()
        val fromItem = list[fromPosition]
        list.removeAt(fromPosition)
        if (toPosition < fromPosition) {
            list.add(toPosition + 1 , fromItem)
        } else {
            list.add(toPosition - 1, fromItem)
        }
        differ.submitList(list)
    }


    inner class DragAndDrop2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: User) {
            itemView.apply {
                textTitle.text = item.name
                textDesc.text = item.location
            }
        }
    }
}
