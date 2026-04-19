package Aimsproject;

import java.util.Scanner;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Aims {
    private static Store store = new Store();
    private static Carts cart = new Carts(); 
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setupData();
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void viewStore() {
        while (true) {
            store.displayItems();
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m != null) {
                        System.out.println(m.toString());
                        handleMediaDetails(m);
                    } else System.out.println("Not found!");
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    Media mAdd = store.searchByTitle(scanner.nextLine());
                    if (mAdd != null) cart.addMedia(mAdd);
                    break;
                case 3:
                    System.out.print("Enter title: ");
                    Media mP = store.searchByTitle(scanner.nextLine());
                    if (mP instanceof Playable) ((Playable) mP).play();
                    else System.out.println("Cannot play!");
                    break;
                case 4: viewCart(); break;
            }
        }
    }

    public static void handleMediaDetails(Media m) {
        while (true) {
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice == 1) cart.addMedia(m);
            else if (choice == 2 && m instanceof Playable) ((Playable) m).play();
        }
    }

    public static void viewCart() {
        while (true) {
            cart.printList();
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1: filterMediaInCart(); break;
                case 2: sortMediaInCart(); break;
                case 3: 
                    System.out.print("Title to remove: ");
                    String t = scanner.nextLine();
                    Media found = null;
                    for (Media media : cart.getItemsInCart()) {
                        if (media.getTitle().equalsIgnoreCase(t)) { found = media; break; }
                    }
                    if (found != null) cart.removeMedia(found);
                    break;
                case 4:
                    System.out.print("Title to play: ");
                    String tp = scanner.nextLine();
                    for (Media media : cart.getItemsInCart()) {
                        if (media.getTitle().equalsIgnoreCase(tp) && media instanceof Playable) {
                            ((Playable) media).play(); break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Order created!");
                    cart.getItemsInCart().clear();
                    break;
            }
        }
    }

    public static void filterMediaInCart() {
        System.out.print("1. ID | 2. Title: ");
        int c = scanner.nextInt(); scanner.nextLine();
        if (c == 1) cart.searchById(scanner.nextInt());
        else cart.searchByTitle(scanner.nextLine());
    }

    public static void sortMediaInCart() {
        System.out.print("1. Title | 2. Cost: ");
        int c = scanner.nextInt(); scanner.nextLine();
        if (c == 1) cart.sortByTitle();
        else cart.sortByCost();
    }
    
    public static void updateStore() {
        System.out.println("Update store feature...");
    }

    private static void setupData() {
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", 18.99f));
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", 24.95f));
    }
}