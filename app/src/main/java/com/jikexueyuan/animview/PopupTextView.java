package com.jikexueyuan.animview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/**
 * Created by lixianfeng on 16/2/16.
 */
public class PopupTextView extends BaseView {

    private PopText popText;

    public PopupTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PopupTextView(Context context) {
        super(context);

    }

    @Override
    protected void init() {
        popText = new PopText();
    }

    @Override
    protected void drawSub(Canvas canvas) {
        popText.draw(canvas);
    }

    @Override
    protected void logic() {
        popText.move();
    }
}
