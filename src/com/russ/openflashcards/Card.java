package com.russ.openflashcards;

public class Card {

    private String front;
    private String back;
    private long id;
    private boolean isFront;

    public Card(String f, String b) {
	front = f;
	back = b;
	isFront = true;
    }

    public Card(String f, String b, long id) {
	front = f;
	back = b;
	this.id = id;
	isFront = true;
    }

    public void flip() {
	isFront = !isFront;
    }

    public long getId() {
	return id;
    }

    public String getFront() {
	return front;
    }

    public void setFront(String front) {
	this.front = front;
    }

    public String getBack() {
	return back;
    }

    public void setBack(String back) {
	this.back = back;
    }

    @Override
    public String toString() {
	return (isFront) ? front : back;
    }

}
