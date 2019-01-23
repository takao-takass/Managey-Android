package com.takassoftware.managey.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.takassoftware.managey.R
import android.support.constraint.ConstraintLayout
import android.widget.TextView
import com.takassoftware.managey.CommonProcess.ValueProcessing
import com.takassoftware.managey.Model.InoutListItemModel

/**
 * 入出金リストのAdapter
 *
 * @author たかお
 * @since 2019.01.22
 */
public class InoutListViewAdapter : RecyclerView.Adapter<InoutListViewHolder> {

    /** 入出金リストの表示データ */
    public var inoutDataList:List<InoutListItemModel>

    /**
     * コンストラクタ
     */
    constructor(list:List<InoutListItemModel>){
        this.inoutDataList = list
    }

    /**
     * onCreateViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int) : InoutListViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.inout_list_row,parent,false)
        return InoutListViewHolder(inflate)
    }

    /**
     * onBindViewHolder
     */
    override fun onBindViewHolder(holder: InoutListViewHolder, position: Int) {

        // 表示項目の設定
        holder.inoutListItem.id = position
        holder.id.text = inoutDataList[position].id
        holder.title.text = inoutDataList[position].title
        holder.span.text = inoutDataList[position].spanStart + "～" + inoutDataList[position].spanEnd
        holder.cashAmount.text = ValueProcessing().separateValuesComma(inoutDataList[position].cashAmount)
        holder.creditAmount.text = ValueProcessing().separateValuesComma(inoutDataList[position].creditAmount)

        // リストの項目に対するイベントリスナの設定
        holder.inoutListItem.setOnLongClickListener(inoutDataList[position].onLongClick)

    }

    /**
     * getItemCount
     */
    override fun getItemCount(): Int {
        return inoutDataList.count() //list.size()
    }

}

/**
 * 月間情報リストのHolder
 *
 * @author たかお
 * @since 2019.01.22
 */
class InoutListViewHolder : RecyclerView.ViewHolder {

    /** 入出金リストの項目*/
    public var inoutListItem : ConstraintLayout

    /** 入出金ID */
    public var id : TextView

    /** 項目のタイトル*/
    public var title : TextView

    /** 項目の対象期間*/
    public var span : TextView

    /** 項目の現金金額*/
    public var cashAmount : TextView

    /** 項目のクレジット金額*/
    public var creditAmount : TextView

    /**
     * コンストラクタ
     */
    constructor(itemView:View):super(itemView){
        inoutListItem = itemView.findViewById<ConstraintLayout>(R.id.inout_list_item)
        id = itemView.findViewById<TextView>(R.id.inout_list_item_id)
        title = itemView.findViewById<TextView>(R.id.inout_list_item_title)
        span = itemView.findViewById<TextView>(R.id.inout_list_item_span)
        cashAmount = itemView.findViewById<TextView>(R.id.inout_list_item_cash_amount)
        creditAmount = itemView.findViewById<TextView>(R.id.inout_list_item_credit_amount)
    }

}