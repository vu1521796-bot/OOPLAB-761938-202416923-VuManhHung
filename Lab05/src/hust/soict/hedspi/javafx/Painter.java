package hust.soict.hedspi.javafx;

// Các dòng import và code của bạn nằm ở dưới này...
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Tải giao diện từ file FXML
        Parent root = FXMLLoader.load(getClass().getResource("Painter.fxml"));
        
        // Tạo Scene chứa giao diện
        Scene scene = new Scene(root);
        
        // Thiết lập cửa sổ (Stage)
        stage.setTitle("My Painter App");
        stage.setScene(scene);
        stage.setResizable(false); // Ngăn thay đổi kích thước cửa sổ để Canvas không bị lệch
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // Khởi chạy ứng dụng JavaFX
    }
}