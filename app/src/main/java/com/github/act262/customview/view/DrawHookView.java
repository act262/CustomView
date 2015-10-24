package com.github.act262.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author act262@gmail.com
 * @version 1.0
 * @time 2015/10/24
 */
public class DrawHookView extends View {
    public DrawHookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawHookView(Context context) {
        super(context);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DrawHookView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public DrawHookView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private Paint pPaint; // progress paint
    private Paint hPaint; // hook view paint

    private void init() {
        pPaint = new Paint();
        pPaint.setColor(Color.BLUE);
        pPaint.setStrokeWidth(5.0f);
        pPaint.setStyle(Paint.Style.STROKE);
        pPaint.setAntiAlias(true);

        hPaint = new Paint();
        hPaint.setColor(Color.BLACK);
        hPaint.setDither(true);
        hPaint.setAntiAlias(true);
        hPaint.setStyle(Paint.Style.STROKE);
    }

    private int progress = 0;
    private int line1_x = 0;      //线1的x轴
    private int line1_y = 0;     //线1的y轴
    private int line2_x = 0;     //线2的x轴
    private int line2_y = 0;     //线2的y轴

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        progress++;
        //获取圆心的x坐标
        int center = getWidth() / 2;
        int center1 = center - getWidth() / 5;
        //圆弧半径
        int radius = getWidth() / 2 - 5;
        //定义的圆弧的形状和大小的界限
        RectF rectF = new RectF(center - radius - 1, center - radius - 1, center + radius + 1, center + radius + 1);
        //canvas.drawRect(rectF, hPaint);
        canvas.drawRoundRect(rectF, 10, 10, hPaint);
        //canvas.drawArc(0, 0, getHeight(), getHeight(), 0, 180, false, hPaint);
        //canvas.drawCircle(center, center, radius, hPaint);

        //根据进度画圆弧
        canvas.drawArc(rectF, 180, -360 * progress / 100, false, pPaint);

        //先等圆弧画完，才话对勾
        if (progress >= 100) {
            if (line1_x < radius / 3) {
                line1_x++;
                line1_y++;
            }
            //画第一根线
            canvas.drawLine(center1, center, center1 + line1_x, center + line1_y, pPaint);
            if (line1_x == radius / 3) {
                line2_x = line1_x;
                line2_y = line1_y;
                line1_x++;
                line1_y++;
            }
            if (line1_x >= radius / 3 && line2_x <= radius) {
                line2_x++;
                line2_y--;
            }
            //画第二根线
            canvas.drawLine(center1 + line1_x - 1, center + line1_y, center1 + line2_x, center + line2_y, pPaint);
        }
        //每隔10毫秒界面刷新
        postInvalidateDelayed(10);
    }
}
