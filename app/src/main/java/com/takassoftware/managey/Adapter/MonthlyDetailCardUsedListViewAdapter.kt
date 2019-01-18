package com.takassoftware.managey.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.takassoftware.managey.Model.MonthlyDetailCardUsedListItemModel
import com.takassoftware.managey.R
import android.support.constraint.ConstraintLayout
import android.widget.TextView

// 月間情報明細のカード使用リストのAdapter
public class MonthlyDetailCardUsedListViewAdapter : RecyclerView.Adapter<MonthlyDetailCardUsedListViewHolder> {

    private var list:List<MonthlyDetailCardUsedListItemModel>

    // コンストラクタ
    constructor(list:List<MonthlyDetailCardUsedListItemModel>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int) : MonthlyDetailCardUsedListViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.monthly_detail_card_used_list_row,parent,false)
        return MonthlyDetailCardUsedListViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: MonthlyDetailCardUsedListViewHolder, position: Int) {
        holder.cardName.text = list[position].cardName
        holder.cardUsed.text = Integer.toString(list[position].cardUsed)
        holder.monthlyDetailCardUsedListItem.id = position

    }

    override fun getItemCount(): Int {
        return list.count() //list.size()
    }

}

// 月間情報明細のカード使用リストのHolder
class MonthlyDetailCardUsedListViewHolder : RecyclerView.ViewHolder {

    public var monthlyDetailCardUsedListItem : ConstraintLayout
    public var cardName : TextView
    public var cardUsed : TextView

    constructor(itemView:View):super(itemView){
        monthlyDetailCardUsedListItem = itemView.findViewById<ConstraintLayout>(R.id.monthly_detail_card_used_list_item)
        cardName = itemView.findViewById<TextView>(R.id.monthly_detail_card_used_label)
        cardUsed = itemView.findViewById<TextView>(R.id.monthly_detail_card_used)
    }

}