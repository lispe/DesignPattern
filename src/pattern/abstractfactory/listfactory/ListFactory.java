package pattern.abstractfactory.listfactory;

import pattern.abstractfactory.factory.Factory;
import pattern.abstractfactory.factory.Link;
import pattern.abstractfactory.factory.Page;
import pattern.abstractfactory.factory.Tray;

public class ListFactory extends Factory {

	@Override
	public Link createLink(String caption, String url) {
		return new ListLink(caption, url);
	}

	@Override
	public Tray createTray(String caption) {
		return new ListTray(caption);
	}

	@Override
	public Page createPage(String title, String author) {
		return new ListPage(title, author);
	}

}
