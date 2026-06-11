package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private int numberDVDs = 0;
    public static final int MAX_NUMBERS_ORDERED = 20;

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media items in the cart has reached the limit of " + MAX_NUMBERS_ORDERED);
        }
        
        if (itemsOrdered.contains(media)) {
            System.out.println("The media already exists");
        } else {
            itemsOrdered.add(media);
            System.out.println("The media added successfully");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media removed successfully");
        } else {
            System.out.println("The media not found");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
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
        for (Media m : itemsOrdered) {
            System.out.println(m.toString());
        }
    }

    public void displayNumberDVD() {
        numberDVDs++;
        System.out.println("The number of DVDs of the cart is " + numberDVDs);
    }

    public void filterMedia(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
            }
        }
    }

    public void filterMedia(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println(media.toString());
            }
        }
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public Media searchMedia(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public ObservableList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }
}