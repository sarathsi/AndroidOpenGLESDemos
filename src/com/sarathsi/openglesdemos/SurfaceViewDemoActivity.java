package com.sarathsi.openglesdemos;

import com.sarathsi.openglesdemos.uituils.ViewWithCanvasPaint;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class SurfaceViewDemoActivity extends Activity {

	MySurfaceView mSurfaceView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mSurfaceView = new MySurfaceView(this);
		setContentView(mSurfaceView);

		//View myView = new ViewWithCanvasPaint(this);
		//setContentView(myView);

	}

	protected void onResume() {
		super.onResume();
		mSurfaceView.resume();
	}

	protected void onPause() {
		super.onPause();
		mSurfaceView.pause();
	}

}
