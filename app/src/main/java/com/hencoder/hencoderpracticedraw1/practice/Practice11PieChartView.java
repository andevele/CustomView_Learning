package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice11PieChartView extends View {

    private Paint piePaint;
    private Path lollipopPath;
    private Paint textPaint;
    private Path marshmallowPath;
    private Paint linePaint;
    private Path kitKatPath;
    private Path jellyBeanPath;
    private Path iceCreamSandwichPath;
    private Path ginerbreadPath;
    private Path froyoPath;
    private int left1 = 140;
    private int top1 = 50;
    private int right1 = 720;
    private int bottom1 = 630;

    private int left2 = 160;
    private int top2 = 70;
    private int right2 = 740;
    private int bottom2 = 650;
    private int r1;
    private int r2;

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initParms();
        initPie();
        initLine();
        initText();
        initPath();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 两个圆的圆心
     */
    private void initParms() {
        r1 = (right1 - left1) / 2;
        r2 = (right2 - left2) / 2;
    }

    private void initPie() {
        piePaint = new Paint();
        piePaint.setAntiAlias(true);//抗锯齿
        piePaint.setStyle(Paint.Style.FILL);//填充
    }

    private void initLine() {
        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setStyle(Paint.Style.FILL);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(Color.parseColor("#B7B8B8"));
        linePaint.setStrokeWidth(4);

    }

    private void initText() {
        textPaint = new Paint();
        textPaint.setAntiAlias(true);//抗锯齿
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setTextSize(26);
        textPaint.setColor(Color.WHITE);
    }

    private void initPath(){
        lollipopPath = new Path();
        marshmallowPath = new Path();
        kitKatPath = new Path();
        jellyBeanPath = new Path();
        iceCreamSandwichPath = new Path();
        ginerbreadPath = new Path();
        froyoPath  = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        drawLollipop(canvas);
        drawMarshmallow(canvas);
        drawKitkat(canvas);
        drawJellyBean(canvas);
        drawIceCreamSandwich(canvas);
        drawGingerbread(canvas);
        drawFroyo(canvas);
    }
    private void drawLollipop(Canvas canvas){
        int x1 = (int) (left1 + r1 - r1 * Math.cos(130 / 2 * Math.PI / 180));
        int y1 = (int) (top1 + r1 - r1 * Math.sin(130 / 2 * Math.PI / 180));

        piePaint.setColor(Color.parseColor("#F44336"));
        canvas.drawArc(left1,top1,right1,bottom1,-50,-130,true, piePaint);

        lollipopPath.moveTo(x1, y1);
        lollipopPath.lineTo(x1 - 20,y1 - 20);
        lollipopPath.rLineTo(-150,0);
        canvas.drawPath(lollipopPath, linePaint);

        canvas.drawText("Lollipop",x1 - 280,y1 - 20, textPaint);

    }

    private void drawMarshmallow(Canvas canvas) {
        int x = (int) (r2 + left2 + r2 * Math.cos(50 / 2 * Math.PI / 180));
        int y = (int)(top2 + r2 - r2 * Math.sin(50 / 2 * Math.PI / 180));

        initPie();
        piePaint.setColor(Color.parseColor("#FFC107"));
        canvas.drawArc(left2, top2, right2, bottom2,0,-50,true, piePaint);

        marshmallowPath.moveTo(x,y);
        marshmallowPath.lineTo(x + 20,y - 20);
        marshmallowPath.rLineTo(80,0);
        canvas.drawPath(marshmallowPath,linePaint);

        canvas.drawText("Marshmallow",x + 120,y - 15, textPaint);
    }

    private void drawKitkat(Canvas canvas) {
        int x = (int) (left2 + (r2 - r2 * Math.cos(52.5 * Math.PI / 180)));
        int y = (int) (top2 + r2 + r2 * Math.sin(52.5 * Math.PI / 180));

        initPie();
        piePaint.setColor(Color.parseColor("#2196F3"));
        canvas.drawArc(left2, top2, right2, bottom2,-180,-105,true,piePaint);

        kitKatPath.moveTo(x,y);
        kitKatPath.lineTo(x - 20,y + 20);
        kitKatPath.rLineTo(-150,0);
        canvas.drawPath(kitKatPath,linePaint);

        canvas.drawText("KitKat",x - 260,y + 20,textPaint);
    }

    private void drawJellyBean(Canvas canvas) {
        int x = (int) (left2 + r2 + r2 * Math.cos(45 * Math.PI / 180));
        int y = (int) (top2 + r2 + r2 * Math.sin(45 * Math.PI / 180));

        initPie();
        piePaint.setColor(Color.parseColor("#009688"));
        canvas.drawArc(left2, top2, right2, bottom2,-287,-56,true,piePaint);

        jellyBeanPath.moveTo(x,y);
        jellyBeanPath.lineTo(x + 20,y + 20);
        jellyBeanPath.rLineTo(80,0);
        canvas.drawPath(jellyBeanPath,linePaint);

        canvas.drawText("Jelly Bean",x + 120,y + 20,textPaint);
    }

    private void drawIceCreamSandwich(Canvas canvas) {
        int x = (int) (left2 + r2 + r2 * Math.cos(13 * Math.PI / 180));
        int y = (int) (top2 + r2 + r2 * Math.sin(13 * Math.PI / 180));

        initPie();
        piePaint.setColor(Color.parseColor("#9E9E9E"));
        canvas.drawArc(left2, top2, right2, bottom2,-345,-4,true,piePaint);

        iceCreamSandwichPath.moveTo(x,y);
        iceCreamSandwichPath.rLineTo(30,0);
        //iceCreamSandwichPath.lineTo(x + 20,y + 20);
        iceCreamSandwichPath.rLineTo(20,30);
        iceCreamSandwichPath.rLineTo(30,0);
        canvas.drawPath(iceCreamSandwichPath,linePaint);

        canvas.drawText("Ice Cream Sandwich",x + 90,y + 30,textPaint);
    }

    private void drawGingerbread(Canvas canvas) {
        int x = (int) (left2 + r2 + r2 * Math.cos((11 / 2) * Math.PI / 180));
        int y = (int) (top2 + r2 + r2 * Math.sin((11 / 2) * Math.PI / 180));

        initPie();
        piePaint.setColor(Color.parseColor("#9C27B0"));
        canvas.drawArc(left2, top2, right2, bottom2,-351,-7,true,piePaint);

        ginerbreadPath.moveTo(x,y);
        ginerbreadPath.rLineTo(30,0);
        //iceCreamSandwichPath.lineTo(x + 20,y + 20);
        ginerbreadPath.rLineTo(20,20);
        ginerbreadPath.rLineTo(30,0);
        canvas.drawPath(ginerbreadPath,linePaint);

        canvas.drawText("Gingerbread",x + 90,y + 30,textPaint);
    }

    private void drawFroyo(Canvas canvas) {
        int x = left2 + 2 * r2;
        int y = top2 + r2 + 4;

        froyoPath.moveTo(x,y);
        froyoPath.rLineTo(80,0);
        canvas.drawPath(froyoPath,linePaint);

        canvas.drawText("Froyo",x + 90,y + 0,textPaint);
    }
}
