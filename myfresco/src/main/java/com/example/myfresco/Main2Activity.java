package com.example.myfresco;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;

    @BindView(R.id.sim_fre)
    SimpleDraweeView simFre;
    private GenericDraweeHierarchyBuilder builder;
    private SimpleDraweeView sim_fre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

        sim_fre = findViewById(R.id.sim_fre);


        builder = new GenericDraweeHierarchyBuilder(getResources());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

// 居中，无缩放
            case R.id.btn1:
// 设置描述

// 样式设置,使图片只显示中间的部分
                GenericDraweeHierarchy CENTER = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER).build();
// 显示图片
                imageDisplay(CENTER);
                break;

// 保持宽高比缩小或放大，使得两边都大于或等于显示边界(也就是裁剪成正方形)。以中间的点为图片中心
            case R.id.btn2:
// 设置描述

// 样式设置,使图片按比例缩小或放大,且裁剪成正方形.
                GenericDraweeHierarchy CENTER_CROP = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build();
// 图片显示
                imageDisplay(CENTER_CROP);
                break;

// 同centerCrop, 但居中点不是中点，而是指定的某个点,这里设置为图片的左上角那点
            case R.id.btn3:
// 设置描述

//指定中心点位置
                PointF point = new PointF(0, 0);
//根据指定的点设置为图片中心,使图片按比例缩小或放大,且裁剪成正方形.
                GenericDraweeHierarchy FOCUS_CROP = builder.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP)
                        .setActualImageFocusPoint(point).build();
// 图片显示
                imageDisplay(FOCUS_CROP);
                break;

//使两边都在显示边界内，居中显示。如果图尺寸大于显示边界，则保持长宽比缩小图片
            case R.id.btn4:
// 设置描述

// 样式设置,使图片按比例显示在控件内,
                GenericDraweeHierarchy CENTER_INSIDE = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build();
// 图片显示
                imageDisplay(CENTER_INSIDE);
                break;

// 保持宽高比，缩小或者放大，使得图片完全显示在显示边界内。居中显示
            case R.id.btn5:
// 设置描述

// 样式设置,保持宽高比例,对图片进行缩或放,图片位置居中显示(效果和上面一种类似)
                GenericDraweeHierarchy FIT_CENTER = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
// 图片显示
                imageDisplay(FIT_CENTER);
                break;


        }
    }


    private void imageDisplay(GenericDraweeHierarchy hierarchy) {
// 加载图片
        Uri uri = Uri.parse("http://img5.imgtn.bdimg.com/it/u=1371186652,2033900083&fm=27&gp=0.jpg");
        builder = new GenericDraweeHierarchyBuilder(getResources());
        sim_fre.setHierarchy(hierarchy);
        sim_fre.setImageURI(uri);
    }


}