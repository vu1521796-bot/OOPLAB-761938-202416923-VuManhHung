package hust.soict.hedspi.aims.media;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayList;
public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	public Book() {
		this.authors=new ArrayList<>();
	}
	public Book(String category,String title,float cost) {
		super(category,title,cost);
	}
	public List<String> getAuthors() {
		return authors;
	}
	/**
     * Thêm tác giả vào danh sách nếu chưa tồn tại.
     * @param authorName Tên tác giả cần thêm.
     */
	public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Đã thêm tác giả: " + authorName);
        } else {
            System.out.println("Lỗi: Tác giả '" + authorName + "' đã tồn tại.");
        }
    }
	/**
     * Xóa tác giả khỏi danh sách nếu tìm thấy.
     * @param authorName Tên tác giả cần xóa.
     */
 	public void removeAuthor(String authorName) {
    if (authors.contains(authorName)) {
        authors.remove(authorName);
        System.out.println("Đã xóa tác giả: " + authorName);
    } else {
        System.out.println("Lỗi: Không tìm thấy tác giả '" + authorName + "' để xóa.");
    }
}

}
