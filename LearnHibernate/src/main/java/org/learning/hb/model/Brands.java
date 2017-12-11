package org.learning.hb.model;

public enum Brands {
	AUDI("Audi"),
	FORD("Ford"),
	MERCEDES("Mercedes"),
	OPEL("Opel"),
	VOLKSWAGEN("Volkswagen"),
	TOYOTA("Toyota");
	
	private final String name;       

    private Brands(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }

}
