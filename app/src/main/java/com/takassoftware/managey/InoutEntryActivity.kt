package com.takassoftware.managey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/**
 * 入出金登録Activity
 *
 * @author たかお
 * @since 2019.03.09
 */
class InoutEntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inout_entry)

        // アクションバーのタイトル表示を変更
        this.title = "入出金の登録"

    }
}
