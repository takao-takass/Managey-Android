package com.takassoftware.managey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.takassoftware.managey.Constant.IntentExtraConst

class InoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inout)

        // インテントから入出金IDを取得する
        val inoutId = intent.getStringExtra(IntentExtraConst.INOUT_ID)

        // アクションバーのタイトル表示を変更
        this.title = intent.getStringExtra(IntentExtraConst.INOUT_NAME)

    }
}
