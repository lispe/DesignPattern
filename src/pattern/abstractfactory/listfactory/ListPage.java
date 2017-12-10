package pattern.abstractfactory.listfactory;

import pattern.abstractfactory.factory.Page;

public class ListPage extends Page {

	public ListPage(String title, String author) {
		super(title, author);
	}

	@Override
	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		final String br = "\n";
		
		buffer.append("<html><head><meta charset=\"UTF-8\"><title>");
		buffer.append(this.title);
		buffer.append("</title></head>");
		buffer.append("<body>");
		buffer.append(br);
		buffer.append("<h1>");
		buffer.append(title);
		buffer.append("</h1>");
		
		buffer.append("<ul>");
		buffer.append(br);
		
		for(int i = 0; i < this.content.size(); i++) {
			buffer.append("<li>");
			buffer.append(br);
			buffer.append(this.content.get(i).makeHTML());
			buffer.append(br);
			buffer.append("</li>");
			buffer.append(br);
		}
		buffer.append("</ul>");
		buffer.append(br);
		
		buffer.append("<hr><address>");
		buffer.append(this.author);
		buffer.append("</address></body></html>");

		return buffer.toString();
	}

}
