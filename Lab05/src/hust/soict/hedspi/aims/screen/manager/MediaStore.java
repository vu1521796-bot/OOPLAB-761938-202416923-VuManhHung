package hust.soict.hedspi.aims.screen.manager;
import java.awt.*;
import hust.soict.hedspi.aims.media.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.List;
public class MediaStore extends JPanel{
	private Media media;
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			container.add(playButton);
			playButton.addActionListener(new ButtonListener());
		}
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	private class ButtonListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if(media instanceof CompactDisc) {
	        	CompactDisc cd = (CompactDisc) media;
	        	List<Track> tracks = cd.getTracks();
	        	for(Track track : tracks) {
	    			if(track.getLength() <= 0) {
	    				new PlayCD(false, cd);
	    				return;
	    			}
	    		}
	    		new PlayCD(true, cd);
	        }
	        else {
	        	DigitalVideoDisc disc = (DigitalVideoDisc) media;
	        	if(disc.getLength() > 0) {
	        	    new PlayDVD(true, disc.getTitle(), disc.getLength());
	        	}
	        	else {
	        	    new PlayDVD(false, "", 0);
	        	}
	        }
	    }
	}
	
}
