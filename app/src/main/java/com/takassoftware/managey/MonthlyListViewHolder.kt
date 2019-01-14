package com.takassoftware.managey

import android.support.v7.widget.RecyclerView
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.TextView

class MonthlyListViewHolder : RecyclerView.ViewHolder {

    public var monthlyListItem : ConstraintLayout
    public var title : TextView

    constructor(itemView:View):super(itemView){
        // monthly_list_item
        monthlyListItem = itemView.findViewById<ConstraintLayout>(R.id.monthly_list_item)
        title = itemView.findViewById<TextView>(R.id.monthly_list_item_title)
    }

}