package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
	public AddBookToStoreScreen(Store store) {
		super(store);
	}
	@Override
	protected void addSpecificFields() {
		
	}
	@Override
    protected void addMediaToStore() {
    	Book book = new Book(Integer.parseInt(id.getText()), title.getText(), category.getText(), Float.parseFloat(cost.getText()));
    	store.addMedia(book);
    }
}