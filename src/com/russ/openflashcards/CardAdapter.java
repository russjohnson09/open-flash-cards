package com.russ.openflashcards;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class CardAdapter extends BaseAdapter {

    private Context c;

    private ArrayList<Card> cards = new ArrayList<Card>();

    public CardAdapter(Context c) {
	this.c = c;

	for (int i = 0; i < 10; i++)
	    cards.add(new Card("a", "b"));
    }

    public CardAdapter(Context c, List<Card> cards) {
	this.c = c;
	this.cards = (ArrayList<Card>) cards;
    }

    @Override
    public int getCount() {
	return cards.size();
    }

    @Override
    public Object getItem(int pos) {
	return cards.get(pos);
    }

    @Override
    public long getItemId(int pos) {
	return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

	TextView tv;
	tv = new TextView(c);
	tv.setLayoutParams(new GridView.LayoutParams(85, 85));
	tv.setPadding(8, 8, 8, 8);
	tv.setText(cards.get(position).toString());

	return tv;

    }

    public void flip(int pos) {
	cards.get(pos).flip();
	notifyDataSetChanged();
    }

    public void add(String f, String b) {
	cards.add(new Card(f, b));
	notifyDataSetChanged();
    }

    public void add(Card card) {
	cards.add(card);
	notifyDataSetChanged();
    }

    public void remove(int pos) {
	cards.remove(pos);
	notifyDataSetChanged();
    }
}
