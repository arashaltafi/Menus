package com.arash.altafi.menus.drag_drop

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.menus.R
import kotlinx.android.synthetic.main.item_drag_and_drop.view.*

class DragAndDropAdapter(private val activity: DragAndDropActivity): RecyclerView.Adapter<DragAndDropAdapter.DragAndDropViewHolder>() {

    private var emojis = listOf(
        "😀",
        "😃",
        "😄",
        "😁",
        "😆",
        "😅",
        "😂",
        "🤣",
        "☺️",
        "😊",
        "😇",
        "🙂",
        "🙃",
        "😉"
    ).toMutableList()

    fun moveItem(from: Int, to: Int) {
        val fromEmoji = emojis[from]
        emojis.removeAt(from)
        if (to < from) {
            emojis.add(to, fromEmoji)
        } else {
            emojis.add(to - 1, fromEmoji)
        }
    }

    override fun getItemCount(): Int {
        return emojis.size
    }

    override fun onBindViewHolder(holder: DragAndDropViewHolder, position: Int) {
        val emoji = emojis[position]
        holder.setText(emoji)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragAndDropViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_drag_and_drop, parent, false)
        val viewHolder = DragAndDropViewHolder(itemView)

        viewHolder.itemView.handleView.setOnTouchListener { view, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                activity.startDragging(viewHolder)
            }
            return@setOnTouchListener true
        }

        return viewHolder
    }

    class DragAndDropViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun setText(text: String) {
            itemView.textView.text = text
        }
    }

}