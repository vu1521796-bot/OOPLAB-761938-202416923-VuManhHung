package hust.soict.hedspi.aims.exception;

// Đổi từ Exception thành RuntimeException
public class PlayerException extends RuntimeException { 
    public PlayerException() {
        super();
    }

    public PlayerException(String message) {
        super(message);
    }
}