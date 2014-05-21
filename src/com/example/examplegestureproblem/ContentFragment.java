package com.example.examplegestureproblem;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

public class ContentFragment extends Fragment {

	protected static final String TAG = ContentFragment.class.getSimpleName() + "!!!!!!!!!!!!!!!!!!!!";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_content, container, false);

//		CustomScrollView scroller = (CustomScrollView) view.findViewById(R.id.scroller);
//		scroller.setOnSwipeListener(new CustomScrollView.OnSwipeListener() {
//
//			@Override
//			public void onSwipeRight() {
//				Log.i(TAG, "#############################Swipe right detected");
//				onSwipeListener.onSwipeRight();
//			}
//
//			@Override
//			public void onSwipeLeft() {
//				Log.i(TAG, "#########################Swipe left detected");
//				onSwipeListener.onSwipeLeft();
//			}
//		});

		Button b = (Button) view.findViewById(R.id.button);
		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i(TAG, "button clicked");

			}
		});

		SeekBar seekBar = (SeekBar) view.findViewById(R.id.seek);
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				Log.i(TAG, "onStopTrackingTouch");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				Log.i(TAG, "onStartTrackingTouch");
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				Log.i(TAG, "onProgressChanged");

			}
		});

		return view;
	}

}
