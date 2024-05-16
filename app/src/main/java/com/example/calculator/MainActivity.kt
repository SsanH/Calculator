package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {

    private var firstNumber: String = ""
    private var operator: String = ""
    private var secondNumber: String = ""
    private var flag = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        val txtView = listOf<TextView>(
            this.findViewById(R.id.firstNumber),
            this.findViewById(R.id.Operator),
            this.findViewById(R.id.secondNumber)
        )

        val numberButtons = listOf<Button>(
            this.findViewById(R.id.button0),
            this.findViewById(R.id.button1),
            this.findViewById(R.id.button2),
            this.findViewById(R.id.button3),
            this.findViewById(R.id.button4),
            this.findViewById(R.id.button5),
            this.findViewById(R.id.button6),
            this.findViewById(R.id.button7),
            this.findViewById(R.id.button8),
            this.findViewById(R.id.button9)
        )

        val operatorButtons = listOf<Button>(
            this.findViewById(R.id.buttonPlus), this.findViewById(R.id.buttonMinus),
            this.findViewById(R.id.buttonMultp), this.findViewById(R.id.buttonDiv)
        )

        for (button in numberButtons) {
            button.setOnClickListener {
                this.appendNumber((it as Button).text.toString(), txtView)
            }
        }

        for (button in operatorButtons) {
                button.setOnClickListener {
                    if (this.flag == 1) {
                    this.appendOperator((it as Button).text.toString(), txtView)
                }
            }
        }

        var resultButton = findViewById<Button>(R.id.buttonEq)

        resultButton.setOnClickListener {
            this.ReturnResult()
        }

        var clearButton = findViewById<Button>(R.id.buttonCLEAR)

        clearButton.setOnClickListener {
            this.ClearCalc(txtView)
        }

    }

    private fun appendNumber(value: String, arr: List<TextView>) {
        if (this.flag == 1) {
            this.firstNumber += value
            arr[0].setText(firstNumber)
        } else {
            this.secondNumber += value
            arr[2].setText(secondNumber)
        }
    }

    private fun appendOperator(value: String, arr: List<TextView>) {
        this.flag = 2
        this.operator += value
        arr[1].setText(operator)
    }

    private fun ReturnResult() {
        val num1 = this.firstNumber.toDouble()
        val num2 = this.secondNumber.toDouble()
        val n1plusn2 = num1 + num2
        val n1minusn2 = num1 - num2
        val n1multpn2 = num1 * num2
        val n1divn2 = num1 / num2

        when (operator) {
            "+" -> Toast.makeText(this, "$n1plusn2", Toast.LENGTH_SHORT).show()
            "-" -> Toast.makeText(this, "$n1minusn2", Toast.LENGTH_SHORT).show()
            "*" -> Toast.makeText(this, "$n1multpn2", Toast.LENGTH_SHORT).show()
            "/" -> Toast.makeText(this, "$n1divn2", Toast.LENGTH_SHORT).show()
        }

    }

    private fun ClearCalc(arr: List<TextView>) {
        for (a in arr){
            a.setText("")
        }
        this.operator = ""
        this.firstNumber = ""
        this.secondNumber = ""
        this.flag = 1
    }


}










