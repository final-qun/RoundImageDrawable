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

public class HexagonImageDrawable extends Drawable {
    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 1;
    private Paint mPaint;
    private Bitmap mBitmap;
    private int mRadio;
    private int mWidth;
    private int mHeight;
    private int mOrientation;

    public HexagonImageDrawable(Bitmap bitmap,int orientation){
        this.mBitmap = bitmap;
        this.mOrientation = orientation;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        BitmapShader shader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        if(mOrientation == VERTICAL) {
            int minWidth = (int)Math.cos(30)*height;
            if (width > minWidth) {
                mRadio = mHeight = height;
            } else {
                mWidth = (int) (width / Math.cos(30));
            }
        } else if(mOrientation == HORIZONTAL){
            int minHeight = (int)Math.cos(30)*width;
            if (height > minHeight) {
                mRadio = mWidth = width;
            } else {
                mHeight = (int) (height / Math.cos(30));
            }
        }
    }
    @Override
    public void draw(Canvas canvas) {
        if(mOrientation == VERTICAL) {

        } else if(mOrientation == HORIZONTAL) {

        }
        for (int i = 1;i < 7;i++) {
            int startWidth = mWidth / 2;
            int startHeight = 0;
            int endWidth = startWidth + (int)(mRadio * Math.sin(60*i));
            int endHeight = startHeight +(mRadio - (int)(mRadio * Math.cos(60*i)));

            canvas.drawLine(startWidth,startHeight,endWidth,endHeight,mPaint);
        }
    }

    @Override
    public int getIntrinsicWidth() {
        if(mOrientation == VERTICAL) {
            return (int)(Math.cos(30)*mRadio);
        } else {
            return mRadio;
        }
    }

    @Override
    public int getIntrinsicHeight() {
        if(mOrientation == VERTICAL) {
            return mRadio;
        } else {
            return (int) (mRadio / Math.cos(30));
        }
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
