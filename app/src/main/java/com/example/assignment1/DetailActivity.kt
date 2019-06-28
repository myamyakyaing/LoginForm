package com.example.assignment1

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity() {
    val REQUEST_IMAGE_GET = 1
    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        imgSearch.setOnClickListener {
            var data = edtSearch.text.toString()
            val browserIntent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                Uri.parse(data)
            }

            startActivity(browserIntent)
        }

        btnPhone.setOnClickListener {
            val callPhone = Intent(Intent.ACTION_DIAL)
            callPhone.setData(Uri.parse("tel:${edtPhone.text.toString()}"))
            startActivity(callPhone)
        }
         btnCamera.setOnClickListener {
             val intent = Intent(Intent.ACTION_GET_CONTENT)
             intent.type = "image/*"
             if (intent.resolveActivity(packageManager) != null) {
                 startActivityForResult(intent, REQUEST_IMAGE_GET)
             }
         }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            val fullPhotoUri: Uri = data!!.data!!
            Glide.with(this).load(fullPhotoUri).into(ivProfileImage)

        }
    }
}
