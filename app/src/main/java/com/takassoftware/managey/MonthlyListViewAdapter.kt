package com.takassoftware.managey

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.takassoftware.managey.Model.MonthliListItemModel
import com.takassoftware.managey.R

public class MonthlyListViewAdapter : RecyclerView.Adapter<MonthlyListViewHolder> {

    private var list:List<MonthliListItemModel>

    // コンストラクタ
    constructor(list:List<MonthliListItemModel>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int) : MonthlyListViewHolder{
        var inflate = LayoutInflater.from(parent.context).inflate(R.layout.monthly_list_row,parent,false) //.inflate(R.layout., parent, false)
        return MonthlyListViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: MonthlyListViewHolder, position: Int) {
        holder.text.text = list[position].text //setText(list[position].getTitle())
    }

    override fun getItemCount(): Int {
        return list.count() //list.size()
    }

}