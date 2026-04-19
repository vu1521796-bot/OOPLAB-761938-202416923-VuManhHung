package hust.soict.hedspi.aims.store;
import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public Store() {
    	this.itemsInStore = new ArrayList<Media>();
    }
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Da them san pham!");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Da xoa san pham!");
        } else {
            System.out.println("Khong tim thay san pham!");
        }
    }
    public void displayItems() {
        System.out.println("\n********************STORE********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("Cửa hàng hiện đang trống!");
        } else {
            for (Media m : itemsInStore) {
                System.out.println(m.toString()); 
            }
        }
        System.out.println("*********************************************");
    }
    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) { 
                return m;
            }
        }
        return null; 
    }
}
