package com.russ.openflashcards.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ListView;

import com.russ.openflashcards.Card;
import com.russ.openflashcards.CardAdapter;
import com.russ.openflashcards.CardsDataSource;
import com.russ.openflashcards.R;

public class ViewCards extends Activity implements OnClickListener,
	OnItemClickListener, OnItemLongClickListener {

    private CardAdapter ca;
    public static ArrayList<Card> cards;
    private CardsDataSource cds;
    private String deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.view_cards);

	Bundle b = getIntent().getExtras();
	cds = MainActivity.cds;
	deck = b.getString("deck");
	cards = cds.getDeck(deck);
	ca = new CardAdapter(this, cards);

	ListView lv = (ListView) findViewById(R.id.view_cards_list);
	lv.setAdapter(ca);

	lv.setOnItemClickListener(this);
	lv.setOnItemLongClickListener(this);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos,
	    long arg3) {
	startActivity(new Intent(this, CardView.class).putExtra("index", pos));
	return true;
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onClick(View v) {
	switch (v.getId()) {
	case R.id.view_cards_add:
	    String front = ((EditText) findViewById(R.id.view_cards_front))
		    .getText().toString();
	    String back = ((EditText) findViewById(R.id.view_cards_back))
		    .getText().toString();
	    cds.createCard(deck, front, back);
	    ca.add(new Card(front, back));
	    break;

	}

    }
}
