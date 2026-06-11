package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayCDController {
    @FXML 
    private Label lblHeaderTitle;
    @FXML 
    private Label lblHeaderDetail;
    @FXML 
    private ScrollPane scrollPane;
    @FXML 
    private VBox tracksContainer;

    private CompactDisc cd;

    public PlayCDController(CompactDisc cd) {
        this.cd = cd;
    }

    @FXML
    public void initialize() {
        lblHeaderTitle.setFont(Font.font("System", FontWeight.BOLD, 16));
        lblHeaderDetail.setFont(Font.font("System", 14));

        if (cd.getLength() > 0) {
            lblHeaderTitle.setText("Playing CD: " + cd.getTitle());
            lblHeaderTitle.setTextFill(Color.web("#004cff"));
            lblHeaderDetail.setText("CD Length: " + cd.getLength());
            scrollPane.setVisible(true);
            for (Track track : cd.getTracks()) {
                VBox cell = new VBox(5);
                cell.setPadding(new Insets(10));
                Label lblTrackTitle = new Label("Playing track: " + track.getTitle());
                lblTrackTitle.setFont(Font.font("System", FontWeight.BOLD, 14));
                Label lblTrackLen = new Label("Track length: " + track.getLength());
                
                cell.getChildren().addAll(lblTrackTitle, lblTrackLen);
                tracksContainer.getChildren().add(cell);
            }
        } else {
            lblHeaderTitle.setText("The CD cannot be played!");
            lblHeaderTitle.setTextFill(Color.RED);
            lblHeaderDetail.setText("Since there exist track that its length smaller than or equal to 0");
            scrollPane.setVisible(false);
        }
    }
}