package hust.soict.hedspi.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof Track)) return false;
	    Track other = (Track) obj;
	    if (this.title == null || other.title == null) return false;
	    return this.title.equalsIgnoreCase(other.title) && this.length == other.length;
	}
}
