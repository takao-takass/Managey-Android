package com.takassoftware.managey.CommonProcess

class ValueProcessing {

    // 入力した数値を３ケタ毎のカンマ区切り形式にする
    public fun separateValuesComma(value:Long) : String{
        return "%,d".format(value)
    }

}