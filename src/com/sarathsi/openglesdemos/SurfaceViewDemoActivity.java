package com.sarathsi.openglesdemos;

import android.app.Activity;
import android.os.Bundle;

public class SurfaceViewDemoActivity extends Activity {

	MySurfaceView mSurfaceView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mSurfaceView = new MySurfaceView(this);
		setContentView(mSurfaceView);

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
