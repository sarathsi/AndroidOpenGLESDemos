package com.sarathsi.openglesdemos;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;

public class MyGLRenderer  implements GLSurfaceView.Renderer {

	private static final String TAG = "MyGLRenderer";

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		Log.i(TAG, "onSurfaceCreated()");
        // specify clear values for the color buffers (background frame color)
        GLES20.glClearColor(0.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		Log.i(TAG, "onSurfaceChanged() " + width + "x" + height);
		GLES20.glViewport(100, 100, width, height);
		
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		Log.i(TAG, "onDrawFrame()");
        // Redraw background color (clear buffers to preset values)
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        //(GL_COLOR_BUFFER_BIT, GL_DEPTH_BUFFER_BIT, GL_ACCUM_BUFFER_BIT, and GL_STENCIL_BUFFER_BIT)

	}

}
