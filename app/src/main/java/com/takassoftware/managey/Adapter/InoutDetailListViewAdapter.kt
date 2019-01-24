package com.takassoftware.managey.Adapter

import android.opengl.Visibility
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.takassoftware.managey.R
import android.support.constraint.ConstraintLayout
import android.widget.ImageView
import android.widget.TextView
import com.takassoftware.managey.CommonProcess.ValueProcessing
import com.takassoftware.managey.Model.InoutDetailListItemModel
import com.takassoftware.managey.Model.InoutListItemModel

/**
 * 入出金明細リストのAdapter
 *
 * @author たかお
 * @since 2019.01.24
 */
public class InoutDetailListViewAdapter : RecyclerView.Adapter<InoutDetailListViewHolder> {

    /** 入出金リストの表示データ */
    public var inoutDetailDataList:List<InoutDetailListItemModel>

    /**
     * コンストラクタ
     */
    constructor(list:List<InoutDetailListItemModel>){
        this.inoutDetailDataList = list
    }

    /**
     * onCreateViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int) : InoutDetailListViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.inout_detail_list_row,parent,false)
        return InoutDetailListViewHolder(inflate)
    }

    /**
     * onBindViewHolder
     */
    override fun onBindViewHolder(holder: InoutDetailListViewHolder, position: Int) {

        // 表示項目の設定
        holder.inoutDetailListItem.id = position
        holder.id.text = inoutDetailDataList[position].id
        holder.title.text = inoutDetailDataList[position].title
        holder.amount.text = ValueProcessing().separateValuesComma(inoutDetailDataList[position].amount)

        if ("1".equals(inoutDetailDataList[position].creditUsedKbn)) {
            holder.creditName.text = inoutDetailDataList[position].creditName
        } else {
            holder.creditIcon.visibility = View.INVISIBLE
            holder.creditName.visibility = View.INVISIBLE
        }

        // リストの項目に対するイベントリスナの設定
        holder.inoutDetailListItem.setOnLongClickListener(inoutDetailDataList[position].onLongClick)

    }

    /**
     * getItemCount
     */
    override fun getItemCount(): Int {
        return inoutDetailDataList.count()
    }

}

/**
 * 入出金明細リストのHolder
 *
 * @author たかお
 * @since 2019.01.24
 */
class InoutDetailListViewHolder : RecyclerView.ViewHolder {

    /** 入出金リストの項目*/
    public var inoutDetailListItem : ConstraintLayout

    /** 入出金明細ID */
    public var id : TextView

    /** 項目のタイトル*/
    public var title : TextView

    /** 項目の金額*/
    public var amount : TextView

    /** 項目のクレジットアイコン*/
    public var creditIcon : ImageView

    /** 項目のクレジット名称*/
    public var creditName : TextView

    /**
     * コンストラクタ
     */
    constructor(itemView:View):super(itemView){
        inoutDetailListItem = itemView.findViewById<ConstraintLayout>(R.id.inout_detail_list_item)
        id = itemView.findViewById<TextView>(R.id.inout_detail_list_item_id)
        title = itemView.findViewById<TextView>(R.id.inout_detail_list_item_title)
        amount = itemView.findViewById<TextView>(R.id.inout_detail_list_item_amount)
        creditIcon = itemView.findViewById<ImageView>(R.id.inout_detail_list_item_icon_credit)
        creditName = itemView.findViewById<TextView>(R.id.inout_detail_list_item_credit_name)
    }

}