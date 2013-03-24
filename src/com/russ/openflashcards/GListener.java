package com.russ.openflashcards;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.Toast;

public class GListener extends SimpleOnGestureListener {

    private Context c;

    public GListener(Context c) {
	this.c = c;
    }

    @Override
    public boolean onDown(MotionEvent event) {
	return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
	    float velocityX, float velocityY) {
	Log.d(null, "Fling");
	int dx = (int) (event2.getX() - event1.getX());
	// don't accept the fling if it's too short
	// as it may conflict with a button push
	if (Math.abs(dx) > 1 && Math.abs(velocityX) > Math.abs(velocityY)) {
	    if (velocityX > 0) {
		Toast.makeText(c, "L", Toast.LENGTH_SHORT).show();
	    } else {
		Toast.makeText(c, "R", Toast.LENGTH_SHORT).show();
	    }
	    return true;
	} else {
	    return false;
	}
    }

}
