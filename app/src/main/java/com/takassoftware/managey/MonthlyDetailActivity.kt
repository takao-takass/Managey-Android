package com.takassoftware.managey

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import com.takassoftware.managey.Constant.IntentExtraConst
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.takassoftware.managey.Adapter.MonthlyDetailCardUsedListViewAdapter
import com.takassoftware.managey.Model.MonthlyDetailCardUsedListItemModel
import com.takassoftware.managey.Model.MonthlyListItemModel

class MonthlyDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly_detail)

        // インテントから対象月を取得する
        val year = Integer.parseInt(intent.getStringExtra(IntentExtraConst.YEAR))
        val month = Integer.parseInt(intent.getStringExtra(IntentExtraConst.MONTH))

        // アクションバーのタイトル表示を変更
        this.title = "月間情報明細（ $year 年 $month 月）"


        // カード使用リストのレイアウト設定
        val recyclerView = findViewById(R.id.monthly_detail_card_used_list) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        // 月間情報リストに対するadapterの設定
        recyclerView.adapter = MonthlyDetailCardUsedListViewAdapter(this.createDataset())

    }

    // 当月貯金額の表示をタップ
    fun onClickMonthlyAmount(v: View) {

        val myedit = EditText(this)
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("貯金額の変更")
        dialog.setView(myedit)
        dialog.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
            // OKボタン押したときの処理
            var amountTextView = findViewById<TextView>(R.id.monthly_detail_monthly_amount)
            amountTextView.text = myedit.getText().toString() + "円"
        })
        dialog.setNegativeButton("キャンセル", null)
        dialog.show()

    }

    // 仮実装：月間情報リストに表示するデータセットの作成
    private fun createDataset(): List<MonthlyDetailCardUsedListItemModel> {
        val dataset = mutableListOf<MonthlyDetailCardUsedListItemModel>()
        for (i in 1..3) {
            val data = MonthlyDetailCardUsedListItemModel("カード"+i,i*15000)
            dataset.add(data)
        }
        return dataset
    }
}
