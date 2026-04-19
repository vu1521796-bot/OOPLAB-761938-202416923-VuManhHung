package Aimsproject;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
public class Carts {
	public static final int  MAX_NUMBERS_ORDERED=20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	int qtyOrdered;
	public Carts() {
		this.itemsOrdered = new ArrayList<Media>();
	}
	public ArrayList<Media> getItemsInCart() {
	    return itemsOrdered; 
	}
	public void addMedia(Media media) {
	    if (!(itemsOrdered.contains(media))) {
	        itemsOrdered.add(media);
	        System.out.println("The media has been added: " + media.getTitle());
	    } else {
	        System.out.println("The media is already in the cart.");
	    }
	}
	
	public void removeMedia(Media media) {
	    if (itemsOrdered.contains(media)) {
	        itemsOrdered.remove(media);
	        System.out.println("The media has been removed: " + media.getTitle());
	    } else {
	        System.out.println("The media is not found in the cart.");
	    }
	}
	public float totalCost() {
	    float total = 0;
	    for (Media media : itemsOrdered) {
	        total += media.getCost();
	    }
	    return total;
	}
	
	public void printList() {
	    System.out.println("***********************CART***********************");
	    System.out.println("Ordered Items:");

	    int i = 1;
	    for (Media media : itemsOrdered) {
	        System.out.println(i + ". " + media.toString());
	        i++;
	    }

	    System.out.println("Total cost: " + totalCost());
	    System.out.println("***************************************************");
	}
	public void searchById(int id) {
	    boolean found = false;
	    for (Media media : itemsOrdered) {
	        if (media.getId() == id) {
	            System.out.println("Found: " + media.toString());
	            found = true;
	            break; 
	        }
	    }
	    if (!found) {
	        System.out.println("No media found with ID: " + id);
	    }
	}
	public void searchByTitle(String title) {
	    boolean found = false;
	    for (Media media : itemsOrdered) {
	        if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
	            System.out.println("Found: " + media.toString());
	            found = true;
	        }
	    }
	    if (!found) {
	        System.out.println("No media found with title: " + title);
	    }
	}
	public void sortByTitle() {
	    Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	    System.out.println("Cart has been sorted by title.");
	}
	public void sortByCost() {
	    Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	    System.out.println("Cart has been sorted by cost.");
	}
	public void clear() {
	    this.itemsOrdered.clear();
	}
}