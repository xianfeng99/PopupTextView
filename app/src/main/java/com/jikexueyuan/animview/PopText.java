package com.jikexueyuan.animview;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Created by lixianfeng on 16/2/17.
 */
public class PopText {

    private Random random = new Random();
    private Paint paint = new Paint();

    private String text;
    private int x;
    private int y;
    private int speed;
    private int boundWidth = 500;

    public PopText(){
        init();
    }

    public PopText(int y, int boundWidth){
        this.y = y;
        this.boundWidth = boundWidth;
        init();
    }

    public void draw(Canvas canvas){
        canvas.drawText(text, x, y, paint);
    }

    public void move(){
        x -= speed;
        if(x < -paint.measureText(text)){//可以改进为文字出屏幕paint.measureText(text)
            init();
        }
    }

    private void init(){

        x = boundWidth;
//        y = 50;
        speed = 3 + random.nextInt(15);
        //获取随即评论
        int len = 2 + random.nextInt(10);
        text = "";
        for(int i  = 0; i < len; i ++){
            text += getGB2312Str();
        }

        //获取随机颜色
        int a = 128 + random.nextInt(128);
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        paint.setARGB(a, r, g, b);
        paint.setTextSize(50);
    }

    private String getGB2312Str() {
        // 国标一级字(共3755个): 区:16-55, 位:01-94, 55区最后5位为空位
        int 区 = random.nextInt(40) + 16;
        int 位 = random.nextInt(区 == 55 ? 89 : 94) + 1;
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (区 + 0xa0);
        bytes[1] = (byte) (位 + 0xa0);
        try {
            return new String(bytes, "gb2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
