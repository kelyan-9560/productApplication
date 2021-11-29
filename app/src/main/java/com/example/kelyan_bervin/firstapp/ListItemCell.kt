package com.example.kelyan_bervin.firstapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_cell.view.*

class ListItemCell(v: View) : RecyclerView.ViewHolder(v) {

    val text : TextView = v.text_cell

}