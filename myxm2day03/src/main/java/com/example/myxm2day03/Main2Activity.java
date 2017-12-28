package com.example.myxm2day03;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView simyuan;
    private SimpleDraweeView sim;
    private Button btnstart;
    private Button btnclear;
    private Button btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

        //加载动态图
        DraweeController mDraweeController = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(false)
                .setUri(Uri.parse("http://g.hiphotos.baidu.com/baike/s=220/sign=8ff6e4694fc2d562f608d7efd71090f3/a9d3fd1f4134970a06805a2695cad1c8a6865dc3.jpg"))//设置uri
                .setOldController(sim.getController())//内存优化

                .build();
      //设置Controller
        sim.setController(mDraweeController);



     /*   GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        // 设置圆形图片
// 设置形状对象,形状为圆形
        RoundingParams params = RoundingParams.asCircle();
//创建设置参数,设置一个形状,把形状对象塞入
        GenericDraweeHierarchy roundness = builder.setRoundingParams(params).build();
//将参数对象设置给图片控件
        simyuan.setHierarchy(roundness);



//控件加载图片（加载）
        simyuan.setImageURI(Uri.parse("http://img01.store.sogou.com/app/a/10010016/9eb8e1b95afbc3dd5a88ce363d7d4e36"));*/






//builder对象用一个即可,在这里创建出成员变量
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());

        // 设置圆角图片
//设置边角的弧度,使其为圆角
        RoundingParams params = RoundingParams.fromCornersRadius(50f);
//设置图片控件的背景颜色
        params.setOverlayColor(getResources().getColor(android.R.color.holo_red_light));//覆盖层
//设置图片的边框颜色及边框的粗细
        params.setBorder(getResources().getColor(android.R.color.holo_blue_light), 5);//边框
//这里的代码和设置圆形图片这一块代码是一种的,唯一不同就是对parames的设置.
        GenericDraweeHierarchy circularBead =builder.setRoundingParams(params).build();
        simyuan.setHierarchy(circularBead);
// 加载图片
        simyuan.setImageURI("http://img01.store.sogou.com/app/a/10010016/9eb8e1b95afbc3dd5a88ce363d7d4e36");







    }

    private void initView() {
        simyuan = (SimpleDraweeView) findViewById(R.id.simyuan);
        sim = (SimpleDraweeView) findViewById(R.id.sim);
        btnstart = (Button) findViewById(R.id.btnstart);
        btnclear = (Button) findViewById(R.id.btnclear);
        btnstop = (Button) findViewById(R.id.btnstop);

        btnstart.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        btnstop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnstart:

                //拿到动画对象
                Animatable animatableStart = sim.getController().getAnimatable();
                //进行非空及是否动画在播放判断
                if(animatableStart != null && !animatableStart.isRunning()) {
                    //动画停止播放,播放动画
                    animatableStart.start();


                }

                    break;
            case R.id.btnclear:


                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                imagePipeline.clearMemoryCaches();
                imagePipeline.clearDiskCaches();

// combines above two lines
                imagePipeline.clearCaches();





                break;
            case R.id.btnstop:
                // 动画停止
                //拿到动画对象
                Animatable animatableStop = sim.getController().getAnimatable();
                //进行非空及是否动画在播放判断
                if (animatableStop != null && animatableStop.isRunning()) {
                    //动画在播放,停止动画播放
                    animatableStop.stop();


                }

                    break;
        }
    }
}
