package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayDVDController {
    @FXML 
    private Label lblHeaderTitle;
    @FXML 
    private Label lblHeaderDetail;

    private DigitalVideoDisc dvd;

    public PlayDVDController(DigitalVideoDisc dvd) {
        this.dvd = dvd;
    }

    @FXML
    public void initialize() {
        lblHeaderTitle.setFont(Font.font("System", FontWeight.BOLD, 16));
        lblHeaderDetail.setFont(Font.font("System", 14));

        if (dvd.getLength() > 0) {
            lblHeaderTitle.setText("Playing DVD: " + dvd.getTitle());
            lblHeaderTitle.setTextFill(Color.web("#004cff"));
            lblHeaderDetail.setText("DVD Length: " + dvd.getLength());
        } else {
            lblHeaderTitle.setText("The DVD cannot be played!");
            lblHeaderTitle.setTextFill(Color.RED);
            lblHeaderDetail.setText("Since the length of this DVD is smaller than or equal to 0");
        }
    }
}