package com.takassoftware.managey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager;
import android.view.View
import android.widget.TextView
import com.takassoftware.managey.Adapter.MonthlyListViewAdapter
import com.takassoftware.managey.Constant.IntentExtraConst
import com.takassoftware.managey.Model.MonthlyListItemModel

/**
 * 月間情報Activity
 *
 * @author たかお
 * @since 2019.01.22
 */
class MonthlyActivity : AppCompatActivity() {

    /**
     * onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly)

        // アクションバーのタイトル表示を変更
        this.title = "月間情報"

        // 月間情報リストのレイアウト設定
        val recyclerView = findViewById(R.id.monthly_list) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        // 月間情報リストに対するadapterの設定
        recyclerView.adapter = MonthlyListViewAdapter(this.createDataset())

    }

    /**
     * 月間情報リストのonClickイベント
     */
    fun onClickMonthlyListItem(v: View) {

        // 週間情報Activityに遷移する
        transWeeklyActivity(v)

    }

    /**
     * 当月残額のonClickイベント
     */
    fun onClickMonthlyRemaining(v: View){

        // 月間情報明細Activityに遷移する
        transMonthlyDetailActivity()

    }

    /**
     * 仮実装：月間情報リストに表示するデータセットの作成
     *
     * @return データセット
     */
    private fun createDataset(): List<MonthlyListItemModel> {
        val dataset = mutableListOf<MonthlyListItemModel>()
        for (i in 1..31) {
            val data = MonthlyListItemModel(title="10/" + i +" 出金")
            dataset.add(data)
        }
        return dataset
    }

    /**
     * 月間情報明細Activityに遷移する
     */
    fun transMonthlyDetailActivity() {

        // 月間情報明細Activityのインテントを作成し、発行する。
        val intent =
                Intent(this, MonthlyDetailActivity::class.java)
                        .putExtra(IntentExtraConst.YEAR,"2018")
                        .putExtra(IntentExtraConst.MONTH,"10")
        startActivity(intent)

    }

    /**
     * 入出金Activityに遷移する
     *
     * @param v onClickイベントが発生したView
     */
    fun transWeeklyActivity(v: View) {

        // 入出金Activityに渡す値を取り出す
        val title = (v.findViewById(R.id.monthly_list_item_title) as TextView).text

        // 入出金Activityのインテントを作成し、発行する。
        val intent =
                Intent(this, InoutActivity::class.java)
                        .putExtra(IntentExtraConst.MONTHLY_EVENT_NAME,title)
                        .putExtra(IntentExtraConst.MONTHLY_EVENT_ID,"000000000001")
        startActivity(intent)

    }

}
