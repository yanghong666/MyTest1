package com.example.myfresco;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.sim_fre)
    SimpleDraweeView simFre;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    private Uri uri;
    private GenericDraweeHierarchyBuilder builder;
    private RoundingParams params;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);

        btn1.setOnClickListener(this);

        btn2.setOnClickListener(this);


        //加载图片的网址
        uri = Uri.parse("http://img01.store.sogou.com/app/a/10010016/9eb8e1b95afbc3dd5a88ce363d7d4e36");

//builder对象用一个即可,在这里创建出成员变量
        builder = new GenericDraweeHierarchyBuilder(getResources());







    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn1:





                // 设置圆形图片
// 设置形状对象,形状为圆形
                params = RoundingParams.asCircle();
//创建设置参数,设置一个形状,把形状对象塞入
                GenericDraweeHierarchy roundness = builder.setRoundingParams(params).build();
//将参数对象设置给图片控件
                simFre.setHierarchy(roundness);
//控件加载图片
                simFre.setImageURI(uri);




                break;

            case R.id.btn2:







                // 设置圆角图片
//设置边角的弧度,使其为圆角
                params = RoundingParams.fromCornersRadius(50f);
//设置图片控件的背景颜色
                params.setOverlayColor(getResources().getColor(android.R.color.holo_red_light));//覆盖层
//设置图片的边框颜色及边框的粗细
                params.setBorder(getResources().getColor(android.R.color.holo_blue_light), 5);//边框
//这里的代码和设置圆形图片这一块代码是一种的,唯一不同就是对parames的设置.
                GenericDraweeHierarchy circularBead =builder.setRoundingParams(params).build();
                simFre.setHierarchy(circularBead);
// 加载图片
                simFre.setImageURI(uri);




                break;


        }
    }
}
