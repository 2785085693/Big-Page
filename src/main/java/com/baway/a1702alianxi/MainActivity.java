package com.baway.a1702alianxi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button but1;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }


    private void initView() {
        but1 = (Button) findViewById(R.id.but1);
        img = (ImageView) findViewById(R.id.img);

        but1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but1:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,1000);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK) {
            //得到相册的图片
            Uri data1 = data.getData();

            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(data1,"image/*");


        }
        if (requestCode == 200 && resultCode == RESULT_OK){
            final Parcelable data1 = data.getParcelableExtra("data");
            Glide.with(MainActivity.this).load(data1).into(img);

        }
    }
}
