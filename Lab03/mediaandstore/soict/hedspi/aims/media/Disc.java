package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Disc(String title, String category, String director, int length, float cost) {
		super (category,title,cost);
		this.director=director;
		this.length=length;
	}
}
