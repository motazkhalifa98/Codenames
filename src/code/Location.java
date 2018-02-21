package code;

import java.util.ArrayList;
import java.util.Collections;


public class Location extends Board {
	public Location(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Person> persons = new ArrayList<Person>();
	public void makeList() {
	for (int i=0; i <9; i++) {
		RedAgent red = new RedAgent();
		persons.add(red);
	}
	for (int x=0; x< 8; x++) {
		BlueAgent blue = new BlueAgent();
		persons.add(blue);
	}
	for (int y=0; y< 7; y++) {
		InnocentBystander innocent = new InnocentBystander();
		persons.add(innocent);
	}
	Assassin assassin = new Assassin();
	persons.add(assassin);
	Collections.shuffle(persons);
	Location[][] bleh = new Location[5][5];
	for (int i = 0; i < 5; i++) {
		for (int z = 0; z < bleh[i].length; z++) {
		// want to loop inside it and set every person's codename to a codename from the arraylist of perosns
		}
	}
}
