package com.sarathsi.openglesdemos.uituils;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.View;

public class ViewWithCanvasPaint extends View {

	// TODO - add missing .png resources
    Paint mPaint;
    Context mContext;
    Bitmap mBitmap565;
    Bitmap mBitmap4444;
    
    public ViewWithCanvasPaint(Context context) {
        super(context);
        mContext = context;
        mPaint = new Paint();
    }

    protected void onDraw(Canvas canvas) {
    	//drawBasicShapes(canvas);
    	drawBitmap_1(canvas);
    	
    	invalidate();
    }
    

    private void drawBasicShapes(Canvas canvas) {
        // canvas.drawRGB(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        canvas.drawRGB(100, 210, 220);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Style.FILL);
        canvas.drawPoint(10,10, mPaint);
    	canvas.drawCircle(200, 300, 200, mPaint);

    	mPaint.setStyle(Style.FILL_AND_STROKE);
    	mPaint.setColor(0xaa0000ff);
    	canvas.drawRect(600, 100, 1000, 400, mPaint);
    }
    
    private void drawBitmap_1(Canvas canvas) {
    	InputStream inputStream = null;
    	try {
            AssetManager assetManager = mContext.getAssets();
            
            inputStream = assetManager.open("pic2.png");
            mBitmap565 = BitmapFactory.decodeStream(inputStream);
            inputStream.close(); // IMPORTANT
            Log.d("BitmapText", "bobrgb888.png format: " + mBitmap565.getConfig());

            //inputStream = assetManager.open("bobargb8888.png");
            inputStream = assetManager.open("background.png");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_4444;
            mBitmap4444 = BitmapFactory.decodeStream(inputStream, null, options);
            
            inputStream.close(); 
            Log.d("BitmapText", "bobargb8888.png format: " + mBitmap4444.getConfig());

        } catch (IOException e) {
        	Log.d("MyView1", e.toString());
            // TODO
        } finally {
        	//inputStream.close();
            // close our input streams
        }
    	
    	Rect dst = new Rect();
        
    	dst.set(0, 0, canvas.getWidth(), canvas.getHeight());
        canvas.drawBitmap(mBitmap4444, null, dst, null);
        
        dst.set(50, 50, 250, 250);
        canvas.drawBitmap(mBitmap565, null, dst, null);
    }
    
}
