package pattern.iterator;

public class Main {


	public static void main(String[] args) {
		int bookCnt = 3;
		BookShelf bookShelf = new BookShelf();
		bookShelf.appendBook(new Book("Java言語で学ぶデザインパターン入門"));
		bookShelf.appendBook(new Book("良いコードを書く技術"));
		bookShelf.appendBook(new Book("良いコードを書く技術"));
		bookShelf.appendBook(new Book("良いコードを書く技術"));
		bookShelf.appendBook(new Book("良いコードを書く技術"));
		bookShelf.appendBook(new Book("良いコードを書く技術"));
		bookShelf.appendBook(new Book("良いコードを書く技術"));
		bookShelf.appendBook(new Book("良いコードを書く技術"));
		
		Iterator<Book> it = bookShelf.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());
		}

	}
}
