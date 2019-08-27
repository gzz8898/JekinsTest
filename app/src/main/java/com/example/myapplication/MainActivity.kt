package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.TextView
import android.widget.Toast
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File


class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0
        val text=TextView(this)
        btn.setOnClickListener {
            Toast.makeText(this,crv.getRatingNum().toString(),1).show()
            btn.compoundDrawables[0].level = count
//            ltv.setLevel(count)
            count++

          /*  val file = File(Environment.getExternalStorageDirectory(), "output${count++}.jpg")
            file.createNewFile()*/

/*            PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .isCamera(true)
                .compress(true)
                .glideOverride(100, 100)
                .enableCrop(true)
                .freeStyleCropEnabled(true)
                .forResult(PictureConfig.CHOOSE_REQUEST)//结果回调onActivityResult code*/
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /*     val data = PictureSelector.obtainMultipleResult(data)
             println("requestCode = [${requestCode}], resultCode = [${resultCode}], data = [${data}]")
             for (item in data) {
                 Glide.with(this).load(item.path).into(iv)
             }*/
    }
}

/*interface MyImagePicker {

    @Gallery    //打开相册选择图片
    @AsFile     //返回值为File类型
    fun openGallery(): Observable<File>

    @Camera    //打开相机拍照
    @AsBitmap  //返回值为Bitmap类型
    fun openCamera(): Observable<Bitmap>
}*/
