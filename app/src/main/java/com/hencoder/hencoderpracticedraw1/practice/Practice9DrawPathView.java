package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Paint paint;
    private Path path1;
    private Path path2;
    private Path path3;
    private Path path4;
    private Path path5;
    private Path path6;
    private Path path7;

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        paint.setStyle(Paint.Style.FILL);//填充
        paint.setColor(Color.parseColor("#000000"));

        path1 = new Path();
        path1.addCircle(100,100,50,Path.Direction.CW);

        path2 = new Path();
        /**
         * lineTo:从上一个点到指定点画一条直线，默认起始点在原点(0,0)
         * rLineTo: 相对上一个点所移动的位置画一条直线
         */
        path2.lineTo(400,0);
        path2.lineTo(400,200);
        path2.lineTo(500,200);
        /**
         * x方向相对位置为0表示和上一个点的x坐标一样
         * y方向相对上一次的y坐标像正方形移动200个单位
         */
        path2.rLineTo(0,50);

        path3 = new Path();
        path4 = new Path();
        path5 = new Path();
        path6 = new Path();
        path7 = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        canvas.drawPath(path1,paint);

        /**
         * 注意：如果画笔模式设为fill填充的话，那么直线的首位会相连接成为一个填充图形
         */
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawPath(path2,paint);


        /**
         * 二次贝塞尔曲线,默认起始点在原点，否则上一个点作为起始点，也就上上一次画完曲线后的终点为起始点
         * moveto可以改变上一个点的位置
         * quadTo的前2个参数表示控制点，后2个参数表示曲线终点
         * rQuadTo表示相对位置画曲线
         */
        path3.moveTo(200,300);
        path3.quadTo(250,450,600,500);
        canvas.drawPath(path3,paint);

        /**
         * 三次贝塞尔曲线,默认起始点在原点，否则上一个点作为起始点，也就上上一次画完曲线后的终点为起始点
         * moveto可以改变上一个点的位置
         * cubic的前2个参数表示第一个控制点，随后的两个参数表示第二个控制点，第三个表示曲线终点
         * rCubicTo表示相对位置画曲线
         */
        path4.moveTo(250,300);
        path4.cubicTo(400,400,650,100,500,400);
        canvas.drawPath(path4,paint);

        /**
         * arcTo专门用来画弧形，forceMoveTo为true时，跳过画笔移动痕迹，直接移动到弧的起点
         * 当forceMoveTo为false时，不跳过痕迹，从上一个点画痕迹连接到弧的起始点
         * addArc是arcTo的一个简化版，默认forceMoveTo为true，不画痕迹
         * 这种方式可以在每次抬笔时标志着一个字图形的结束，以及一个新的图形开始。
         */
        path5.moveTo(500,100);
        path5.lineTo(600,200);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        path5.arcTo(600,150,1000,600,-90,90,false);
        //path5.addArc(600,150,1000,600,0,-90);
        canvas.drawPath(path5,paint);


//        paint.setColor(Color.RED);
//        path6.moveTo(600,100);
//        path6.lineTo(800,300);
//        path6.lineTo(500,500);
//        //path6.lineTo(600,100);
//        path6.close();//close()封闭子图形，相当于lineTo(600,100),封闭图形还有另外一种方法采用填充
//        canvas.drawPath(path6,paint);
//
//        paint.setColor(Color.parseColor("#bb0000"));
//        paint.setStyle(Paint.Style.FILL);
//        path7.moveTo(200,500);
//        path7.lineTo(100,600);
//        path7.lineTo(300,600);
//        canvas.drawPath(path7,paint);
//
//        paint.setTextSize(50);
//        canvas.drawText("找到学习方法",600,500,paint);

    }
}
