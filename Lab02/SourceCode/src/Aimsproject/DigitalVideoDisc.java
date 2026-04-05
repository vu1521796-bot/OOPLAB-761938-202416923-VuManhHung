package Aimsproject;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private int id;
	private static int nbDigitalVideoDisc=0;
	private void assignId() {
        nbDigitalVideoDisc++;
        this.id = nbDigitalVideoDisc;
    }
	public DigitalVideoDisc() {
	}
	public DigitalVideoDisc(String title) {
		this.title=title;
		assignId();
	}
	public DigitalVideoDisc(String category,String title,float cost) {
		this.category=category;
		this.title=title;
		this.cost=cost;
		assignId();
	}
	public DigitalVideoDisc(String director,String category,String title,float cost) {
		this.director=director;
		this.category=category;
		this.title=title;
		this.cost=cost;
		assignId();
	}
	public DigitalVideoDisc(String title,String category,String director,int length,float cost) {
		this.title=title;
		this.category=category;
		this.director=director;
		this.length=length;
		this.cost=cost;
		assignId();
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}

}
