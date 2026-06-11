package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, String director, float cost, String artist) {
        super(id, title, category, director, cost);
        this.artist = artist;
    }
    
    public List<Track> getTracks() {
        return tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The track already exists");
        } else {
            tracks.add(track);
            System.out.println("Track added successfully");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track removed successfully");
        } else {
            System.out.println("Track not found");
        }
    }

    public int getLength() {
        int sum = 0;
        for (Track track : tracks) {
            sum += track.getLength();
        }
        return sum;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + super.getTitle() + " by " + this.getArtist());
            System.out.println("CD length: " + this.getLength());
            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw e; 
                }
            }
        } else {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        String result = String.format(
            "CD - %s - %s - %s - %s - %d: %.2f $\n",
            super.getTitle(),
            super.getCategory(),
            this.getArtist(),
            super.getDirector(),
            this.getLength(),
            super.getCost()
        );

        result += "Tracks:\n";
        if (tracks.isEmpty()) {
            result += "No tracks available\n";
        } else {
            for (Track track : tracks) {
                result += "- " + track.getTitle() + " - " + track.getLength() + "\n";
            }
        }
        return result;
    }
}