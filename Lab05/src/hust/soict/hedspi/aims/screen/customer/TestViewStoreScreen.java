package hust.soict.hedspi.aims.screen.customer;

import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static Store store;
	private static Cart cart;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader. load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
	    store = new Store();
	    cart = new Cart();

	    // ===================== BOOKS =====================
	    Book book1 = new Book(1, "Java Programming Fundamentals", "Programming", 15.5f);
	    book1.addAuthor("John Doe");

	    Book book2 = new Book(2, "Harry Potter and the Sorcerer's Stone", "Fantasy", 12.0f);
	    book2.addAuthor("J.K. Rowling");

	    Book book3 = new Book(3, "The Da Vinci Code", "Mystery", 10.0f);
	    book3.addAuthor("Dan Brown");

	    // ===================== DVDS =====================
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc(
	            4,
	            "The Dark Knight",
	            "Action",
	            "Christopher Nolan",
	            152,
	            20.0f
	    );

	    DigitalVideoDisc dvd2 = new DigitalVideoDisc(
	            5,
	            "Inception",
	            "Sci-Fi",
	            "Christopher Nolan",
	            148,
	            18.5f
	    );

	    DigitalVideoDisc dvd3 = new DigitalVideoDisc(
	            6,
	            "Frozen",
	            "Animation",
	            "Chris Buck",
	            102,
	            14.0f
	    );

	    // ===================== CDS =====================
	    CompactDisc cd1 = new CompactDisc(
	            7,
	            "Rock Legends",
	            "Music",
	            "Michael Brown",
	            9.5f,
	            "The Beatles"
	    );
	    cd1.addTrack(new Track("Hey Jude", 7));
	    cd1.addTrack(new Track("Let It Be", 4));

	    CompactDisc cd2 = new CompactDisc(
	            8,
	            "Pop Stars",
	            "Pop",
	            "David Lee",
	            8.0f,
	            "Ariana Grande"
	    );
	    cd2.addTrack(new Track("7 Rings", 3));
	    cd2.addTrack(new Track("Positions", 4));

	    CompactDisc cd3 = new CompactDisc(
	            9,
	            "Classical Masterpieces",
	            "Classical",
	            "Wolfgang Mozart",
	            11.0f,
	            "Ludwig van Beethoven"
	    );
	    cd3.addTrack(new Track("Moonlight Sonata", 6));
	    cd3.addTrack(new Track("Ode to Joy", 5));

	    // ===================== ADD TO STORE =====================
	    store.addMedia(book1);
	    store.addMedia(book2);
	    store.addMedia(book3);

	    store.addMedia(dvd1);
	    store.addMedia(dvd2);
	    store.addMedia(dvd3);

	    store.addMedia(cd1);
	    store.addMedia(cd2);
	    store.addMedia(cd3);

	    launch(args);
	}
}