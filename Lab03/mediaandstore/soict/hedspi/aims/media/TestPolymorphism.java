package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
public class TestPolymorphism {
	public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<Media>();
        mediaList.add(new DigitalVideoDisc("Inception", "Sci-Fi", "Nolan", 148,20.0f));
        mediaList.add(new Book("Java Design Patterns", "Tech", 30.0f));
        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
    }
}
