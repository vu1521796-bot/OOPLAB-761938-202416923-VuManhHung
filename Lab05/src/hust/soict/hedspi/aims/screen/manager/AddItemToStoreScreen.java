package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStoreScreen extends JPanel {
    protected JTextField id;
    protected JTextField title;
    protected JTextField category;
    protected JTextField cost;
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        id = new JTextField();
        title = new JTextField();
        category = new JTextField();
        cost = new JTextField();
        
    
        add(createRow(" Id", id));
        add(createRow(" Title", title));
        add(createRow(" Category", category));
        add(createRow(" Cost", cost));
        
        addSpecificFields();
        JButton create = new JButton("Create");
        create.addActionListener(new CreateListener());
        add(create);
    }
    protected JPanel createRow(String label, JTextField textField) {
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(2, 1));
        
        container.add(new JLabel(label));
        container.add(textField);
        
        return container;
    }
    private class CreateListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		addMediaToStore();
    	}
    }
    protected abstract void addSpecificFields();
    protected abstract void addMediaToStore();
}