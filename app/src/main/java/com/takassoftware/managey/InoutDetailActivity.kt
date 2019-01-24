package com.takassoftware.managey

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.takassoftware.managey.Adapter.InoutDetailListViewAdapter
import com.takassoftware.managey.Adapter.InoutListViewAdapter
import com.takassoftware.managey.Constant.IntentExtraConst
import com.takassoftware.managey.Model.InoutDetailListItemModel
import com.takassoftware.managey.Model.InoutListItemModel

/**
 * 入出金明細Activity
 *
 * @author たかお
 * @since 2019.01.23
 */
class InoutDetailActivity : AppCompatActivity() {

    /** 入出金リストのデータリスト */
    private var inoutDetailDataList = mutableListOf<InoutDetailListItemModel>()

    /**
     * onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inout_detail)

        // インテントから入出金IDを取得する
        val inoutId = intent.getStringExtra(IntentExtraConst.INOUT_ID)

        // アクションバーのタイトル表示を変更
        this.title = "入出金明細"

        // 入出金リストのレイアウト設定
        val inoutDetailListView = findViewById(R.id.inout_detail_list) as RecyclerView
        inoutDetailListView.layoutManager = LinearLayoutManager(this)
        inoutDetailListView.setHasFixedSize(true)

        // 入出金リストに対するadapterの設定
        inoutDetailListView.adapter = InoutDetailListViewAdapter(this.createDataset())

    }

    /**
     * 仮実装：入出金明細リストに表示するデータセットの作成
     *
     * @return データセット
     */
    private fun createDataset(): List<InoutDetailListItemModel> {
        inoutDetailDataList = mutableListOf<InoutDetailListItemModel>()
        for (i in 1..5) {
            val data = InoutDetailListItemModel(
                    "00000"+i,
                    when(i%3){0-> "旅行（宿泊費＋交通費）" 1-> "平日食費等" else -> "休日娯楽費" } ,
                    i*(-9000L),
                    if(i>3) "1" else "0",
                    when(i){4->"J-WESTカード" 5->"VIEWカード" else -> ""},
                    onLongClickInoutDetailListItem

            )
            inoutDetailDataList.add(data)
        }
        return inoutDetailDataList
    }



    /**
     * 入出金明細リストのonClickイベント
     *
     * @param v onClickが発生したView
     */
    fun onClickInoutDetailListItem(v: View){

    }

    /**
     * 入出金明細リストの項目のonLongClickイベント
     * Listenerの設定はAdapterクラスで実装
     *
     * @param v onLongClickが発生したView
     */
    val onLongClickInoutDetailListItem : (v: View?)->Boolean = {

        // 入出金明細削除ダイアログのレイアウトを作成
        val dialogView = findViewById<ConstraintLayout>(R.id.inout_detail_remove_dialog)
        val inflate = LayoutInflater.from(this).inflate(R.layout.inout_detail_remove_dialog,dialogView)

        // 入出金明細削除ダイアログの表示
        AlertDialog.Builder(this)
                .setTitle("入出金明細の削除")
                .setView(inflate)
                .setNegativeButton("キャンセル", null)
                .setPositiveButton("削除", DialogInterface.OnClickListener { _, _ ->
                    // OKボタン押したときの処理

                    // ロングタップされた項目の入出金IDを取得
                    // 入出金IDからリストの位置を取得する
                    val cleckedInoutDetailId = it?.findViewById<TextView>(R.id.inout_detail_list_item_id)?.text
                    val itemPosition = inoutDetailDataList.indexOfFirst  {it.id == cleckedInoutDetailId}

                    // 入出金を削除する
                    inoutDetailDataList.removeAt(itemPosition)
                    findViewById<RecyclerView>(R.id.inout_detail_list).adapter?.notifyItemRemoved(itemPosition)
                })
                .show()

        true
    }


}
