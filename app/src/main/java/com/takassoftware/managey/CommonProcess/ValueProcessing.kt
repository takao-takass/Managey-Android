package com.takassoftware.managey.CommonProcess

/**
 * 数値の処理を行うクラスです。
 *
 * @author たかお
 * @since 2019.01.22
 *
 */
class ValueProcessing {

    /**
     * 入力した数値を３ケタ毎のカンマ区切り形式にします。
     *
     * @param value 対象の数値
     * @return 処理後の文字列
     */
    public fun separateValuesComma(value:Long) : String{
        return "%,d".format(value)
    }

}