package com.quicksand.roundimagedrawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016/9/22 0022.
 */

public class RoundImageDrawable extends Drawable {
    private Bitmap mBitmap;
    private Paint mPaint;
    private RectF rectF;
    private int round = 30;

    public RoundImageDrawable(Bitmap bitmap) {
        this.mBitmap = bitmap;
        mPaint = new Paint();
        //添加抗锯齿
        mPaint.setAntiAlias(true);
        //添加位图渲染器
        BitmapShader shader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(rectF,round,round,mPaint);
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        rectF = new RectF(left,top,right,bottom);
    }

    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }

    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }

    @Override
    public void setAlpha(int i) {
        mPaint.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
