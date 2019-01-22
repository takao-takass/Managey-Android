package com.takassoftware.managey

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import com.takassoftware.managey.Constant.IntentExtraConst
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.takassoftware.managey.Adapter.MonthlyDetailCardUsedListViewAdapter
import com.takassoftware.managey.CommonProcess.StringProcessing
import com.takassoftware.managey.CommonProcess.ValueProcessing
import com.takassoftware.managey.Model.MonthlyDetailCardUsedListItemModel
import com.takassoftware.managey.Model.MonthlyListItemModel
import kotlinx.android.synthetic.main.monthly_amount_input_dialog.view.*
import kotlinx.android.synthetic.main.monthly_income_input_dialog.view.*
import java.util.zip.Inflater

/**
 * 月間情報明細Activity
 *
 * @author たかお
 * @since 2019.01.22
 */
class MonthlyDetailActivity : AppCompatActivity() {

    /**
     * onCreate
     */
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

    /**
     * 当月貯金額のonClickイベント
     */
    fun onClickMonthlyAmount(v: View) {

        // 貯金額の取得
        val amountLabel = findViewById<TextView>(R.id.monthly_detail_monthly_amount)

        // 貯金額変更ダイアログのレイアウトを作成
        val dialogView = findViewById<ConstraintLayout>(R.id.monthly_amount_input_dialog)
        val inflate = LayoutInflater.from(this).inflate(R.layout.monthly_amount_input_dialog,dialogView)
        val amountLong =
                StringProcessing().removeCommaToLong(amountLabel.text.toString())/1000L
        inflate.monthly_amount_input_dialog_amount.setText(amountLong.toString())

        // 貯金額変更ダイアログの表示
        AlertDialog.Builder(this)
                .setTitle("貯金額の変更")
                .setView(inflate)
                .setNegativeButton("キャンセル", null)
                .setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                    // OKボタン押したときの処理
                    // 貯金額の取得と設定
                    val inputAmountText = inflate.monthly_amount_input_dialog_amount.text.toString()
                    val amount = StringProcessing().emptyToZero(inputAmountText).toLong()
                    amountLabel.text = ValueProcessing().separateValuesComma(amount*1000L)
                })
                .show()

    }

    /**
     * 収入１～収入３のonClickイベント
     */
    fun onClickIncome(v: View) {

        // タップした項目のタグで収入１～３を分岐する
        val incomeNameLabel = when(v.tag){
            "1" -> findViewById<TextView>(R.id.monthly_detail_income1_label)
            "2" -> findViewById<TextView>(R.id.monthly_detail_income2_label)
            "3" -> findViewById<TextView>(R.id.monthly_detail_income3_label)
            else -> TextView(this)
        }
        val incomeAmountLabel = when(v.tag){
            "1" -> findViewById<TextView>(R.id.monthly_detail_income1)
            "2" -> findViewById<TextView>(R.id.monthly_detail_income2)
            "3" -> findViewById<TextView>(R.id.monthly_detail_income3)
            else -> TextView(this)
        }

        // 貯金額変更ダイアログのレイアウトを作成
        val dialogView = findViewById<ConstraintLayout>(R.id.monthly_income_input_dialog)
        val inflate = LayoutInflater.from(this).inflate(R.layout.monthly_income_input_dialog,dialogView)
        inflate.monthly_income_input_dialog_name.setText(incomeNameLabel.text.toString())
        val amountText =
                StringProcessing().removeCommaToLong(incomeAmountLabel.text.toString())/1000L
        inflate.monthly_income_input_dialog_amount.setText(amountText.toString())

        // 貯金額変更ダイアログの表示
        AlertDialog.Builder(this)
                .setTitle("収入の変更")
                .setView(inflate)
                .setNegativeButton("キャンセル", null)
                .setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                    // OKボタン押したときの処理
                    // 収入名の取得と設定
                    incomeNameLabel.text = inflate.monthly_income_input_dialog_name.text.toString()

                    // 収入額の取得と設定
                    val inputAmountText = inflate.monthly_income_input_dialog_amount.text.toString()
                    val amount = StringProcessing().emptyToZero(inputAmountText).toLong()
                    incomeAmountLabel.text = ValueProcessing().separateValuesComma(amount*1000L)
                })
                .show()

    }


    /**
     * 【仮実装】月間情報リストに表示するデータセットの作成
     * @return データセット
     */
    private fun createDataset(): List<MonthlyDetailCardUsedListItemModel> {
        val dataset = mutableListOf<MonthlyDetailCardUsedListItemModel>()
        for (i in 1..4) {
            val data = MonthlyDetailCardUsedListItemModel("カード"+i,i*85000L)
            dataset.add(data)
        }
        return dataset
    }
}
