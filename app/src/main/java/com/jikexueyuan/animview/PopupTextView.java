package com.jikexueyuan.animview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;

import java.util.ArrayList;

/**
 * Created by lixianfeng on 16/2/16.
 */
public class PopupTextView extends BaseView {

//    private PopText popText;
    private ArrayList<PopText> elements = new ArrayList<>();
    private int size;


    public PopupTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PopupTextView);

        size = ta.getInteger(R.styleable.PopupTextView_txtNumber, 8);

        ta.recycle();
    }

    public PopupTextView(Context context) {
        super(context);

    }

    @Override
    protected void init() {
//        popText = new PopText();

        int itemHeight = getHeight() / size;
        for(int i = 0; i < size; i ++){
            elements.add(new PopText((
                    i + 1) * itemHeight, getWidth()));
        }
    }

    @Override
    protected void drawSub(Canvas canvas) {
//        popText.draw(canvas);

        for(PopText pop : elements){
            pop.draw(canvas);
        }
    }

    @Override
    protected void logic() {
//        popText.move();

        for(PopText pop : elements){
            pop.move();
        }
    }
}
