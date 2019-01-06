package com.takassoftware.managey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MonthlyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly)

        // アクションバーのタイトル表示を変更します
        this.title = "月間情報"

    }
}
