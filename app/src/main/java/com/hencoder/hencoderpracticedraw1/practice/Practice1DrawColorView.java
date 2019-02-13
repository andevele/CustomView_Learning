package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice1DrawColorView extends View {

    private  Bitmap bitmap;
    private  Paint paint;
    private  Rect rect;

    public Practice1DrawColorView(Context context) {
        super(context);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        //rect = new Rect(200,50,400,250);
        //rect = new Rect();
        paint = new Paint();
        paint.setAntiAlias(true);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.toutiao);
        Log.d("zhulf","width: " + bitmap.getWidth() + " height: " + bitmap.getHeight());
        rect = new Rect(200,100,200 + bitmap.getWidth(),100 + bitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //三种方法画颜色
        //canvas.drawColor(Color.parseColor("#80ffaacc"));
        //canvas.drawColor(Color.YELLOW);
        //canvas.drawARGB(125,30,10,120);


        //canvas.drawBitmap(bitmap,null,rect,paint);
        canvas.drawBitmap(bitmap,200,100,paint);
        canvas.drawColor(Color.parseColor("#80228B22"));
        //canvas.drawBitmap(bitmap,200,100,paint);
    }
}
