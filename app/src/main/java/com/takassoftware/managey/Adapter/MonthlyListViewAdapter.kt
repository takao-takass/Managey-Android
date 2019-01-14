package com.takassoftware.managey.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.takassoftware.managey.Model.MonthlyListItemModel
import com.takassoftware.managey.R
import android.support.constraint.ConstraintLayout
import android.widget.TextView


public class MonthlyListViewAdapter : RecyclerView.Adapter<MonthlyListViewHolder> {

    private var list:List<MonthlyListItemModel>

    // コンストラクタ
    constructor(list:List<MonthlyListItemModel>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int) : MonthlyListViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.monthly_list_row,parent,false) //.inflate(R.layout., parent, false)
        return MonthlyListViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: MonthlyListViewHolder, position: Int) {
        holder.title.text = list[position].title //setText(list[position].getTitle())
        holder.monthlyListItem.id = position

    }

    override fun getItemCount(): Int {
        return list.count() //list.size()
    }

}

class MonthlyListViewHolder : RecyclerView.ViewHolder {

    public var monthlyListItem : ConstraintLayout
    public var title : TextView

    constructor(itemView:View):super(itemView){
        // monthly_list_item
        monthlyListItem = itemView.findViewById<ConstraintLayout>(R.id.monthly_list_item)
        title = itemView.findViewById<TextView>(R.id.monthly_list_item_title)
    }

}