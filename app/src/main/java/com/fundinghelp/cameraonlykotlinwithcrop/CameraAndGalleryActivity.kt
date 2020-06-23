package com.fundinghelp.cameraonlykotlinwithcrop

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import java.io.File

class CameraAndGalleryActivity : AppCompatActivity() {
    private var fileName: String? = null
    var file: File? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSelectImageClick(view: View?) {
        CropImage.activity(null).setGuidelines(CropImageView.Guidelines.ON).start(this)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {

        // handle result of CropImageActivity
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode == Activity.RESULT_OK) {
                try {


                    //Uri uri = data.getParcelableExtra("path");
                    val uri = result.uri
                    file = File(uri.path)
                    fileName = uri.lastPathSegment
                    Log.e("file", file.toString())
                    Log.e("fileName", fileName + "")
                    (findViewById<View>(R.id.quick_start_cropped_image) as ImageView).setImageURI(
                        result.uri
                    )
                    //Toast.makeText(this, "Cropping successful : " + result.getSampleSize(), Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Cropping successful ", Toast.LENGTH_LONG).show()

                } catch (e: Error) {
                    e.printStackTrace()
                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Toast.makeText(this, "Cropping failed: " + result.error, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}