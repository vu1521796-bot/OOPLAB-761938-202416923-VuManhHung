package hust.soict.hedspi.aims.media;
import java.util.Scanner;
public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDisc=0;
	private void assignId() {
        nbDigitalVideoDisc++;
        this.setId(nbDigitalVideoDisc);
    }
	public DigitalVideoDisc() {
	}
	public DigitalVideoDisc(String title) {
		super(title,null,null,0,0);
		assignId();
	}
	public DigitalVideoDisc(String category,String title,float cost) {
		super(title,category,null,0,cost);
		assignId();
	}
	public DigitalVideoDisc(String director,String category,String title,float cost) {
		super(title,category,director,0,cost);
		assignId();
	}
	public DigitalVideoDisc(String title,String category,String director,int length,float cost) {
		super(title,category,director,length,cost);
		assignId();
	}
	@Override
	public String toString() {
	    return "DVD [" + this.getTitle() + "] - [" + this.getCategory()+ "] - ["
	            + getDirector() + "] - [" + getLength() + "] :" + this.getCost();
	}
	@Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}