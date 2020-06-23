package com.fundinghelp.cameraonlykotlinwithcrop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_index.*

class Index : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        btnCandG.setOnClickListener {
            val intent = Intent(this, CameraAndGalleryActivity::class.java)
            startActivity(intent)
        }

        btnCorG.setOnClickListener {
            val intent = Intent(this, CameraOrGalleryActivity::class.java)
            startActivity(intent)
        }
    }
}