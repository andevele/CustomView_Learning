package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint paint;

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        paint.setStyle(Paint.Style.FILL);//填充
        paint.setColor(Color.parseColor("#000000"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        /**
         * startAngle 起始角度，x轴的正向是0度位置，如果为正数，顺时针为正角度，和正向0度有个顺时针的夹角；逆时针为负角度和正向0度有个逆时针夹角
         * sweepAngle 旋转角度，如果为正数，就是顺时针旋转某个角度；如果为负数，就是逆时针旋转某个角度
         * useCenter  是否连接圆心，如果true，连接圆心，所画图为扇形；如果为false，不连接圆心，所画图为圆弧
         */
        canvas.drawArc(50,50,400,450,-180,-90,true,paint);
        //canvas.drawArc(450,50,800,450,0,-90,true,paint);

        //canvas.drawArc(50,50,400,450,45,90,true,paint);
        canvas.drawArc(450,50,800,450,-180,90,true,paint);

    }
}
