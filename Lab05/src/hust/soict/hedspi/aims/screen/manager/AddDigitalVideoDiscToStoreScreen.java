package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
	private JTextField director;
	private JTextField length;
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
	}
	@Override
	protected void addSpecificFields() {
		director = new JTextField();
        length = new JTextField();
        
        add(createRow(" Director", director));
        add(createRow(" Length", length));
	}
	@Override
    protected void addMediaToStore() {
		DigitalVideoDisc dvd = new DigitalVideoDisc(Integer.parseInt(id.getText()), title.getText(), category.getText(), director.getText(), Integer.parseInt(length.getText()), Float.parseFloat(cost.getText()));

		store.addMedia(dvd);
    }
}