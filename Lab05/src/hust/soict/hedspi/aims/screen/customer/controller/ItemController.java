package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.exception.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ItemController {

    @FXML 
    private Button btnAddToCart;
    @FXML 
    private Button btnPlay;
    @FXML 
    private Label lblCost;
    @FXML 
    private Label lblTitle;
    
    private Media media;
    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        boolean isPlayable = media instanceof Playable;
        btnPlay.setVisible(isPlayable);
        btnPlay.setManaged(isPlayable);
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (this.media != null) {
            try {
            	this.cart.addMedia(media);
            }
            catch(LimitExceededException e) {
            	e.getStackTrace();
            }
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        MediaPlaybackHelper.openPlayDialog(media);
    }
}