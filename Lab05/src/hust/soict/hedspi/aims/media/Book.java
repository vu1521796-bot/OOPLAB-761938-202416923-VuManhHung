package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("Author already exist");
		}
		else {
			authors.add(authorName);
			System.out.println("Author is added successfully");
		}
	}
	public void removeAuthor(String authorName) {
		if (authors.remove(authorName)) {
            System.out.println("Author is removed successfully");
        } 
		else {
            System.out.println("Author not found");
        }
	}
	@Override
    public String toString() {
        String result = String.format("Book - %s - %s: %.2f $\n",
                getTitle(),
                getCategory(),
                getCost());

        result += "Authors:\n";

        if (authors.isEmpty()) {
            result += "No authors available\n";
        } else {
            for (String author : authors) {
                result += "- " + author + "\n";
            }
        }

        return result;
    }

}
