package com.russ.openflashcards.activities;

import java.util.ArrayList;
import java.util.List;

import com.russ.openflashcards.CardsDataSource;
import com.russ.openflashcards.Deck;
import com.russ.openflashcards.DeckAdapter;
import com.russ.openflashcards.R;
import com.russ.openflashcards.R.id;
import com.russ.openflashcards.R.layout;
import com.russ.openflashcards.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
	OnItemClickListener, OnItemLongClickListener {

    public static CardsDataSource cds;
    public static DeckAdapter da;
    private Context c = this;
    private ArrayList<Deck> decks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);

	cds = new CardsDataSource(this);
	cds.open();

	decks = cds.getAllDecks();

	ListView lv = (ListView) findViewById(R.id.main_list);

	da = new DeckAdapter(this, decks);
	lv.setAdapter(da);

	lv.setOnItemClickListener(this);
	lv.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }

    @Override
    public void onClick(View v) {
	switch (v.getId()) {
	case R.id.main_add:
	    if (addDeck(((TextView) findViewById(R.id.main_deck)).getText()
		    .toString()))
		Toast.makeText(this, "Deck Added", Toast.LENGTH_SHORT).show();
	    else
		Toast.makeText(this, "Deck Already Exists", Toast.LENGTH_SHORT)
			.show();
	    break;
	}

    }

    private boolean addDeck(String s) {
	for (Deck d : decks) {
	    if (d.getName().equals(s))
		return false;
	}
	da.add(new Deck(s));
	cds.createTable(s);
	return true;

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> p, View v, int pos, long id) {
	Intent i = new Intent(this, ViewCards.class);
	i.putExtra("deck", ((TextView) v).getText().toString());
	startActivity(i);
	return true;
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	// TODO Auto-generated method stub

    }

}
