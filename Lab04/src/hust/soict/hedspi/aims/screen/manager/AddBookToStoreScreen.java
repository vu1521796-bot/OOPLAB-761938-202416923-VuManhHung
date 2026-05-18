package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfCost = new JTextField();

        centerPanel.add(new JLabel("Title:"));
        centerPanel.add(tfTitle);
        centerPanel.add(new JLabel("Category:"));
        centerPanel.add(tfCategory);
        centerPanel.add(new JLabel("Cost:"));
        centerPanel.add(tfCost);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());

            Book book = new Book(title, category, cost);
            store.addMedia(book);

            JOptionPane.showMessageDialog(this, "Book added to store!");
            new StoreManagerScreen(store);
            this.dispose();
        });

        centerPanel.add(new JLabel());
        centerPanel.add(btnAdd);

        return centerPanel;
    }
}