package com.takassoftware.managey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.Intent
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    // ボタンをクリックした時のイベントです
    fun onClick(v: View) {

        // リソースIDに応じて処理を確定させます
        val func = when (v.id) {

            // ログインボタンのイベント
            R.id.main_login_button -> fun(v:View){
                authorizationUser(v)
            }

            // 新規登録ボタンのイベント
            R.id.main_entry_button -> fun(v:View){
                transEntryActivity(v)
            }

            // 定義していないボタンのイベント
            else -> fun(v:View){}
        }

        // イベント処理を実行します
        func(v)

    }

    // ログイン認証を行います
    fun authorizationUser(v: View){

        // 画面からメールアドレスとパスワードを取得し、認証用文字列を生成します。
        // 作成した文字列を認証APIに送り、認証結果を受け取ります。
        // TODO 認証用文字列を作成する処理を実装する
        val mailAddress = (findViewById<EditText>(R.id.main_mailaddress)).text.toString()
        val password = (findViewById<EditText>(R.id.main_password)).text.toString()
        val authorizeString = ""

        // TODO 認証APIにリクエストを送信する処理を実装する
        // function(..)

        // TODO 認証結果とアクセストークンの受信処理を実装する
        val authorizedResult = true
        val accessToken = ""

        // 認証結果を判定します。
        // 認証結果OKの場合は、アクセストークンをセットして次の画面に遷移します。
        // 認証結果NGの場合は、メッセージを表示して画面に留まります。
        if (authorizedResult){
            transMonthlyActivity(v)
        }else{
            Toast.makeText(applicationContext, "ログインできません", Toast.LENGTH_LONG).show()
        }

    }

    // 月間情報画面に遷移します
    fun transMonthlyActivity(v:View){

        // MonthlyActivityのインテントを作成、発行します。
        val intent = Intent(this, MonthlyActivity::class.java)
        startActivity(intent)

    }

    // 新規登録画面に遷移します
    fun transEntryActivity(v: View) {

        // EntryActivityのインテントを作成、発行します。
        val intent = Intent(this, EntryActivity::class.java)
        startActivity(intent)

    }

}
