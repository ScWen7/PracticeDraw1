package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.RectBean;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {


    public static final int MAX_HEIGHT = 380;
    public static final int MARGIN = 10;
    public static final int RECT_WIDTH = 50;

    private List<RectBean> mRectBeanList;
    private Paint mLinePaint;
    private Paint mTextPaint;
    private Paint mRectPaint;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mRectBeanList = new ArrayList<>();

        mRectBeanList.add(new RectBean("Froyo", 10));
        mRectBeanList.add(new RectBean("GB", 20));
        mRectBeanList.add(new RectBean("ICS", 40));
        mRectBeanList.add(new RectBean("JB", 60));
        mRectBeanList.add(new RectBean("KitKat", 70));
        mRectBeanList.add(new RectBean("L", 90));
        mRectBeanList.add(new RectBean("M", 30));

        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setColor(Color.WHITE);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(15);

        mRectPaint = new Paint();
        mRectPaint.setAntiAlias(true);
        mRectPaint.setColor(Color.GREEN);

    }


    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制整个背景
        canvas.drawColor(Color.parseColor("#506e7a"));
        canvas.translate(100, 400);
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        //1、绘制纵向坐标线

        canvas.drawLine(0, 0, 0, -MAX_HEIGHT, mLinePaint);
        //2、绘制横向坐标线
        canvas.drawLine(0, 0, 600, 0, mLinePaint);
        //3、绘制直方图步骤

        //3、1 绘制下方文字

        for (int i = 0; i < mRectBeanList.size(); i++) {
            RectBean rectBean = mRectBeanList.get(i);
            Rect textRect = new Rect();
            String str = rectBean.getStr();
            mTextPaint.getTextBounds(str, 0, str.length(), textRect);

            float textWidth = textRect.width();
            float textHeight = textRect.height();

            float textX = MARGIN * (i + 1) + RECT_WIDTH / 2 + RECT_WIDTH * i - textWidth / 2;
            float textY = textHeight + 2;

            canvas.drawText(str, textX, textY, mTextPaint);

            //3、2 绘制 方形图
            RectF rectF = new RectF(MARGIN * (i + 1) + RECT_WIDTH * i, -MAX_HEIGHT * rectBean.getPercent()/100f, (RECT_WIDTH + MARGIN) * (i + 1), 0);
            canvas.drawRect(rectF, mRectPaint);
        }


    }
}
