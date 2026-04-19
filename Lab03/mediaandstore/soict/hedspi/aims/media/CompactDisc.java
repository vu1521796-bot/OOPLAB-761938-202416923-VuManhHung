package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public CompactDisc(String artist,String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
		this.artist=artist;
	}
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
	    if (tracks.contains(track)) {
	        System.out.println("Bài hát [" + track.getTitle() + "] đã có trong danh sách");
	    } else {
	        tracks.add(track);
	        System.out.println("Thành công: Đã thêm bài hát [" + track.getTitle() + "] vào danh sách");
	    }
	}
	
	public void removeTrack(Track track) {
	    if (tracks.contains(track)) {
	        tracks.remove(track);
	        System.out.println("Thành công: Đã xóa bài hát [" + track.getTitle() + "] khỏi danh sách");
	    } else {
	        System.out.println("Lỗi: Bài hát [" + track.getTitle() + "] không tồn tại trong danh sách này, không thể xóa");
	    }
	}
	
	@Override
	public int getLength() {
		int totalLength=0;
		for (Track track : tracks) {
			totalLength+=track.getLength();
		}
		return totalLength;
	}
	
	@Override
	public void play() {
	    System.out.println("Playing CD: " + this.getTitle());
	    System.out.println("CD artist: " + this.getArtist());
	    System.out.println("Total length: " + this.getLength());
	    for (Track track : tracks) {
	        track.play();
	    }
	}

}
