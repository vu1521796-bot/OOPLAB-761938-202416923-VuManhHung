package Aimsproject;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {

 
        Carts cart = new Carts();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladdin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.printList();   

     
        System.out.println("\n--- Search by ID ---");
        cart.checkDVDID(1);

        System.out.println("\n--- Search by Title ---");
        cart.checkDVDtitle("Star");
    }
}