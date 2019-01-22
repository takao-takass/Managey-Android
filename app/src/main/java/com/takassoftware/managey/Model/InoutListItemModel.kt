package com.takassoftware.managey.Model

/**
 * 入出金リストの項目のモデル
 *
 * @author たかお
 * @since 2019.01.22
 */
data class InoutListItemModel(

    /** タイトル */
    var title : String,

    /** 開始日付 */
    var spanStart : String,

    /** 終了日付 */
    var spanEnd : String,

    /** 現金金額 */
    var cashAmount : Long,

    /** クレジットカード金額 */
    var creditAmount : Long

)