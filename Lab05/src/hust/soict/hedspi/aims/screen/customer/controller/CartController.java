package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {

    @FXML 
    private Button btnPlay;
    @FXML 
    private Button btnRemove;
    @FXML 
    private TableColumn<Media, String> colMediaCategory;
    @FXML 
    private TableColumn<Media, Float> colMediaCost;
    @FXML 
    private TableColumn<Media, Integer> colMediaId;
    @FXML 
    private TableColumn<Media, String> colMediaTitle;
    @FXML 
    private Label costLabel;
    @FXML 
    private ToggleGroup filterCategory;
    @FXML 
    private TableView<Media> tblMedia;
    @FXML 
    private RadioButton radioBtnFilterId;
    @FXML 
    private RadioButton radioBtnFilterTitle;
    @FXML 
    private TextField tfFilter;
    
    private Cart cart;
    private Store store;
    private FilteredList<Media> filteredList;

    public CartController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        
        if (cart.getItemsOrdered() != null) {
            filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
            tblMedia.setItems(filteredList);
        }
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateButtonBar(newValue);
        });
        
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia(newValue));
        
        filterCategory.selectedToggleProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia(tfFilter.getText()));
        
        updateTotalCost();
    }
    
    void updateButtonBar(Media media) {
        boolean isPlayable = media instanceof Playable;
        btnPlay.setVisible(isPlayable);
        btnRemove.setVisible(media != null);
    }
    
    void showFilteredMedia(String keyword) {
        if (filteredList == null) return;

        if (keyword == null || keyword.trim().isEmpty()) {
            filteredList.setPredicate(media -> true);
            return;
        }
        String lowerCaseFilter = keyword.toLowerCase().trim();

        filteredList.setPredicate(media -> {
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            } else if (radioBtnFilterTitle.isSelected() && media.getTitle() != null) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return false; 
        });
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        MediaPlaybackHelper.openPlayDialog(selectedMedia);
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
        }
        updateTotalCost();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        switchScene("/hust/soict/globalict/aims/screen/customer/view/Store.fxml", "Store", event);
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered() == null || cart.getItemsOrdered().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Notification", "Your cart is empty! Please add items first.");
            return;
        }
        
        showAlert(Alert.AlertType.INFORMATION, "Order Success", "An order has been created successfully!");
        cart.getItemsOrdered().clear();
        updateTotalCost();
    }
    
    private void updateTotalCost() {
        this.costLabel.setText(cart.totalCost() + " $");
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void switchScene(String fxmlPath, String title, ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}