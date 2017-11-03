package me.baymallow.example.dynamic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Add1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add1)

        val add1btn = findViewById<Button>(R.id.add1btn)
        val mult2btn = findViewById<Button>(R.id.mult2btn)
        val resetbtn = findViewById<Button>(R.id.resetbtn)

        val numberView = findViewById<TextView>(R.id.number)
        var number = 0

        add1btn.setOnClickListener({
            number += 1
            numberView.text = number.toString()
        })

        mult2btn.setOnClickListener({
            number *= 2
            numberView.text = number.toString()
        })

        resetbtn.setOnClickListener({
            number = 0
            numberView.text = number.toString()
            Toast.makeText(baseContext, "Reset complete!", Toast.LENGTH_SHORT).show()
        })
    }
}
