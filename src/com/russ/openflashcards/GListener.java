package com.russ.openflashcards;

import com.russ.openflashcards.activities.CardView;
import com.russ.openflashcards.activities.ViewCards;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
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
    public void onLongPress(MotionEvent e) {
	// TODO Auto-generated method stub
	super.onLongPress(e);
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
	CardView.answerShown = !CardView.answerShown;
	return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
	    float velocityX, float velocityY) {
	int dx = (int) (event2.getX() - event1.getX());
	if (Math.abs(dx) > 1 && Math.abs(velocityX) > Math.abs(velocityY)) {
	    int a = CardView.index;
	    int b = ViewCards.cards.size();
	    if (velocityX > 0) {
		a--;
		if (a < 0)
		    CardView.index = b - 1;
		else
		    CardView.index = a;
	    } else {
		a++;
		CardView.index = a % b;
	    }
	    return true;
	}
	return false;
    }
}
