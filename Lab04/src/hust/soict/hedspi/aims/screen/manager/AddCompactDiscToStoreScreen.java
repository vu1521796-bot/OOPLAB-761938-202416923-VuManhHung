package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfArtist = new JTextField();
        JTextField tfCost = new JTextField();

        centerPanel.add(new JLabel("Title:"));
        centerPanel.add(tfTitle);
        centerPanel.add(new JLabel("Category:"));
        centerPanel.add(tfCategory);
        centerPanel.add(new JLabel("Artist:"));
        centerPanel.add(tfArtist);
        centerPanel.add(new JLabel("Cost:"));
        centerPanel.add(tfCost);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String artist = tfArtist.getText();
            float cost = Float.parseFloat(tfCost.getText());

            CompactDisc cd = new CompactDisc(title, category, artist, cost);
            store.addMedia(cd);

            JOptionPane.showMessageDialog(this, "CD added to store!");
            new StoreManagerScreen(store);
            this.dispose();
        });

        centerPanel.add(new JLabel());
        centerPanel.add(btnAdd);

        return centerPanel;
    }
}