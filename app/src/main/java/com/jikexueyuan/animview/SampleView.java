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
public class SampleView extends View {

    private Paint paint = new Paint();

    private LogicThread logicThread;
    private int x = 0;//文字和图片横坐标
    private int radius = 50;//圆半径

    public SampleView(Context context) {
        super(context);
    }

    public SampleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(logicThread == null){
            logicThread = new LogicThread();
            logicThread.start();
        }

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

    class LogicThread extends Thread{
        @Override
        public void run() {

            while(true){

                modifyTextAndBitmap();
                modifyCircle();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //更新绘制，会调用onDraw方法
                postInvalidate();
            }

        }
    };

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
