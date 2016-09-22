package com.quicksand.roundimagedrawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016/9/22 0022.
 */

public class CircleImageDrawable extends Drawable {
    private Paint mPaint;
    private int mWidth;
    private Bitmap mBitmap;
    public CircleImageDrawable(Bitmap bitmap) {
        this.mBitmap = bitmap;
        mPaint = new Paint();
        //添加抗锯齿
        mPaint.setAntiAlias(true);
        //添加位图渲染器
        BitmapShader shader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        //比较图片的宽高作为圆形的直径
        mWidth = Math.min(mBitmap.getWidth(),mBitmap.getHeight());
    }

    @Override
    public int getIntrinsicWidth() {
        return mWidth;
    }

    @Override
    public int getIntrinsicHeight() {
        return mWidth;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(mWidth/2,mWidth/2,mWidth/2,mPaint);
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
