package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice3DrawRectView extends View {

    private Paint paint;

    public Practice3DrawRectView(Context context) {
        super(context);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        练习内容：使用 canvas.drawRect() 方法画矩形
        canvas.drawRect(200,200,500,500, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6);
        //canvas.drawRect(600,200,900,500, paint);
        paint.setARGB(125,100,90,120);
        canvas.drawRect(new Rect(600,200,900,500),paint);
    }
}
