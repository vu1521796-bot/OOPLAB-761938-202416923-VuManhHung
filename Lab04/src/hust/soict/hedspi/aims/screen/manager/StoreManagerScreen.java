package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Import các class từ package khác của bạn
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createNorth() {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS)); 
        northPanel.add(createMenuBar());
        northPanel.add(createHeader());
        return northPanel;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            this.dispose();
        });
        
        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            this.dispose();
        });
        
        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            this.dispose();
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> {
            new StoreManagerScreen(store);
            this.dispose();
        });
        menu.add(viewStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }
    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font("Segoe UI", Font.PLAIN, 50)); 
        title.setForeground(Color.CYAN); 
        
        header.add(title);
        return header;
    }

    private JPanel createCenter() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 3, 2, 2)); 

       
        ArrayList<Media> mediaInStore = store.getItemsInStore(); 
        
        
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            centerPanel.add(cell);
        }

        return centerPanel;
    }


    public static void main(String[] args) {
      
        Store myStore = new Store();
        myStore.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        myStore.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        myStore.addMedia(new Book("The Valley of Fear", "Detective", 20.00f));
        myStore.addMedia(new Book("A Living Mystery", "Detective", 26.00f));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StoreManagerScreen(myStore);
            }
        });
    }
}