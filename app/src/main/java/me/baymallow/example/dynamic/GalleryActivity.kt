package me.baymallow.example.dynamic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView

class GalleryActivity : AppCompatActivity() {
    val pictures = arrayOf(R.mipmap.baymax, R.mipmap.inside_out, R.mipmap.zootopia, R.mipmap.olaf)
    val picture_descriptions = arrayOf("Big Hero 6", "Inside Out", "Zootopia", "Olaf's Frozen Adventure")
    lateinit var pictureView: ImageView
    lateinit var descriptionView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        pictureView = findViewById<ImageView>(R.id.picture)
        descriptionView = findViewById<EditText>(R.id.picture_description)
        val nextBtn = findViewById<ImageButton>(R.id.nextbtn)
        val backBtn = findViewById<ImageButton>(R.id.backbtn)

        var index = 0

        nextBtn.setOnClickListener({
            saveDescription(index)
            index += 1
            if(index == pictures.size) index = 0
            setPicture(index)
        })

        backBtn.setOnClickListener({
            saveDescription(index)
            index -= 1
            if(index == -1) index = pictures.size - 1
            setPicture(index)
        })

        setPicture(index)
    }

    private fun setPicture(i: Int){
        pictureView.setImageDrawable(resources.getDrawable(pictures[i]))
        descriptionView.setText(picture_descriptions[i])
    }

    private fun saveDescription(i: Int){
        picture_descriptions[i] = descriptionView.text.toString()
    }
}
