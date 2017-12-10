package pattern.abstractfactory.listfactory;

import pattern.abstractfactory.factory.Link;

public class ListLink extends Link {

	public ListLink(String caption, String url) {
		super(caption, url);
	}

	@Override
	public String makeHTML() {
		return "<a href=\"" + this.url + "\">" + this.caption + "</a>";
	}

}
