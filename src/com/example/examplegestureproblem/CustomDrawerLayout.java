package com.example.examplegestureproblem;
/**
 * NOT USED!!!!!!!!!!!!!!!!!!!!!1
 */
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomDrawerLayout extends DrawerLayout {

	private int screenWidth;
	private int edge;
	private View rightDrawer;
	private View leftDrawer;

	public CustomDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		screenWidth = DisplayUtils.getDisplayWidth(context);
		edge = (int) UnitUtils.dipToPixels(getContext(), 20);
	}

	public CustomDrawerLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomDrawerLayout(Context context) {
		super(context);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		rightDrawer = findViewById(R.id.right_drawer);
		leftDrawer = findViewById(R.id.left_drawer);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// return super.onTouchEvent(event);

		boolean inCenter = true;
		if (event.getX() <= edge) {
			inCenter = false;
		} else if ((screenWidth - event.getX()) >= edge) {
			inCenter = false;
		}

		if (inCenter && event.getAction() == MotionEvent.ACTION_DOWN)

			if (event.getX() > edge && event.getAction() == MotionEvent.ACTION_DOWN) {
				if (isDrawerOpen(rightDrawer) || isDrawerVisible(rightDrawer) || isDrawerOpen(leftDrawer) || isDrawerVisible(leftDrawer)) {
					return true;
				} else {
					return false;
				}
			}

		return super.onTouchEvent(event);
	}

}
