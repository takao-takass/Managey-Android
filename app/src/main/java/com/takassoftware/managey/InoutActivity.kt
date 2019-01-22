package com.takassoftware.managey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.takassoftware.managey.Adapter.InoutListViewAdapter
import com.takassoftware.managey.Constant.IntentExtraConst
import com.takassoftware.managey.Model.InoutListItemModel
import com.takassoftware.managey.Model.MonthlyListItemModel

/**
 * 入出金Activity
 *
 * @author たかお
 * @since 2019.01.22
 */
class InoutActivity : AppCompatActivity() {

    /**
     * onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inout)

        // インテントから入出金IDを取得する
        val inoutId = intent.getStringExtra(IntentExtraConst.INOUT_ID)
        val inoutName = intent.getStringExtra(IntentExtraConst.INOUT_NAME)

        // アクションバーのタイトル表示を変更
        this.title = "入出金一覧（ $inoutName ）"

        // 入出金リストのレイアウト設定
        val inoutListView = findViewById(R.id.inout_list) as RecyclerView
        inoutListView.layoutManager = LinearLayoutManager(this)
        inoutListView.setHasFixedSize(true)

        // 入出金リストに対するadapterの設定
        inoutListView.adapter = InoutListViewAdapter(this.createDataset())

    }

    /**
     * 仮実装：入出金リストに表示するデータセットの作成
     *
     * @return データセット
     */
    private fun createDataset(): List<InoutListItemModel> {
        val dataset = mutableListOf<InoutListItemModel>()
        for (i in 1..8) {
            val data = InoutListItemModel(
                    when(i%3){ 0-> "旅行（宿泊費＋交通費）" 1-> "平日食費等" else -> "休日娯楽費" } ,
                    "10/"+i,
                    "10/"+i,
                    i*(-23000L),
                    i*-(17000L)
            )
            dataset.add(data)
        }
        return dataset
    }

}
