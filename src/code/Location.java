package code;

import java.util.ArrayList;
import java.util.Collections;


public class Location {
	
	private ArrayList<Person> persons = new ArrayList<Person>();

	public void makeList() {
		for (int i=0; i <9; i++) {
			RedAgent red = new RedAgent("A"+i, this, 0);
			persons.add(red);
		}
		for (int x=0; x< 8; x++) {
			BlueAgent blue = new BlueAgent("B"+x, this, 0);
			persons.add(blue);
		}
		for (int y=0; y< 7; y++) {
			InnocentBystander innocent = new InnocentBystander("I"+y, this, 0);
			persons.add(innocent);
		}
		Assassin assassin = new Assassin("G", this, 0);
		persons.add(assassin);
		Collections.shuffle(persons);
		Location[][] bleh = new Location[5][5];
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < bleh[i].length; k++) {
				// want to loop inside it and set every person's codename to a codename from the arraylist of perosns
				bleh[i][k] = persons.get((i*5) + k);
			}
		}
	}
}
