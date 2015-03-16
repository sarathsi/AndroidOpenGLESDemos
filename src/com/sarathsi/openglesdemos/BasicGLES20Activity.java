package com.sarathsi.openglesdemos;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class BasicGLES20Activity extends Activity {

    private GLSurfaceView mGLSurfaceView;
    private MySurfaceView mSurfaceView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mGLSurfaceView = new MyGLSurfaceView(this);
        
        mSurfaceView = new MySurfaceView(this);
        
        setContentView(mSurfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // pauses the rendering thread. 
        // can de-allocate graphics objects if needed.
        mGLSurfaceView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // resumes a paused rendering thread.
        // re-allocate graphic objects if deleted in pause
        mGLSurfaceView.onResume();
    }
}