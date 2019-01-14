package com.takassoftware.managey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager;
import android.view.View
import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast
import com.takassoftware.managey.Model.MonthliListItemModel

class MonthlyActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly)

        // アクションバーのタイトル表示を変更
        this.title = "月間情報"

        // 月間情報リストのレイアウト設定
        var recyclerView = findViewById(R.id.monthly_list) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        // 月間情報リストに対するadapterの設定
        recyclerView.adapter = MonthlyListViewAdapter(this.createDataset())

    }

    fun onClick(v: View) {

        // 仮実装：タップしたリストのタイトルを表示
        val titleTextView = v.findViewById(R.id.monthly_list_item_title) as TextView
        Toast.makeText(
                this,
                "Tap: Title="+titleTextView.text,
                Toast.LENGTH_SHORT
        ).show()

    }

    // 仮実装：月間情報リストに表示するデータセットの作成
    private fun createDataset(): List<MonthliListItemModel> {
        val dataset = mutableListOf<MonthliListItemModel>()
        for (i in 1..31) {
            val data = MonthliListItemModel(title="10/" + i +" 出金")
            dataset.add(data)
        }
        return dataset
    }

}
