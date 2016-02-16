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

    public SampleView(Context context) {
        super(context);
    }

    public SampleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setTextSize(50);
        paint.setColor(Color.BLUE);
        //绘制文字
        canvas.drawText("极客学院", 0, 100, paint);
        //绘制几何图形
        canvas.drawCircle(50, 150, 50, paint);
        //绘制图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, 0, 200, paint);
    }

}
