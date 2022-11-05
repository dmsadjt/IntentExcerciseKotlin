package com.example.exercisetwo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moveBtnActivity: Button = findViewById(R.id.btn_move_activity)
        moveBtnActivity.setOnClickListener(this)

        val moveBtnActivityWithData : Button = findViewById(R.id.btn_move_activity_data)
        moveBtnActivityWithData.setOnClickListener(this)

        val moveBtnActivityWithObject : Button = findViewById(R.id.btn_move_activity_object)
        moveBtnActivityWithObject.setOnClickListener(this)

        val dialBtnPhone : Button = findViewById(R.id.btn_dial_number)
        dialBtnPhone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveDataWithIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveDataWithIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Dhinny")
                moveDataWithIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 19)
                startActivity(moveDataWithIntent)
            }

            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Dhinny",
                    5,
                    "erlya@dhinny.com",
                    "Surabaya"
                )

                val moveObjectWithParcel = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveObjectWithParcel.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveObjectWithParcel)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "087855141171"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }


        }
    }
}