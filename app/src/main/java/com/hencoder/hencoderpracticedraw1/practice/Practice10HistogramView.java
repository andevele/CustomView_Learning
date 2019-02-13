package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice10HistogramView extends View {

    private Paint paint;
    private Rect froyoRect;
    private int x;
    private int width;
    private int interval;
    private int temp;
    private static final int DIAGRAM = 7;
    private String[] labelArray;
    private Paint paint2;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        paint.setStyle(Paint.Style.FILL);//填充
        paint.setColor(Color.parseColor("#72B916"));
        paint2 = new Paint();
        paint2.setAntiAlias(true);//抗锯齿
        paint2.setStyle(Paint.Style.FILL);//填充
        paint2.setColor(Color.parseColor("#ffffff"));
        /**
         * 柱状之间的距离
         */
        interval = 30;

        /**
         * 图形坐标x
         */
        x = 100;
        /**
         * 每个柱状的宽度
         */
        width = 100;

        froyoRect = new Rect();
        labelArray = new String[]{"Froyo","GB","ICS","JB","KitKat","L","M"};


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        //canvas.drawRect(froyoRect,paint);
        for(int i = 0;i < DIAGRAM;i++) {
            int left = 0;
/*            if(i == 0) {
                int left = x;
                int top = getTopDistance();
                int right = left + width;
                int bottom = 600;
                froyoRect.set(left,top,right,bottom);
                canvas.drawRect(froyoRect,paint);
                temp = right + interval;
            } else {
                int left = temp;
                int top = getTopDistance();
                Log.d("zhulf","====top==" + top);
                int right = left + width;
                int bottom = 600;
                froyoRect.set(left,top,right,bottom);
                canvas.drawRect(froyoRect,paint);
                temp = right + interval;
            }*/
            /**
             * 如果是第一个柱状图形，左点的left为x+interval
             * 如果不是第一个柱状图形，左点的left就等于柱状图形的right+interval
             */
            if(i == 0) {
                left = x + interval;
            } else {
                left = temp;
            }
            int top = getTopDistance();
            Log.d("zhulf","====top==" + top);
            int right = left + width;
            int bottom = 600;
            froyoRect.set(left,top,right,bottom);
            canvas.drawRect(froyoRect,paint);
            temp = right + interval;


            paint2.setTextSize(26);
            paint2.setStrokeWidth(5);
            //int textWidth = (int)getTextWidth(labelArray[i]);
            /**
             * 获取字符串的宽度
             */
            int textWidth = (int)paint2.measureText(labelArray[i]);
            /**
             * 画字体的坐标在左下角deadline处,x为柱状的宽度的一半减去字符串宽度的一半，然后
             * 加上left；y等于柱状的竖直距离+某个值比如此处设为30
             */
            canvas.drawText(labelArray[i],(left + (width / 2)) - (textWidth / 2),600 + 30,paint2);
        }

        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        canvas.drawLine(x,50,x,600,paint);
        canvas.drawLine(100,600, (DIAGRAM + 1) * (width + interval),600,paint);

    }

    private int getTopDistance() {
        double top = 600 - Math.random() * 400;
        //Log.d("zhulf","======top===" + top);
        return (int)top;
    }

    /**
     * 根据文本的
     * @param text
     * @param textSize
     * @return
     */
    public float getTextWidth(String text) {
        TextPaint textPaint = new TextPaint();
        Rect bounds = new Rect();
        textPaint.getTextBounds(text,0,text.length(),bounds);
        return bounds.width();
    }

}
