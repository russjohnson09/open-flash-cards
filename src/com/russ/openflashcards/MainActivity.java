package com.russ.openflashcards;

import java.util.List;

import com.example.sqlite.Card;
import com.example.sqlite.CardAdapter;
import com.example.sqlite.CardsDataSource;
import com.example.sqlite.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener,
	OnItemClickListener, OnItemLongClickListener {

    CardsDataSource cds;
    DeckAdapter da;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);

	cds = new CardsDataSource(this);
	cds.open();

	List<Deck> decks = cds.getAllDecks();

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
	case 1:
	    break;
	}

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
	    long arg3) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	// TODO Auto-generated method stub

    }

}
