package com.russ.openflashcards.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.russ.openflashcards.Card;
import com.russ.openflashcards.GListener;
import com.russ.openflashcards.R;

public class CardView extends Activity implements OnClickListener {

    private Card card;
    public static boolean answerShown = false;
    private TextView front;
    private TextView back;
    public static int index;

    private GestureDetector gestureScanner;
    private GestureDetector gd;

    private Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.card_view);

	c = this;

	index = getIntent().getExtras().getInt("index", 0);
	card = ViewCards.cards.get(index);

	front = (TextView) findViewById(R.id.card_view_front);
	back = (TextView) findViewById(R.id.card_view_back);

	front.setText(card.getFront());

	gestureScanner = new GestureDetector(this, new GListener(this));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
	if (gestureScanner.onTouchEvent(event)) {
	    card = ViewCards.cards.get(index);
	    front.setText(card.getFront());
	    back.setText("");
	    return true;
	} else {
	    return false;
	}
    }

    @Override
    public void onClick(View v) {
	answerShown = !answerShown;
	back.setText((answerShown) ? card.getBack() : "");

    }
}
