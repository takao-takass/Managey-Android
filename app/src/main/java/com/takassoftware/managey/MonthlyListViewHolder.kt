package com.takassoftware.managey

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MonthlyListViewHolder : RecyclerView.ViewHolder {

    public var text : TextView

    constructor(itemView:View):super(itemView){
        text = itemView.findViewById<TextView>(R.id.list_item_text)
    }

}