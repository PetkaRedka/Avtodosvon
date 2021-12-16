package com.example.avtodosvon

import android.Manifest
import android.Manifest.*
import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_dial.setOnClickListener(){

            number = et_phone_no.text.toString().trim()

            val intent = Intent(Intent.ACTION_CALL)
            intent.setData(Uri.parse("tel:$number"))

            if (ContextCompat.checkSelfPermission(this, CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            }

        }

    }
}