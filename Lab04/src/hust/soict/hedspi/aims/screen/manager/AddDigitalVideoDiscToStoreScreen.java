package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(6, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfDirector = new JTextField();
        JTextField tfLength = new JTextField();
        JTextField tfCost = new JTextField();

        centerPanel.add(new JLabel("Title:"));
        centerPanel.add(tfTitle);
        centerPanel.add(new JLabel("Category:"));
        centerPanel.add(tfCategory);
        centerPanel.add(new JLabel("Director:"));
        centerPanel.add(tfDirector);
        centerPanel.add(new JLabel("Length:"));
        centerPanel.add(tfLength);
        centerPanel.add(new JLabel("Cost:"));
        centerPanel.add(tfCost);

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);

            JOptionPane.showMessageDialog(this, "DVD added to store!");
            new StoreManagerScreen(store);
            this.dispose();
        });

        centerPanel.add(new JLabel());
        centerPanel.add(btnAdd);

        return centerPanel;
    }
}