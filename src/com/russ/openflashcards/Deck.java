package com.russ.openflashcards;

public class Deck {

    private String name;
    private long id;

    public Deck(String name) {
	this.name = name;
	id = 0;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return name;
    }

}
