package com.example.examplegestureproblem;
/**
 * NOT USED!!!!!!!!!!!!!!!!!!!!!1
 */

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {

	private static final String TAG = CustomScrollView.class.getSimpleName() + "!!!!!!!!!!!!!!!!!";

	public CustomScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initScrollView(context);
	}

	private void initScrollView(Context context) {
		ViewConfiguration configuration = ViewConfiguration.get(context);
		touchSlop = configuration.getScaledTouchSlop();
		minimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
		Log.i(TAG, "touchslop: " + touchSlop);
		tracker = VelocityTracker.obtain();
	}

	public CustomScrollView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomScrollView(Context context) {
		this(context, null);
	}

	private float startX;
	private float startY;
	private int touchSlop;
	private int minimumFlingVelocity;
	private boolean scrolling;
	private boolean swallowing;
	private boolean swipeDetected;
	private VelocityTracker tracker;
	private OnSwipeListener onSwipeListener;

	public interface OnSwipeListener {
		public void onSwipeLeft();

		public void onSwipeRight();
	}

	public void setOnSwipeListener(OnSwipeListener listener) {
		onSwipeListener = listener;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		final int action = ev.getAction();

		switch (action & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			startX = ev.getX();
			startY = ev.getY();
			scrolling = false;
			swallowing = false;
			swipeDetected = false;
			break;
		case MotionEvent.ACTION_MOVE:
			tracker.addMovement(ev);
			float deltaX = startX - ev.getX();
			float deltaY = startY - ev.getY();
			float absDeltaX = Math.abs(deltaX);
			float absDeltaY = Math.abs(deltaY);
			tracker.computeCurrentVelocity(1000);
			float xVelocity = tracker.getXVelocity();

			Log.i(TAG, "deltaX: " + deltaX + ", deltaY: " + deltaY + ", scrolling: " + scrolling + ", swallowing: " + swallowing + ", xvel: "
					+ xVelocity);

			if (swallowing && !swipeDetected && Math.abs(xVelocity) > minimumFlingVelocity && onSwipeListener != null) {
				swipeDetected = true;
				if (xVelocity > 0) {
					Log.i(TAG, "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
					onSwipeListener.onSwipeRight();
				} else {
					Log.i(TAG, "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
					onSwipeListener.onSwipeLeft();
				}
			}

			if (swallowing) {
				return true;
			}

			if (absDeltaX > touchSlop && absDeltaY > touchSlop && !scrolling) {
				if (absDeltaX > (absDeltaY * 1.7)) {
					// swallow event
					Log.i(TAG, "Swallowing event");
					swallowing = true;
					return true;
				} else {
					scrolling = true;
				}

			}
			break;
		case MotionEvent.ACTION_UP:
			scrolling = false;
			swallowing = false;
			break;
		default:
			break;
		}
		return super.onTouchEvent(ev);
	}
}

