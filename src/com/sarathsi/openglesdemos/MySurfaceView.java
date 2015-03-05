package com.sarathsi.openglesdemos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements Runnable {

    Thread mRenderThread = null;
    SurfaceHolder mSurfaceHolder;
    volatile boolean mIsRunning = false; // IMPORTANT
    Paint mPaint;
    
    public MySurfaceView(Context context) {
        super(context);           
        mSurfaceHolder = getHolder();
        mPaint = new Paint();
    }

    public void resume() {          
    	mIsRunning = true;
        mRenderThread = new Thread(this);
        mRenderThread.start();
    }
    
    public void pause() {        
    	mIsRunning = false;
        while(true) {
            try {
            	// Blocks the current Thread (Thread.currentThread())
            	// until the receiver finishes its execution and dies.
                mRenderThread.join();
                break;
            } catch (InterruptedException e) {
                // retry
            }
        }
        mRenderThread = null;
    }
    
    public void run() {
        while(mIsRunning) {  
            if(!mSurfaceHolder.getSurface().isValid())
                continue;
            
            Canvas canvas = mSurfaceHolder.lockCanvas();
            
            drawSurface1(canvas);
            
            mSurfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
    
    private void drawSurface1(Canvas canvas) {
       
        canvas.drawRGB(150, 200, 255);            
        mPaint.setColor(Color.RED);
        canvas.drawLine(0, 0, canvas.getWidth()-1, canvas.getHeight()-1, mPaint);
        
        mPaint.setStyle(Style.STROKE);
        mPaint.setColor(0xff00ff00);            
        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, 200, mPaint);
                    
        mPaint.setStyle(Style.FILL);
        mPaint.setColor(0x770000ff);
        canvas.drawRect(100, 100, 200, 200, mPaint);
    }
    
    
}

	
