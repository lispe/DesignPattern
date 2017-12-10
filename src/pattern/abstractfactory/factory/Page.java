package pattern.abstractfactory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public abstract class Page {
	protected String title;
	protected String author;
	protected List<Item> content = new ArrayList<Item>();
	private PrintWriter writer;
	
	public Page(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public void add(Item item) {
		this.content.add(item);
	}
	
	public void output() {
		try {
			String filename = title + ".html";
			Writer writer = new FileWriter(filename);
			writer.write(this.makeHTML());
			System.out.println(filename + "が作成されました。");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public abstract String makeHTML();
}
