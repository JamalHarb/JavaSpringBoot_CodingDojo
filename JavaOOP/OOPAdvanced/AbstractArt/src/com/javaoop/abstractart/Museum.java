package com.javaoop.abstractart;
import java.util.ArrayList;

public class Museum {
	private static ArrayList<Object> museum = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Painting p1 = new Painting("Oil");
		Painting p2 = new Painting("Water");
		Painting p3 = new Painting("Synthetic");
		
		p1.viewArt();
		p2.viewArt();
		p3.viewArt();
		
		Sculpture s1 = new Sculpture("Gold");
		Sculpture s2 = new Sculpture("Bronze");
		
		s1.viewArt();
		s2.viewArt();
		
		museum.add(p1);
		museum.add(p2);
		museum.add(p3);
		museum.add(s1);
		museum.add(s2);
		

	}

}
