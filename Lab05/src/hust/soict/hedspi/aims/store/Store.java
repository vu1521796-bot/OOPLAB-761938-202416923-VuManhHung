package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.Collections;


import hust.soict.hedspi.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>(); 
	public void addMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			System.out.println("The media already exist");
		}
		else {
			itemsOrdered.add(media);
			System.out.println("The media added successfully");
		}
	}
	public void removeMedia(Media media) {
		if(itemsOrdered.remove(media)) {
			System.out.println("The media removed successfully");
		}
		else {
			System.out.println("The media not found");
		}
	}
	public float totalCost() {
		float sum = 0;
		for(Media media: itemsOrdered) {
			sum += media.getCost();
		}
		return sum;
	}
	public void sortByTitle() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCost() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	public void print() {
		for(Media m : itemsOrdered) {
			System.out.println(m.toString());
		}
	}
	public Media searchMedia(String title) {
		for(Media m : itemsOrdered) {
			if(m.getTitle().equalsIgnoreCase(title)) {
				return m;
			}
		}
		return null;
	}
	public ArrayList<Media> getItemsInStore(){
		return itemsOrdered;
	}
}
