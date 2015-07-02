package com.sarathsi.openglesdemos;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.WindowManager;

public class BasicGLES20Activity extends Activity {

    private GLSurfaceView mGLSurfaceView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        mGLSurfaceView = new MyGLSurfaceView(this);
        setContentView(mGLSurfaceView);
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