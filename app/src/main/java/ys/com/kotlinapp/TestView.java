package ys.com.kotlinapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Yuval Shabtai on 6/16/2017.
 */
public class TestView extends View {

    private Paint ballPaint;

    public TestView(Context context) {
        super(context);
        init();
    }
    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public TestView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        ballPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        ballPaint.setColor(Color.RED);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(0, 0, getWidth(), getHeight(), ballPaint);
    }
}
