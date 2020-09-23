package com.hh1995.myapplication.calendarteam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MemoActivity extends AppCompatActivity {

    private static final int REQUEST_PICK_FROM_ALBUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        //DB로부터 메모, 그림을 얻어와서 표시한다.
        SetContent();

        ImageButton btn_addPic = findViewById(R.id.btn_memo_addPicture);
        btn_addPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispathPictureFromGallery();
            }
        });

        TextView tv_memoSave = findViewById(R.id.tv_memo_save);
        tv_memoSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SaveMemo();
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != AppCompatActivity.RESULT_OK)
            return;

        if(requestCode == REQUEST_PICK_FROM_ALBUM)
        {
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                Bitmap bm = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                ImageView imageView = findViewById(R.id.iv_memo_picture);
                imageView.setImageBitmap(bm);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void pickPictureFormGallery()
    {
        Intent intentGallery = new Intent(Intent.ACTION_GET_CONTENT);
        intentGallery.setType("image/*");
        startActivityForResult(Intent.createChooser(intentGallery, "Get Album"), REQUEST_PICK_FROM_ALBUM);
    }


    private void dispathPictureFromGallery()
    {
        //필요하다면 권한요청

        pickPictureFormGallery();
    }

    private void SetContent()
    {
        Intent intent = getIntent();
        int pos = intent.getExtras().getInt("position");
        //pos와 날짜로 DB쿼리
    }

    private void SaveMemo()
    {
        //DB에 정보삽입 (글, 그림)
    }


}