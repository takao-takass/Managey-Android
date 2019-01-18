package com.takassoftware.managey.CommonProcess

class StringProcessing {

    // 入力した数値を３ケタ毎のカンマ区切り形式にする
    public fun removeComma(text:String) : Long{
        return text.replace(",","",true).toLong()
    }

}