package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    // Liên kết với cái Pane có id là drawingAreaPane bên file FXML
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private javafx.scene.control.RadioButton eraserRadioButton;

    // Hàm xử lý khi bấm nút Clear
    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Xóa toàn bộ các hình (children) đang có trong vùng vẽ
        drawingAreaPane.getChildren().clear();
    }

    // Hàm xử lý khi kéo chuột trên vùng vẽ
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        // Kiểm tra chuột không bị kéo ra ngoài giới hạn vùng vẽ
        if (x >= 0 && x <= drawingAreaPane.getWidth() && 
            y >= 0 && y <= drawingAreaPane.getHeight()) {
            
            // Màu mực mặc định ban đầu là Đen (Pen)
            Color inkColor = Color.BLACK;
            
            // Nếu RadioButton Eraser đang được tích chọn, đổi màu mực sang Trắng
            if (eraserRadioButton.isSelected()) {
                inkColor = Color.WHITE;
            }
            
            // Tạo hình tròn với màu mực đã được quyết định ở trên
            Circle newCircle = new Circle(x, y, 4, inkColor);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}