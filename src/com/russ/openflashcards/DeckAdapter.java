package com.russ.openflashcards;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class DeckAdapter extends BaseAdapter {

    private ArrayList<Deck> decks;
    private Context c;

    public DeckAdapter(Context c, List<Deck> decks) {
	this.c = c;
	this.decks = (ArrayList<Deck>) decks;
    }

    @Override
    public int getCount() {
	return decks.size();
    }

    @Override
    public Object getItem(int position) {
	return decks.get(position);
    }

    @Override
    public long getItemId(int position) {
	return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
	TextView tv;
	tv = new TextView(c);
	// tv.setLayoutParams(new ListView.)
	// tv.setLayoutParams(new ListView.LayoutParams(85, 85));
	// tv.setPadding(8, 8, 8, 8);
	tv.setText(decks.get(position).toString());

	return tv;
    }

    public void add(Deck deck) {
	decks.add(deck);
	notifyDataSetChanged();
    }

}
