package com.github.act262.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author act262@gmail.com
 * @version 1.0
 * @time 2015/10/24
 */
public class GridsView extends View {
    public GridsView(Context context) {
        super(context);
        init();
    }

    public GridsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GridsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GridsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private Paint mPaint = null;
    private int distance = 10; // 每个格子之间的间隔 10px

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.DKGRAY);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        canvas.drawRect(0, 0, width, height, mPaint);//画整个View的外边框

        int row = height / distance;
        int columns = width / distance;

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(2);
        for (int i = 0; i < row; i++) {
            canvas.drawLine(1, i * distance, width - 1, i * distance, mPaint); // 画横线
        }

        for (int i = 0; i < columns; i++) {
            canvas.drawLine(i * distance, 1, i * distance, height - 1, mPaint); // 画竖线
        }
    }

}
