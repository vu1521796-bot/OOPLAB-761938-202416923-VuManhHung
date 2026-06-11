package hust.soict.hedspi.aims.screen.manager;
import java.awt.*;
import hust.soict.hedspi.aims.media.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class PlayDVD extends JDialog{
	public PlayDVD(boolean playable, String title, int length) {

        Container cp = getContentPane();
        cp.setLayout(new GridLayout(1,1));

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
            text1.setText("Playing DVD: " + title);
            text2.setText("DVD length: " + length);
        }
        else {
            text1.setText("The DVD cannot be played !");
            text2.setText("Since the lenght of this DVD smaller than or equal to 0");
        }
        header.add(text1);
        header.add(text2);
        cp.add(header);

        setTitle("Playing DVD");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
