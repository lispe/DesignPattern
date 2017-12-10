package pattern.abstractfactory;

import pattern.abstractfactory.factory.Factory;
import pattern.abstractfactory.factory.Page;
import pattern.abstractfactory.factory.Tray;

public class Main {

	public static void main(String[] args) {
		String classname = "pattern.abstractfactory.listfactory.ListFactory";
		Factory factory = Factory.getFactory(classname);
		
		
		
		// 新聞コンテンツ
		Tray trayNewspaper = factory.createTray("新聞");
		trayNewspaper.add(factory.createLink("朝日新聞", "http://www.asahi.com/"));
		trayNewspaper.add(factory.createLink("読売新聞", "http://www.yomiuri.co.jp/"));

		Tray trayYahoo = factory.createTray("Yahoo!");
		trayYahoo.add(factory.createLink("Yahoo!", "https://www.yahoo.com/"));
		trayYahoo.add(factory.createLink("Yahoo!Japan", "https://www.yahoo.co.jp/"));
		
		// サーチエンジンコンテンツ
		Tray traySrchengn = factory.createTray("サーチエンジン");
		traySrchengn.add(trayYahoo);
		traySrchengn.add(factory.createLink("Excite", "http://www.excite.co.jp/"));
		traySrchengn.add(factory.createLink("Google", "https://www.google.co.jp/"));
		
		Page page = factory.createPage("LinkPage", "山田太郎");
		page.add(trayNewspaper);
		page.add(traySrchengn);
		page.output();
	}

}
