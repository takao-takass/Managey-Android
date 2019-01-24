package com.takassoftware.managey.Model

import android.view.View

/**
 * 入出金明細リストの項目のモデル
 *
 * @author たかお
 * @since 2019.01.24
 */
data class InoutDetailListItemModel(

    /** 入出金明細ID */
    var id : String,

    /** タイトル */
    var title : String,

    /** 金額 */
    var amount : Long,

    /** クレジットカード使用区分 */
    var creditUsedKbn : String,

    /** クレジットカード名称 */
    var creditName : String,

    /** ロングタップイベントの処理 */
    var onLongClick : (v: View?)->Boolean

)