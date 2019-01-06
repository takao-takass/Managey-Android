package com.takassoftware.managey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class EntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        // アクションバーのタイトル表示を変更します
        this.title = "新規登録"





    }
}
