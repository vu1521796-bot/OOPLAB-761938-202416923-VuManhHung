package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StoreManagerScreen extends JFrame{
	private Store store;
	private JPanel center;
	public StoreManagerScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		center = createCenter();
		cp.add(center, BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		MenuListener menuListener = new MenuListener();
		
		JMenuItem viewStore = new JMenuItem("View Store");
		viewStore.addActionListener(menuListener);
		menu.add(viewStore);
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem addCD = new JMenuItem("Add CD");
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addBook.addActionListener(menuListener);
		addCD.addActionListener(menuListener);
		addDVD.addActionListener(menuListener);
		
		
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
		
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;
	}
	private void setCenter(JPanel newCenter) {
		Container cp = getContentPane();
		cp.remove(center);
		center = newCenter;
		cp.add(center, BorderLayout.CENTER);
		cp.revalidate();
		cp.repaint();
	}
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(0, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(Media media : mediaInStore) {
			MediaStore cell = new MediaStore(media);
			center.add(cell);
		}
		
		return center;
	}
	JPanel createAddDigitalVideoDisc() {
		JPanel center = new AddDigitalVideoDiscToStoreScreen(store);
		return center;
	}
	JPanel createAddCompactDisc() {
		JPanel center = new AddCompactDiscToStoreScreen(store);
		return center;
	}
	JPanel createAddBook() {
		JPanel center = new AddBookToStoreScreen(store);
		return center;
	}
	private class MenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String event = e.getActionCommand();
			
			if(event.equals("View Store")) {
				setCenter(createCenter());
			}
			else if(event.equals("Add Book")) {
				setCenter(createAddBook());
			}
			else if(event.equals("Add CD")) {
				setCenter(createAddCompactDisc());
			}
			else if(event.equals("Add DVD")) {
				setCenter(createAddDigitalVideoDisc());
			}
		}
	}
	public static void main(String[] args) {
		Store store = new Store();

	   
	    Book book1 = new Book(1, "Clean Code", "Programming", 15.5f);
	    book1.addAuthor("Robert C. Martin");

	    Book book2 = new Book(2, "The Hobbit", "Fantasy", 12.0f);
	    book2.addAuthor("J.R.R. Tolkien");

	    Book book3 = new Book(3, "Sherlock Holmes", "Detective", 10.0f);
	    book3.addAuthor("Arthur Conan Doyle");

	
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc(
	            4,
	            "Avengers Endgame",
	            "Action",
	            "Russo Brothers",
	            180,
	            20.0f
	    );
	    
	    DigitalVideoDisc dvd2 = new DigitalVideoDisc(
	            5,
	            "Interstellar",
	            "Sci-Fi",
	            "Christopher Nolan",
	            169,
	            18.5f
	    );

	    DigitalVideoDisc dvd3 = new DigitalVideoDisc(
	            6,
	            "Kung Fu Panda",
	            "Animation",
	            "Mark Osborne",
	            92,
	            14.0f
	    );

	   
	    CompactDisc cd1 = new CompactDisc(
	            7,
	            "Greatest Hits",
	            "Music",
	            "John Smith",
	            9.5f,
	            "Queen"
	    );
	    cd1.addTrack(new Track("Bohemian Rhapsody", 6));
	    cd1.addTrack(new Track("We Will Rock You", 3));
	    CompactDisc cd2 = new CompactDisc(
	            8,
	            "Pop Collection",
	            "Pop",
	            "David Lee",
	            8.0f,
	            "Taylor Swift"
	    );
	    cd2.addTrack(new Track("Love Story", 4));
	    cd2.addTrack(new Track("Blank Space", 4));

	    CompactDisc cd3 = new CompactDisc(
	            9,
	            "Classical Essentials",
	            "Classical",
	            "Mozart",
	            11.0f,
	            "Beethoven"
	    );
	    cd3.addTrack(new Track("Symphony No.5", 7));
	    cd3.addTrack(new Track("Fur Elise", 5));

	
	    store.addMedia(book1);
	    store.addMedia(book2);
	    store.addMedia(book3);

	    store.addMedia(dvd1);
	    store.addMedia(dvd2);
	    store.addMedia(dvd3);

	    store.addMedia(cd1);
	    store.addMedia(cd2);
	    store.addMedia(cd3);
	    
	    
	   
	    StoreManagerScreen sms = new StoreManagerScreen(store);
	}
}
