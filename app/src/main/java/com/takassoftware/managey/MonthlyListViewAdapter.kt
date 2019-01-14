package com.takassoftware.managey

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.takassoftware.managey.Model.MonthliListItemModel
import com.takassoftware.managey.R
import android.R.attr.onClick



public class MonthlyListViewAdapter : RecyclerView.Adapter<MonthlyListViewHolder> {

    private var list:List<MonthliListItemModel>

    // コンストラクタ
    constructor(list:List<MonthliListItemModel>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int) : MonthlyListViewHolder{
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