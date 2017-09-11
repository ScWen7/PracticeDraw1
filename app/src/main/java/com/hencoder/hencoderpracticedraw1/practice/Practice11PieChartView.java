package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        float centrX = getWidth() / 2;
        float centrY = getHeight() / 2;
        //移动到 画布中心
        canvas.translate(centrX, centrY);

        //绘制黄色部分 饼状

        canvas.save();

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.YELLOW);
        canvas.translate(2, -2);

        RectF rectF = new RectF(-200, -200, 200, 200);

        canvas.drawArc(rectF, -63, 60, true, paint);
        //返回中心点画布状态
        canvas.restore();
        canvas.save();
        canvas.translate(3, 0);
        paint.setColor(Color.MAGENTA);
        canvas.drawArc(rectF, 0, 15, true, paint);

        canvas.restore();
        canvas.save();
        canvas.translate(3, 3);
        paint.setColor(Color.GRAY);
        canvas.drawArc(rectF, 18, 10, true, paint);

        canvas.restore();
        canvas.save();
        canvas.translate(2, 2);
        paint.setColor(Color.GREEN);
        canvas.drawArc(rectF, 32, 50, true, paint);

        canvas.restore();
        canvas.save();
        canvas.translate(0, 2);
        paint.setColor(Color.BLUE);
        canvas.drawArc(rectF, 85, 85, true, paint);


        canvas.restore();
        canvas.translate(-5, -5);
        paint.setColor(Color.RED);
        canvas.drawArc(rectF, 173, 125, true, paint);


    }
}
