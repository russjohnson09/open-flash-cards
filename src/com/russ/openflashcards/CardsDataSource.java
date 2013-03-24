package com.russ.openflashcards;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CardsDataSource extends SQLiteOpenHelper {

    public static final String TABLE_CARDS = "cards";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FRONT = "front";
    public static final String COLUMN_BACK = "back";

    private static final String DATABASE_NAME = "cards.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table " + TABLE_CARDS
	    + "(" + COLUMN_ID + " integer primary key autoincrement, "
	    + COLUMN_FRONT + " text not null, " + COLUMN_BACK
	    + " text not null);";

    private SQLiteDatabase database;

    private final String[] allColumns = { COLUMN_ID, COLUMN_FRONT, COLUMN_BACK };

    public CardsDataSource(Context context) {
	super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open() throws SQLException {
	database = getWritableDatabase();
    }

    public Card createCard(String table, String front, String back) {
	ContentValues values = new ContentValues();
	values.put(COLUMN_FRONT, front);
	values.put(COLUMN_BACK, back);
	long insertId = database.insert(table, null, values);
	Cursor cursor = database.query(table, allColumns, COLUMN_ID + " = "
		+ insertId, null, null, null, null);
	cursor.moveToFirst();
	Card card = cursorToCard(cursor);
	cursor.close();
	return card;
    }

    public void deleteCard(Card card) {
	long id = card.getId();
	database.delete(TABLE_CARDS, COLUMN_ID + " = " + id, null);
    }

    public List<Card> getAllCards() {
	List<Card> cards = new ArrayList<Card>();

	Cursor cursor = database.query(TABLE_CARDS, allColumns, null, null,
		null, null, null);

	cursor.moveToFirst();
	while (!cursor.isAfterLast()) {
	    Card card = cursorToCard(cursor);
	    cards.add(card);
	    cursor.moveToNext();
	}

	cursor.close();
	return cards;
    }

    private Card cursorToCard(Cursor cursor) {
	return new Card(cursor.getString(1), cursor.getString(2),
		cursor.getLong(0));
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
	db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARDS);
	onCreate(db);
    }

    public List<Deck> getAllDecks() {
	// TODO Auto-generated method stub
	return null;
    }

}
