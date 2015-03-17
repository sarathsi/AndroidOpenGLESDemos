/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sarathsi.openglesdemos;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;

/**
 * A view container where OpenGL ES graphics can be drawn on screen.
 * This view can also be used to capture touch events, such as a user
 * interacting with drawn objects.
 */
public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer
        mRenderer = new MyGLRenderer();
        setRenderer(mRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        // Others: RENDERMODE_CONTINUOUSLY
        
        
    }

    
    public class MyGLRenderer implements GLSurfaceView.Renderer {
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

}
