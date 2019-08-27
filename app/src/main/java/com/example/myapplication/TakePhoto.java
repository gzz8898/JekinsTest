/*
package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class TakePhoto {
    */
/**
     * 拍照
     *//*

    public static Uri takePhoto(Activity mActivity, int flag) throws IOException {

 */
/*       //取消严格模式  FileProvider
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        Intent takePictureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        Uri imageUri = null;
        if (takePictureIntent.resolveActivity(mActivity.getPackageManager()) != null) {
            String sdcardState = Environment.getExternalStorageState();
            File outputImage = null;
            if (Environment.MEDIA_MOUNTED.equals(sdcardState)) {
                outputImage = createImageFile(mActivity);
            } else {
                Toast.makeText(mActivity.getApplicationContext(), "内存异常", Toast.LENGTH_SHORT).show();
            }
            try {
                if (outputImage.exists()) {
                    outputImage.delete();
                }
                outputImage.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (outputImage != null) {
                imageUri = Uri.fromFile(outputImage);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                mActivity.startActivityForResult(takePictureIntent, flag);
            }
        }*//*


     */
/*   System.out.println("图片地址" + imageUri.getPath());
        return imageUri;*//*

    }
}
*/
