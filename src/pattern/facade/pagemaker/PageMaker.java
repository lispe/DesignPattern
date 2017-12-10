package pattern.facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PageMaker {
	
	private PageMaker() {
	}
	
	/**
	 * WelcomePageのHTMLファイルを生成するFacadeクラスのメソッド
	 * @param mailaddr ページにリンクするメールアドレス
	 * @param filename 生成するHTMLファイル名
	 */
	public static void makeWelcomePage(String mailaddr, String filename) {
		try {
			Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("Welcome to " + username + "'s page!");
			writer.paragraph(username + "のページへようこそ。");
			writer.paragraph("メールまってますね。");
			writer.mailto(mailaddr, username);
			writer.close();
			System.out.println(filename + " is created of " + mailaddr + " (" + username + ")");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void makeLinkPage(String filename) {
		try {
			Properties mailprop = Database.getProperties("maildata");
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("Link page");
			
			// メールアドレスを全件分のリンクを生成する
			Set<String> keySet = mailprop.stringPropertyNames();
			for(String key : keySet) {
				String username = mailprop.getProperty(key);
				writer.mailto(key, username);
			}
			
			writer.close();
			System.out.println(filename + " is created.");
			
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		
	}
}
