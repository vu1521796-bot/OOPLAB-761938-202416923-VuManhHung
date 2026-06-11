package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MediaPlaybackHelper {

    public static void openPlayDialog(Media media) {
        if (media == null || !(media instanceof Playable)) return;

        try {
            Stage playStage = new Stage();
            playStage.initModality(Modality.APPLICATION_MODAL);
            playStage.setResizable(false);
            Parent root = null;

            if (media instanceof CompactDisc) {
                playStage.setTitle("Play CD");
                String PATH = "/hust/soict/hedspi/aims/screen/customer/view/PlayCD.fxml";
                FXMLLoader loader = new FXMLLoader(MediaPlaybackHelper.class.getResource(PATH));
                loader.setController(new PlayCDController((CompactDisc) media));
                root = loader.load();
                
            } else if (media instanceof DigitalVideoDisc) {
                playStage.setTitle("Play DVD");
                String PATH = "/hust/soict/hedspi/aims/screen/customer/view/PlayDVD.fxml";
                FXMLLoader loader = new FXMLLoader(MediaPlaybackHelper.class.getResource(PATH));
                loader.setController(new PlayDVDController((DigitalVideoDisc) media));
                root = loader.load();
            }

            if (root != null) {
                playStage.setScene(new Scene(root));
                playStage.showAndWait();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}