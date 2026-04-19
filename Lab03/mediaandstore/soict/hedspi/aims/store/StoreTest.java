package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store myStore = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 82, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        System.out.println("--- Testing Add DVD ---");
        myStore.addDVD(dvd1);
        myStore.addDVD(dvd2);
        myStore.addDVD(dvd3);
        System.out.println("\n--- Testing Remove DVD ---");
        System.out.print("Xoa Star Wars: ");
        myStore.removeDVD(dvd2);
        System.out.print("Xoa lai Star Wars lan nua: ");
        myStore.removeDVD(dvd2);
        System.out.print("Xoa The Lion King: ");
        myStore.removeDVD(dvd1);
    }
}