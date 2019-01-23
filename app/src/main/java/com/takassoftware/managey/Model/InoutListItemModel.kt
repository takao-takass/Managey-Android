package com.takassoftware.managey.Model

import android.view.View

/**
 * 入出金リストの項目のモデル
 *
 * @author たかお
 * @since 2019.01.22
 */
data class InoutListItemModel(

    /** 入出金ID */
    var id : String,

    /** タイトル */
    var title : String,

    /** 開始日付 */
    var spanStart : String,

    /** 終了日付 */
    var spanEnd : String,

    /** 現金金額 */
    var cashAmount : Long,

    /** クレジットカード金額 */
    var creditAmount : Long,

    /** ロングタップイベントの処理 */
    var onLongClick : (v: View?)->Boolean

)