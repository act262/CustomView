package com.github.act262.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * @author act262@gmail.com
 * @version 1.0
 * @time 2015/10/24
 */
public class RulesView extends View {
    public RulesView(Context context) {
        super(context);
        init();
    }

    public RulesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RulesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RulesView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private Paint mPaint = null;
    private Paint tagPaint = null;
    private Paint textPaint = null;

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);

        textPaint = new Paint();
        textPaint.setColor(Color.LTGRAY);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(30);

        tagPaint = new Paint();
        tagPaint.setColor(Color.BLUE);
        tagPaint.setAntiAlias(true);
        tagPaint.setTextSize(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        //draw 100px unit
        int row = height / unit_100px;
        int columns = width / unit_100px;
        float unit = unit_100px;

        canvas.translate(0, 80); //画板向下移动
        canvas.drawText("100px", 0, 10, textPaint);
        canvas.translate(0, textPaint.getTextSize());
        canvas.drawLine(0, 0, width, 1, mPaint); //横线基准线
        for (int i = 0; i < columns; i++) {
            canvas.drawLine(i * unit, 0, i * unit, 50, mPaint);
            canvas.drawText(String.valueOf(i), i * unit + 1, 10, tagPaint);
        }

        //draw 10dp unit
        columns = width / unit_10dp;
        canvas.translate(0, 80); //画板向下移动
        canvas.drawText("10dp", 0, 10, textPaint);
        canvas.translate(0, textPaint.getTextSize());
        canvas.drawLine(0, 0, width, 1, mPaint); //横线基准线
        unit = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, unit_10dp, getResources().getDisplayMetrics());
        for (int i = 0; i < columns; i++) {
            canvas.drawLine(i * unit, 0, i * unit, 50, mPaint);
            canvas.drawText(String.valueOf(i), i * unit + 1, 10, tagPaint);
        }

        // draw 10mm unit
        columns = width / 10;
        canvas.translate(0, 80); //画板向下移动
        canvas.drawText("10mm", 0, 10, textPaint);
        canvas.translate(0, textPaint.getTextSize());
        canvas.drawLine(0, 0, width, 1, mPaint); //横线基准线
        unit = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_MM, unit_10mm, getResources().getDisplayMetrics());
        for (int i = 0; i < columns; i++) {
            canvas.drawLine(i * unit, 0, i * unit, 50, mPaint);
            canvas.drawText(String.valueOf(i), i * unit + 1, 10, tagPaint);
        }
    }

    private int unit_100px = 100;
    private int unit_10dp = 10;
    private int unit_10mm = 10;
}
