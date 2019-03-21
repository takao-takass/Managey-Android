package com.takassoftware.managey

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.takassoftware.managey.Adapter.InoutListViewAdapter
import com.takassoftware.managey.Constant.IntentExtraConst
import com.takassoftware.managey.Model.InoutListItemModel

/**
 * 入出金Activity
 *
 * @author たかお
 * @since 2019.01.22
 */
class InoutActivity : AppCompatActivity() {

    /** 入出金リストのデータリスト */
    private var inoutDataList = mutableListOf<InoutListItemModel>()

    /**
     * onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inout)

        // インテントから入出金IDを取得する
        val inoutId = intent.getStringExtra(IntentExtraConst.MONTHLY_EVENT_ID)
        val inoutName = intent.getStringExtra(IntentExtraConst.MONTHLY_EVENT_NAME)

        // アクションバーのタイトル表示を変更
        this.title = "入出金一覧（ $inoutName ）"

        // イベント追加FABのイベントリスナ
        val addFab = findViewById<FloatingActionButton>(R.id.inout_add_fab)
        addFab.setOnClickListener(onClickAddFab)

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
        inoutDataList = mutableListOf<InoutListItemModel>()
        for (i in 1..8) {
            val data = InoutListItemModel(
                    "00000"+i,
                    when(i%3){0-> "旅行（宿泊費＋交通費）" 1-> "平日食費等" else -> "休日娯楽費" } ,
                    "10/"+i,
                    "10/"+i,
                    i*(-23000L),
                    i*-(17000L),
                    onLongClickInoutListItem

            )
            inoutDataList.add(data)
        }
        return inoutDataList
    }

    /**
     * 入出金リストのonClickイベント
     *
     * @param v onClickが発生したView
     */
    fun onClickInoutListItem(v:View){

        // 入出金明細Activityのインテントを作成し、発行する。
        val intent =
                Intent(this, InoutDetailActivity::class.java)
                        .putExtra(IntentExtraConst.INOUT_ID,"000000000001")
        startActivity(intent)
    }


    /**
     * 入出金リストの項目のonLongClickイベント
     * Listenerの設定はAdapterクラスで実装
     *
     * @param v onLongClickが発生したView
     */
    val onLongClickInoutListItem : (v: View?)->Boolean = {

        // 入出金削除ダイアログのレイアウトを作成
        val dialogView = findViewById<ConstraintLayout>(R.id.inout_remove_dialog)
        val inflate = LayoutInflater.from(this).inflate(R.layout.inout_remove_dialog,dialogView)

        // 入出金削除ダイアログの表示
        AlertDialog.Builder(this)
               .setTitle("入出金の削除")
                .setView(inflate)
                .setNegativeButton("キャンセル", null)
                .setPositiveButton("削除", DialogInterface.OnClickListener { _, _ ->
                    // OKボタン押したときの処理

                    // ロングタップされた項目の入出金IDを取得
                    // 入出金IDからリストの位置を取得する
                    val cleckedInoutId = it?.findViewById<TextView>(R.id.inout_list_item_id)?.text
                    val itemPosition = inoutDataList.indexOfFirst  {it.id == cleckedInoutId}

                    // 入出金を削除する
                    inoutDataList.removeAt(itemPosition)
                    findViewById<RecyclerView>(R.id.inout_list).adapter?.notifyItemRemoved(itemPosition)
                })
                .show()

        true
    }

    /**
     * 追加FABのonClickイベント
     * @param v onClickが発生したView
     */
    val onClickAddFab : (v: View)->Unit = {

        // 入出金登録Activityのインテントを作成し、発行する。
        val intent =
                Intent(this, InoutEntryActivity::class.java)
        startActivity(intent)
    }

}
