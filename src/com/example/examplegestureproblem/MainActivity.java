package com.example.examplegestureproblem;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class MainActivity extends ActionBarActivity {

	private GestureDetector mDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDetector = new GestureDetector(this, new MyGestureListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		this.mDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
		private static final String DEBUG_TAG = "Gestures!!!!!!!!!!!!!!";

		@Override
		public boolean onDown(MotionEvent event) {
			Log.d(DEBUG_TAG, "onDown: " + event.toString());
			return true;
		}

		@Override
		public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
			Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
			return true;
		}

		@Override
		public void onLongPress(MotionEvent event) {
			Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
			Log.d(DEBUG_TAG, "onScroll: " + e1.toString() + e2.toString());
			return true;
		}

		@Override
		public void onShowPress(MotionEvent event) {
			Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
		}

		@Override
		public boolean onSingleTapUp(MotionEvent event) {
			Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
			return true;
		}

		@Override
		public boolean onDoubleTap(MotionEvent event) {
			Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
			return true;
		}

		@Override
		public boolean onDoubleTapEvent(MotionEvent event) {
			Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
			return true;
		}

		@Override
		public boolean onSingleTapConfirmed(MotionEvent event) {
			Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
			return true;
		}
	}

}
