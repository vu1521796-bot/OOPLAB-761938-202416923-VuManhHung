package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int result = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (result != 0) return result;

        return Float.compare(m2.getCost(), m1.getCost()); 
    }
}