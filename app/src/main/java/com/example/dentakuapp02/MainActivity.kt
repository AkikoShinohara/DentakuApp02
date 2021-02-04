package com.example.dentakuapp02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var value: Int = 0

        /* 計算結果をクリアするかどうかを判断するためのフラグ */
        /* trueの時に数字ボタンが押された時に計算結果をクリアする */
        /*
            例えば"="押された時にフラグをtrueにし、
            その後数字ボタンが押された時などにクリアするために使う
        */
        var clear: Boolean = false

        /* 計算処理を行うかどうかを判断するためのフラグ */
        /* trueの時にのみ計算ボタンが押された時に計算処理を行う */
        /*
            例えば"+"押された後に、
            数字ボタンが押されないまま"-"が押された時等は
            計算は行いたくないのでこのフラグを利用して制御する
         */
        var calc: Boolean = false

        /* 演算子を記憶しておく変数 */
        /* nullの可能性あり */
        var operator: String? = null

        /* 数字ボタン */
        val buttonZero: Button = findViewById(R.id.num0)
        val buttonOne: Button = findViewById(R.id.num1)
        val buttonTwo: Button = findViewById(R.id.num2)
        val buttonThree: Button = findViewById(R.id.num3)
        val buttonFour: Button = findViewById(R.id.num4)
        val buttonFive: Button = findViewById(R.id.num5)
        val buttonSix: Button = findViewById(R.id.num6)
        val buttonSeven: Button = findViewById(R.id.num7)
        val buttonEight: Button = findViewById(R.id.num8)
        val buttonNine: Button = findViewById(R.id.num9)

        /* 計算ボタン */
        val buttonAdd: Button = findViewById(R.id.add)
        val buttonMul: Button = findViewById(R.id.mul)
        val buttonSub: Button = findViewById(R.id.sub)
        val buttonDiv: Button = findViewById(R.id.div)

        /* 実行ボタン */
        val buttonEqual: Button = findViewById(R.id.equal)

        /* クリアボタン */
        val buttonClear: Button = findViewById(R.id.clear)

        /* 表示テキスト */
        val textArea: TextView = findViewById(R.id.formula)

        /* 数字ボタンを押された時の処理をまとめた関数 */
        fun numBottunAction(num: String) {
            textArea.text = if (textArea.text.toString() != "0" && clear == false) {
                textArea.text.toString() + num
            } else {
                clear = false
                num
            }
            calc = true
        }

        /* 全て初期値に戻す */
        buttonClear.setOnClickListener {
            textArea.text = "0"
            value = 0
            operator = null
            clear = false
            calc = false
        }
        /* 数字ボタンを押された時の処理 */
        /* 表示領域を更新 */
        buttonZero.setOnClickListener {
            numBottunAction("0");
        }

        buttonOne.setOnClickListener {
            numBottunAction("1");
        }

        buttonTwo.setOnClickListener {
            numBottunAction("2");
        }

        buttonThree.setOnClickListener {
            numBottunAction("3");
        }

        buttonFour.setOnClickListener {
            numBottunAction("4");
        }

        buttonFive.setOnClickListener {
            numBottunAction("5");
        }

        buttonSix.setOnClickListener {
            numBottunAction("6");
        }

        buttonSeven.setOnClickListener {
            numBottunAction("7");
        }

        buttonEight.setOnClickListener {
            numBottunAction("8");
        }

        buttonNine.setOnClickListener {
            numBottunAction("9");
        }

        /* 計算の実処理を行う関数 */
        fun calculation(op: String?): Int {
            return if (op == "+") {
                value + textArea.text.toString().toInt()
            } else if (op == "-") {
                value - textArea.text.toString().toInt()
            } else if (op == "*") {
                value * textArea.text.toString().toInt()
            } else if (op == "/") {
                value / textArea.text.toString().toInt()
            } else {
                textArea.text.toString().toInt()
            }
        }

        /* 計算ボタンを押された時の処理をまとめた関数 */
        fun calcBottunAction(op: String?) {
            /* 計算処理有効の場合のみ計算と表示の更新を行う */
            if (calc == true) {
                value = calculation(operator)
                clear = true
                calc = false
                textArea.text = value.toString()
            }
            /* 演算子は計算処理無効でも更新 */
            operator = op
        }
        /* 計算ボタンが押された時の処理 */
        buttonAdd.setOnClickListener {
            calcBottunAction("+")
        }

        buttonMul.setOnClickListener {
            calcBottunAction("*")
        }

        buttonSub.setOnClickListener {
            calcBottunAction("-")
        }

        buttonDiv.setOnClickListener {
            calcBottunAction("/")
        }
        /* "="ボタンが押された時の処理 */
        buttonEqual.setOnClickListener {
            /* 計算処理有効の場合のみ計算と表示の更新を行う */
            if (calc == true) {
                value = calculation(operator)
                calc = false
                clear = true
                textArea.text = value.toString()
                operator = null
            }
        }

    }
}