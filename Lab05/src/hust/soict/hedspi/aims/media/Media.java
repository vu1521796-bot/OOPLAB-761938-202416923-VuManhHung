package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;

        Media other = (Media) o;

        if (this.title == null || other.getTitle() == null) {
            return this.title == other.getTitle() && Float.compare(this.cost, other.getCost()) == 0;
        }

        return this.title.equalsIgnoreCase(other.getTitle()) && Float.compare(this.cost, other.getCost()) == 0;
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare to a null Media object.");
        }

        if (this.title == null && other.getTitle() != null) 
        	return -1;
        if (this.title != null && other.getTitle() == null) 
        	return 1;
        
        int titleCompare = 0;
        if (this.title != null && other.getTitle() != null) {
            titleCompare = this.title.compareToIgnoreCase(other.getTitle());
        }

        if (titleCompare != 0) {
            return titleCompare;
        }

        return Float.compare(this.cost, other.getCost());
    }
}