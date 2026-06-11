package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
	private JTextField director;
	private JTextField artist;
	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
	}
	@Override
	protected void addSpecificFields() {
		director = new JTextField();
        artist = new JTextField();
        
        add(createRow(" Director", director));
        add(createRow(" Artist", artist));
	}
	@Override
    protected void addMediaToStore() {
		CompactDisc cd = new CompactDisc(Integer.parseInt(id.getText()), title.getText(), category.getText(), director.getText(), Float.parseFloat(cost.getText()), artist.getText());

		store.addMedia(cd);
    }
}