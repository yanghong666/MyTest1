package com.example.myfresco;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main4Activity extends AppCompatActivity {

    @BindView(R.id.sim_fre)
    SimpleDraweeView simFre;
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //所要加载图片的网址
                Uri uri = Uri.parse("http://img03.store.sogou.com/app/a/10010016/9084637b2fb53cedcaf5f2b440c7e079");

                //创建Builder对象,一般创建出参数对象
                GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());


                //创建参数对象,设置其样式为进度条

                GenericDraweeHierarchy hierarchy = builder.setProgressBarImage(new ProgressBarDrawable()).build();


                //将参数对象设置给图片控件
                 simFre.setHierarchy(hierarchy);
                //控件加载图片,参数:网络图片的网址.
                simFre.setImageURI(uri);

            }
        });


    }


}
