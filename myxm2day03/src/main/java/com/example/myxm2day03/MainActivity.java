package com.example.myxm2day03;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView sim_fre;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        sim_fre.setImageURI(Uri.parse("http://goss.veer.com/creative/vcg/veer/800water/veer-135117694.jpg"));


    }

    private void initView() {
        sim_fre = (SimpleDraweeView) findViewById(R.id.sim_fre);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);


                break;
        }
    }


    private ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
        // 加载图片完毕回调
        @Override
        public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
            super.onFinalImageSet(id, imageInfo, animatable);
            //图片信息对象非空判断
           if (imageInfo == null) {
                return;
            }
            // 获取图片的质量信息
            QualityInfo qualityInfo = imageInfo.getQualityInfo();
            tv.setText("Final image received! " +
                    "\nSize: " + imageInfo.getWidth()                           //图片宽
                    + "x" + imageInfo.getHeight()                               //图片高
                    + "\nQuality level: " + qualityInfo.getQuality()            //图片等级
                    + "\ngood enough: " + qualityInfo.isOfGoodEnoughQuality()   //图片是否效果完全显示
                    + "\nfull quality: " + qualityInfo.isOfFullQuality());      //图片是否完全显示*/
        }

        // 渐进式加载图片回调(只有启用来图片的渐进式,方有效)
        @Override
        public void onIntermediateImageSet(String id, ImageInfo imageInfo) {
            super.onIntermediateImageSet(id, imageInfo);
            tv.setText("IntermediateImageSet image receiced");
        }

        // 加载图片失败回调
        @Override
        public void onFailure(String id, Throwable throwable) {
            super.onFailure(id, throwable);
            //这里的id参数就是图片加载失败的打印信息
            tv.setText("Error loading" + id);
        }
    };


}
