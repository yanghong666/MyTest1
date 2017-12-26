package com.example.myfresco;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

public class Main8Activity extends AppCompatActivity implements View.OnClickListener{

    private SimpleDraweeView sdv_fresco_modify;
    private Button bt_fresco_modify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //修改图片
            case R.id.bt_fresco_modify:
                // 图片地址
                Uri uri = Uri.parse("http://img03.store.sogou.com/app/a/10010016/e9eb654736094b21f82dc2d5ef17538f");

                // 修改图片
                Postprocessor postProcessor = new BasePostprocessor() {
                    //重新Postprocessor名称.
                    @Override
                    public String getName() {
                        return "postProcessor";
                    }
                    //具体的进行绘制,bitmap就是下载过来的图片,绘制红色点状网络
                    @Override
                    public void process(Bitmap bitmap) {

                        for (int x = 0; x < bitmap.getWidth(); x += 2) {
                            for (int y = 0; y < bitmap.getHeight(); y += 2) {
                                //给图片点设置颜色,参数X轴,Y轴,颜色
                                bitmap.setPixel(x, y, Color.RED);
                            }
                        }
                    }
                };
                // 创建图片请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        //对加载进行处理.参数就是处理的模型Postprocessor对象.
                        .setPostprocessor(postProcessor)
                        .build();
                // 控制加载
                PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setOldController(sdv_fresco_modify.getController())
                        .setImageRequest(request)
                        .build();
                // 加载图片
                sdv_fresco_modify.setController(controller);
                break;
        }
    }

    private void initView() {
        sdv_fresco_modify = (SimpleDraweeView) findViewById(R.id.sdv_fresco_modify);
        bt_fresco_modify = (Button) findViewById(R.id.bt_fresco_modify);

        bt_fresco_modify.setOnClickListener(this);
    }

}

