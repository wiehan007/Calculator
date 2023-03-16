package com.example.mycalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.sqrt
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //stores the user input in variables
        val firstNumber = findViewById<EditText>(R.id.txtFirstNumber)
        val secondNumber = findViewById<EditText>(R.id.txtSecondNumber)

        val txtDispaly = findViewById<TextView>(R.id.DisplayAnswer)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSubtract)
        val btnMul = findViewById<Button>(R.id.btnMultiply)
        val btnDiv = findViewById<Button>(R.id.btnDivide)
        val btnClear = findViewById<Button>(R.id.btnClearEntry)
        val btnPercentage = findViewById<Button>(R.id.btnPercentage)
        val btnPowerOff = findViewById<Button>(R.id.btnPowerOff)
        val btnSqrRoot = findViewById<Button>(R.id.btnSqrRoot)
        val btnPowerOf = findViewById<Button>(R.id.btnPowerOf)
        val secondPage = findViewById<Button>(R.id.btnBack)

        // geeksforgeeks - https://www.geeksforgeeks.org/creating-multiple-screen-applications-in-android/
        secondPage.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            // start the activity connect to the specified class
            startActivity(intent)
        }


        btnSqrRoot.setOnClickListener {

            try{
                val val1 = firstNumber.text.toString().toInt()

                val result = sqrt(val1.toDouble())
                txtDispaly.text = "The Square root of ${val1} is ${result}"

            }
            catch (e: NumberFormatException){
                txtDispaly.text = "please enter a number in the first box"
            }

        }

        btnPowerOff.setOnClickListener {
            //finish()
            exitProcess(0)
        }

        btnPowerOf.setOnClickListener {
            try {
                val base = firstNumber.text.toString().toInt()

                val exponent = secondNumber.text.toString().toInt()
                val result = Math.pow(base.toDouble(), exponent.toDouble())
                var x = 1;
                var expression = "";

                while (x<exponent){

                    expression += "x$base"
                    x++
                }
                txtDispaly.text = "${base}${expression}  = ${result}"

            }
            catch (e: NumberFormatException){
                txtDispaly.text = "please enter numbers in both text boxes"
            }
        }


        //clears textboxes
        btnClear?.setOnClickListener {

            firstNumber.text.clear()
            secondNumber.text.clear()
            txtDispaly.text = "0"
        }

        //gets the percentage of the answer
        btnPercentage?.setOnClickListener {
            try {
                val val1 = firstNumber.text.toString().toInt()
                val val2 = secondNumber.text.toString().toInt()

                val result = Math.round((val1.toDouble() / val2) * 100)
                txtDispaly.text = "${val1.toString()} OF ${val2.toString()} = ${result.toString()}%"
            }
            catch (e: NumberFormatException){
                txtDispaly.text = "please enter numbers"
            }

        }
        //Adds the numbers
        btnAdd?.setOnClickListener{
            try{

                val val1 = firstNumber.text.toString().toInt()
                val val2 = secondNumber.text.toString().toInt()

                val result = (val1 + val2)

                txtDispaly.text = "${val1.toString()} + ${val2.toString()} = ${result.toString()}"
            }
            catch (e: NumberFormatException){
                txtDispaly.text = "please enter numbers"

            }
        }

        //subtracts the numbers
        btnSub?.setOnClickListener{
            try {
                val val1 = firstNumber.text.toString().toInt()
                val val2 = secondNumber.text.toString().toInt()

                val result = (val1 - val2)

                txtDispaly.text = "${val1.toString()} -  ${val2.toString()} = ${result.toString()}"
            }
            catch (e: NumberFormatException){
                txtDispaly.text = "please enter numbers"

            }
        }
        //Multiplies the numbers
        btnMul?.setOnClickListener {
            try{
                val val1 = firstNumber.text.toString().toInt()
                val val2 = secondNumber.text.toString().toInt()

                val result = (val1 * val2)

                txtDispaly.text = "${val1.toString()} * ${val2.toString()} = ${result.toString()}"
            }
            catch (e: NumberFormatException){
                txtDispaly.text = "please enter numbers"

            }
        }

        //divides the numbers
        btnDiv?.setOnClickListener{
            try {
                val val1 = firstNumber.text.toString().toInt()
                val val2 = secondNumber.text.toString().toInt()

                // error to divide by 0
                if(val1== 0 || val2== 0 ){
                    txtDispaly.text = "You cannot divide by 0"
                }
                else{
                    val result = (val1.toDouble() /val2)
                    txtDispaly.text = "${val1.toString()} / ${val2.toString()} = ${result.toString()}"

                }
            }
            catch (e: NumberFormatException){
                txtDispaly.text = "please enter numbers"

            }
        }
    }
}