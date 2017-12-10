package pattern.iterator;

public class BookShelfIterator implements Iterator<Book> {

	private BookShelf bookShelf;
	private int index;
	
	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		if(this.bookShelf.getLength() > this.index) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Book next() {
		Book book = this.bookShelf.getBookAt(this.index);
		this.index++;
		return book;
	}

}
