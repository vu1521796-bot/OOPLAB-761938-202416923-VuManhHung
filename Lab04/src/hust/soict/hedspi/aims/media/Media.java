package hust.soict.hedspi.aims.media;
import java.util.Comparator;
public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	public Media() {
		// TODO Auto-generated constructor stub
	}
	public Media(String title) {
		this.title=title;
	}
	public Media(String category,String title,float cost) {
		this.category=category;
		this.title=title;
		this.cost=cost;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof Media)) return false;
	    Media other = (Media) obj;
	    if (this.title == null || other.title == null) return false;
	    return this.title.equalsIgnoreCase(other.title);
	}
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
	        Comparator.comparing(Media::getTitle).thenComparing(Comparator.comparing(Media::getCost).reversed());
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
	        Comparator.comparing(Media::getCost).reversed()
	                  .thenComparing(Media::getTitle);
}
