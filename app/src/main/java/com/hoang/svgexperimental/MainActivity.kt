package com.hoang.svgexperimental

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.PictureDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.caverock.androidsvg.RenderOptions
import com.caverock.androidsvg.SVG
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val svg = SVG.getFromAsset(assets, "map_sample_1500.svg")
        val picture = svg.renderToPicture(RenderOptions())
        val bitmap = Bitmap.createBitmap(picture.width, picture.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawPicture(picture)
        touch_image_view.maxZoom = 25f
        touch_image_view.minZoom = 1f
        touch_image_view.setImageBitmap(bitmap)
//        touch_image_view.setImageDrawable(PictureDrawable(picture))
    }
}
