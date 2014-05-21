package com.example.examplegestureproblem;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class MainActivity extends ActionBarActivity {

	private static final String TAG = MainActivity.class.getSimpleName() + "!!!!!!!!!!!!!!!!!!!1";

	private GestureDetector mDetector;
	private DrawerLayout drawerLayout;
	private View leftDrawer;
	private View rightDrawer;

	private int swipeThreshold;
	private int swipVelocityThreshold;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		leftDrawer = findViewById(R.id.left_drawer);
		rightDrawer = findViewById(R.id.right_drawer);
		mDetector = new GestureDetector(this, new MyGestureListener());

		ViewConfiguration configuration = ViewConfiguration.get(this);
		swipVelocityThreshold = configuration.getScaledMinimumFlingVelocity();
		swipeThreshold = configuration.getScaledTouchSlop();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		this.mDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		super.dispatchTouchEvent(ev);
		return mDetector.onTouchEvent(ev);
	}

	class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

		@Override
		public boolean onDown(MotionEvent event) {
			Log.d(TAG, "onDown: " + event.toString());
			return true;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			try {
				float deltaX = e2.getRawX() - e1.getRawX();
				float deltaY = e2.getRawY() - e1.getRawY();

				if (Math.abs(deltaX) > Math.abs(deltaY)) {
					if (Math.abs(deltaX) > swipeThreshold && Math.abs(velocityX) > swipVelocityThreshold) {
						if (deltaX > 0) {
							Log.i(TAG, "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
							onSwipeRight();
							return true;
						} else {
							Log.i(TAG, "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
							onSwipeLeft();
							return true;
						}
					}
				}
			} catch (Exception e) {
				Log.e(TAG, "opps", e);
			}
			return false;
		}

	}

	public void onSwipeRight() {
		Log.i(TAG, "onSwipeRight");
		if (drawerLayout.isDrawerVisible(rightDrawer)) {
			drawerLayout.closeDrawer(rightDrawer);
		} else if (!drawerLayout.isDrawerVisible(leftDrawer)) {
			drawerLayout.openDrawer(leftDrawer);
		}
	}

	public void onSwipeLeft() {
		Log.i(TAG, "onSwipeLeft");
		if (drawerLayout.isDrawerVisible(leftDrawer)) {
			drawerLayout.closeDrawer(leftDrawer);
		} else if (!drawerLayout.isDrawerVisible(rightDrawer)) {
			drawerLayout.openDrawer(rightDrawer);
		}
	}

}
