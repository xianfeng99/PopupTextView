package com.jikexueyuan.animview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lixianfeng on 16/2/16.
 */
public class SampleView extends BaseView {

    private Paint paint = new Paint();

    private int x = 0;//文字和图片横坐标
    private int radius = 50;//圆半径

    public SampleView(Context context) {
        super(context);
    }

    public SampleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void drawSub(Canvas canvas) {

        paint.setTextSize(50);
        paint.setColor(Color.BLUE);
        //绘制文字
        canvas.drawText("极客学院", x, 100, paint);
        //绘制几何图形
        canvas.drawCircle(50, 150, radius, paint);
        //绘制图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, x, 200, paint);
    }

    @Override
    protected void logic() {
        modifyTextAndBitmap();
        modifyCircle();
    }


    private void modifyTextAndBitmap(){
        x += 2;
        if (x > getWidth()){
            x = 0;
        }
    }
    private void modifyCircle(){
        radius --;
        if(radius <= 0){
            radius = 50;
        }
    }

}
