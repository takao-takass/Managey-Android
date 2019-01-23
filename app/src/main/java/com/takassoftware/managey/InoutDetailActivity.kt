package com.takassoftware.managey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.takassoftware.managey.Constant.IntentExtraConst

/**
 * 入出金明細Activity
 *
 * @author たかお
 * @since 2019.01.23
 */
class InoutDetailActivity : AppCompatActivity() {

    /**
     * onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inout_detail)

        // インテントから入出金IDを取得する
        val inoutId = intent.getStringExtra(IntentExtraConst.INOUT_ID)

        // アクションバーのタイトル表示を変更
        this.title = "入出金明細"
    }
}
