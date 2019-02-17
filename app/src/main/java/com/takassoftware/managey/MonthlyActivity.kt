package com.takassoftware.managey

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.takassoftware.managey.Adapter.MonthlyListViewAdapter
import com.takassoftware.managey.Constant.IntentExtraConst
import com.takassoftware.managey.Model.MonthlyListItemModel
import android.widget.Toast



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

        // イベント追加FABのイベントリスナ
        val addFab = findViewById<FloatingActionButton>(R.id.monthly_add_fab)
        addFab.setOnClickListener(onClickAddFab)

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
     * 設定のonClickイベント
     */
    fun onClickSetting(v: View){

        // 設定メニューActivityに遷移する
        transSettingMenuActivity()

    }

    /**
     * 追加FABのonClickイベント
     * @param v onClickが発生したView
     */
    val onClickAddFab : (v: View)->Unit = {

        // イベント追加ダイアログを表示する
        val dialogView = findViewById<ConstraintLayout>(R.id.monthly_event_add_dialog)
        val inflate = LayoutInflater.from(this).inflate(R.layout.monthly_event_add_dialog,dialogView)

        // 入出金削除ダイアログの表示
        AlertDialog.Builder(this)
                .setTitle("イベントの登録")
                .setView(inflate)
                .setNegativeButton("キャンセル", null)
                .setPositiveButton("登録", DialogInterface.OnClickListener { _, _ ->
                    // OKボタン押したときの処理
                    // イベントタイトルを取得して登録する

                })
                .show()
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

    /**
     * 設定メニューActivityに遷移する
     */
    fun transSettingMenuActivity() {

        // 設定メニューActivityのインテントを作成し、発行する。
        val intent =
                Intent(this, SettingMenuActivity::class.java)
        startActivity(intent)

    }

}
