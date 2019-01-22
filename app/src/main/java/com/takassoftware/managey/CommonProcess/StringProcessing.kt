package com.takassoftware.managey.CommonProcess

/**
 * 文字列の処理を行うクラスです。
 *
 * @author たかお
 * @since 2019.01.22
 */
class StringProcessing {

    /**
     * ３ケタカンマ区切り形式の文字列をLong型に変換します。
     *
     * @param text 対象の文字列
     * @return 変換後の文字列
     */
    public fun removeCommaToLong(text:String) : Long{
        return text.replace(",","",true).toLong()
    }

    /**
     * 空の文字列を"0"に置き換えます。
     * 文字列が空でなければ入力した文字列を返します。
     *
     * @param text 置き換え対象の文字列
     * @return 置き換え後の文字列
     */
    public fun emptyToZero(text:String) : String{
        val csText = text as CharSequence
        return if (csText.isEmpty()) "0" else csText.toString()
    }

}