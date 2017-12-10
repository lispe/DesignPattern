package pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate<Book> {

	private List<Book> books;
	private int last = 0;
	
	public BookShelf() {
		books = new ArrayList<Book>();
	}

	@Override
	public Iterator<Book> iterator() {
		return new BookShelfIterator(this);
	}
	
	public Book getBookAt(int index) {
		return this.books.get(index);
	}
	
	public void appendBook(Book book) {
		this.books.add(book);
		last++;
	}

	public int getLength() {
		return this.last;
	}
}
