package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import hust.soict.hedspi.aims.media.*;

public class PlayCD extends JDialog {

	public PlayCD(boolean playable, CompactDisc cd) {

		Container cp = getContentPane();

		cp.setLayout(new BorderLayout());

		cp.add(createPlayCD(playable, cd), BorderLayout.NORTH);
		cp.add(createPlayTracks(playable, cd), BorderLayout.CENTER);

		setTitle("Playing CD");
		setSize(500, 500);

		setVisible(true);
	}

	JPanel createPlayCD(boolean playable, CompactDisc cd) {

		JPanel header = new JPanel();

		header.setLayout(new GridLayout(2, 1));
		header.setBorder(new EmptyBorder(10, 10, 10, 10));

		JLabel text1 = new JLabel();
		JLabel text2 = new JLabel();
		Font titleFont = new Font(text1.getFont().getName(), Font.BOLD, 16);
		Font infoFont = new Font(text2.getFont().getName(), Font.PLAIN, 14);

		text1.setFont(titleFont);
		text2.setFont(infoFont);

		if(playable) {

			text1.setText("Playing CD: " + cd.getTitle());
			text2.setText("CD length: " + cd.getLength());

		}
		else {
			text1.setText("The CD cannot be played !");
			text2.setText("Since there exist track that its length smaller than or equal to 0");
		}

		header.add(text1);
		header.add(text2);

		return header;
	}

	JPanel createPlayTracks(boolean playable, CompactDisc cd) {

		JPanel center = new JPanel();

		center.setLayout(new BorderLayout());

		if(playable) {

			JPanel tracksContainer = new JPanel();
			tracksContainer.setLayout(new GridLayout(0, 1, 0, 10));
			tracksContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

			for(Track track : cd.getTracks()) {

				JPanel cell = new JPanel();
				cell.setLayout(new GridLayout(2, 1));
				
				Border line = new LineBorder(Color.BLACK, 1);
				Border padding = new EmptyBorder(10, 10, 10, 10);
				cell.setBorder(BorderFactory.createCompoundBorder(line, padding));
				
				JLabel text1 = new JLabel("Playing track: " + track.getTitle());
				JLabel text2 = new JLabel("Track length: " + track.getLength());
				text1.setFont(new Font(text1.getFont().getName(), Font.BOLD, 16));
				text2.setFont(new Font(text2.getFont().getName(), Font.PLAIN, 14));
				cell.add(text1);
				cell.add(text2);
				tracksContainer.add(cell);
			}

			JScrollPane pane = new JScrollPane(tracksContainer);

			center.add(pane, BorderLayout.CENTER);
		}
		else {
			JPanel panel = new JPanel();
			center.add(panel);
		}

		return center;
	}
}