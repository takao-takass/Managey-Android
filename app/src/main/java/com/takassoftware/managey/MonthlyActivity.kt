package com.takassoftware.managey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Adapter
import com.takassoftware.managey.Model.MonthliListItemModel

class MonthlyActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly)

        // アクションバーのタイトル表示を変更します
        this.title = "月間情報"

        // 月間情報リストのレイアウト設定
        var recyclerView = findViewById(R.id.monthly_list) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        // 月間情報リストに対するadapterの設定
        var adapter = MonthlyListViewAdapter(this.createDataset())
        recyclerView.adapter = adapter

    }

    // 月間情報リストに表示するデータセットの作成
    private fun createDataset(): List<MonthliListItemModel> {
        val dataset = mutableListOf<MonthliListItemModel>()
        for (i in 0..49) {
            val data = MonthliListItemModel(text="入出金イベント：その" + i + "")
            dataset.add(data)
        }
        return dataset
    }

}
