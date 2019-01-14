package com.takassoftware.managey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.takassoftware.managey.Constant.IntentExtraConst

class MonthlyDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly_detail)

        // インテントから対象月を取得する
        val year = Integer.parseInt(intent.getStringExtra(IntentExtraConst.YEAR))
        val month = Integer.parseInt(intent.getStringExtra(IntentExtraConst.MONTH))

        // アクションバーのタイトル表示を変更
        this.title = "月間情報明細（ $year 年 $month 月）"

    }
}
