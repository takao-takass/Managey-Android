package com.takassoftware.managey.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.takassoftware.managey.Model.MonthlyDetailCardUsedListItemModel
import com.takassoftware.managey.R
import android.support.constraint.ConstraintLayout
import android.widget.TextView
import com.takassoftware.managey.CommonProcess.ValueProcessing

/**
 * 月間情報明細のカード使用リストのAdapter
 *
 * @author たかお
 * @since 2019.01.22
 */
public class MonthlyDetailCardUsedListViewAdapter : RecyclerView.Adapter<MonthlyDetailCardUsedListViewHolder> {

    /** カード使用リストの表示データ */
    private var list:List<MonthlyDetailCardUsedListItemModel>

    /**
     * コンストラクタ
     */
    constructor(list:List<MonthlyDetailCardUsedListItemModel>){
        this.list = list
    }

    /**
     * onCreateViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int) : MonthlyDetailCardUsedListViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.monthly_detail_card_used_list_row,parent,false)
        return MonthlyDetailCardUsedListViewHolder(inflate)
    }

    /**
     * onBindViewHolder
     */
    override fun onBindViewHolder(holder: MonthlyDetailCardUsedListViewHolder, position: Int) {
        holder.cardName.text = list[position].cardName
        holder.cardUsed.text = ValueProcessing().separateValuesComma(list[position].cardUsed)
        holder.monthlyDetailCardUsedListItem.id = position

    }

    /**
     * getItemCount
     */
    override fun getItemCount(): Int {
        return list.count()
    }

}

/**
 * 月間情報明細のカード使用リストのHolder
 *
 * @author たかお
 * @since 2019.01.22
 */
class MonthlyDetailCardUsedListViewHolder : RecyclerView.ViewHolder {

    /** カード使用リストの項目 */
    public var monthlyDetailCardUsedListItem : ConstraintLayout

    /** カード名称 */
    public var cardName : TextView

    /** カード使用金額 */
    public var cardUsed : TextView

    /**
     * コンストラクタ
     */
    constructor(itemView:View):super(itemView){
        monthlyDetailCardUsedListItem = itemView.findViewById<ConstraintLayout>(R.id.monthly_detail_card_used_list_item)
        cardName = itemView.findViewById<TextView>(R.id.monthly_detail_card_used_label)
        cardUsed = itemView.findViewById<TextView>(R.id.monthly_detail_card_used)
    }

}