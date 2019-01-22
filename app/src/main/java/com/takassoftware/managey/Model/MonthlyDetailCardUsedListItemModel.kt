package com.takassoftware.managey.Model

/**
 * 月間情報明細のカード使用リストの項目のモデル
 *
 * @author たかお
 * @since 2019.01.22
 */
data class MonthlyDetailCardUsedListItemModel(

    /** カード名称 */
    var cardName : String,

    /** カード使用金額 */
    var cardUsed : Long

)