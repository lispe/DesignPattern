package pattern.abstractfactory.listfactory;

import pattern.abstractfactory.factory.Tray;

public class ListTray extends Tray {

	public ListTray(String caption) {
		super(caption);
	}

	@Override
	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		final String br = "\n"; // 改行
		
		buffer.append(this.caption);
		buffer.append(br);
		buffer.append("<ul>");
		for(int i = 0; i < this.tray.size(); i++) {
			buffer.append("<li>");
			buffer.append(tray.get(i).makeHTML());
			buffer.append("</li>");
			buffer.append(br);
		}
		buffer.append("</ul>");
		
		return buffer.toString();
	}

}
