package com.takassoftware.managey.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.takassoftware.managey.Model.MonthlyListItemModel
import com.takassoftware.managey.R
import android.support.constraint.ConstraintLayout
import android.widget.TextView

/**
 * 月間情報リストのAdapter
 *
 * @author たかお
 * @since 2019.01.22
 */
public class MonthlyListViewAdapter : RecyclerView.Adapter<MonthlyListViewHolder> {

    /** 月間情報リストの表示データ */
    private var list:List<MonthlyListItemModel>

    /**
     * コンストラクタ
     */
    constructor(list:List<MonthlyListItemModel>){
        this.list = list
    }

    /**
     * onCreateViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int) : MonthlyListViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.monthly_list_row,parent,false) //.inflate(R.layout., parent, false)
        return MonthlyListViewHolder(inflate)
    }

    /**
     * onBindViewHolder
     */
    override fun onBindViewHolder(holder: MonthlyListViewHolder, position: Int) {
        holder.title.text = list[position].title //setText(list[position].getTitle())
        holder.monthlyListItem.id = position

    }

    /**
     * getItemCount
     */
    override fun getItemCount(): Int {
        return list.count() //list.size()
    }

}

/**
 * 月間情報リストのHolder
 *
 * @author たかお
 * @since 2019.01.22
 */
class MonthlyListViewHolder : RecyclerView.ViewHolder {

    /** 月間情報リストの項目*/
    public var monthlyListItem : ConstraintLayout

    /** 月間情報リストのタイトル*/
    public var title : TextView

    /**
     * コンストラクタ
     */
    constructor(itemView:View):super(itemView){
        // monthly_list_item
        monthlyListItem = itemView.findViewById<ConstraintLayout>(R.id.monthly_list_item)
        title = itemView.findViewById<TextView>(R.id.monthly_list_item_title)
    }

}