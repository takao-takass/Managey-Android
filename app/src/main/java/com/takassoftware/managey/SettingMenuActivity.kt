package com.takassoftware.managey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SettingMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_menu)

        // アクションバーのタイトル表示を変更
        this.title = "アプリケーションの設定"

    }
}
