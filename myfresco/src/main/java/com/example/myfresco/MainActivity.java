package com.example.myfresco;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    private SimpleDraweeView sdv;
    private SimpleDraweeView sim_fre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* 加载图片方法2
        sdv = (SimpleDraweeView) findViewById(R.id.main_simple_drawee_view);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        sdv.setController(controller);*/
 //加载静态图方法1
       // sim_fre.setImageURI(Uri.parse("http://g.hiphotos.baidu.com/baike/s=220/sign=8ff6e4694fc2d562f608d7efd71090f3/a9d3fd1f4134970a06805a2695cad1c8a6865dc3.jpg"));

        sim_fre = (SimpleDraweeView)this.findViewById(R.id.sim_fre);
        DraweeController mDraweeController = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)
                //设置uri,加载本地的gif资源
                //"res://"+getPackageName()+"/"+R.drawable.e   本地的
                .setUri(Uri.parse("http://g.hiphotos.baidu.com/baike/s=220/sign=8ff6e4694fc2d562f608d7efd71090f3/a9d3fd1f4134970a06805a2695cad1c8a6865dc3.jpg"))//设置uri
                .build();
//设置Controller
        sim_fre.setController(mDraweeController);
    }
}