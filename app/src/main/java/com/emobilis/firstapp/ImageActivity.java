package com.emobilis.firstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;

import java.io.File;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ImageActivity extends AppCompatActivity {

    //declare the views
    ImageView imageView;
    Button button;
    //variable for request code
    private static final int PICK_FROM_GALLERY = 2222;
    //file
    File file0,file1,file2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        //view identification
        imageView = findViewById(R.id.imageContainer);
        button = findViewById(R.id.pickImage);

        //set a click listener to the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });



        //permissionCheck();

    }


    private void permissionCheck(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            //request permission
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE},PICK_FROM_GALLERY);

        }
    }

    //method pick image
    private void pickImage(){
        //use Image Picker lib
        //check if permissions are granted if not granted request permissions

            //launch image picker
            ImagePicker.create(this)
                    .multi()
                    .limit(3)
                    .start();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (ImagePicker.shouldHandle(requestCode,resultCode,data)){
            //store multiple images picked
            List<Image> images = ImagePicker.getImages(data);
            //store single image
            Image image = ImagePicker.getFirstImageOrNull(data);

            //give progress to user
            SweetAlertDialog successDialog  = new SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE);
            //to change color of progress dialog
            successDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            //set text to dialog
            successDialog.setTitle("Image Selection");
            successDialog.setTitleText(images.size() + " images selected");
            successDialog.setCancelable(true);
            successDialog.setCanceledOnTouchOutside(false);
            //to ovveride the click event
            successDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    //dismiss dialog
                    sweetAlertDialog.dismissWithAnimation();
                    //checking if images selected are of the required quantity
                    if (images.size() < 3){
                        //error Dialog
                        SweetAlertDialog errorDialog  = new SweetAlertDialog(ImageActivity.this,SweetAlertDialog.ERROR_TYPE);
                        errorDialog.setTitle("Images not selected");
                        errorDialog.setTitleText("Make sure you select 3 images");
                        errorDialog.setCancelable(true);
                        errorDialog.setCanceledOnTouchOutside(false);
                        errorDialog.show();
                    } else {
                        file0 = new File(images.get(0).getPath());
                        file1 = new File(images.get(1).getPath());
                        file2 = new File(images.get(2).getPath());

                        //display image
                        //setting selected image to my imageview
                        Glide.with(ImageActivity.this)
                                .load(file2)
                                .into(imageView);
                    }

                }
            });

            //show the success
            successDialog.show();

        }

        super.onActivityResult(requestCode, resultCode, data);
    }


}
