package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
    }

    @Override
    public String toString() {
        return String.format("DVD - %s - %s - %s - %d: %.2f $\n",
                super.getTitle(),
                super.getCategory(),
                super.getDirector(),
                super.getLength(),
                super.getCost());
    }

    public boolean isMatch(String title) {
        return super.getTitle().equalsIgnoreCase(title);
    }

    public boolean isMatch(int id) {
        return super.getId() == id;
    }

    @Override
    public void play() throws PlayerException { 
        if (super.getLength() > 0) {
            System.out.println("Playing DVD: " + super.getTitle()); 
            System.out.println("DVD length: " + super.getLength()); 
        } else {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
