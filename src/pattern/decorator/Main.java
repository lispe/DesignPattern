package pattern.decorator;

import java.io.UnsupportedEncodingException;

public class Main {
	public static void main(String[] args) {
		MultiStringDisplay b1 = new MultiStringDisplay();
		b1.add("Hello.");
		b1.add("Nice to meet you.");
		b1.add("Thank you. Good bye.");
		b1.show();
		
		Display b2 = new SideBorder(b1,'#');
		b2.show();
		
		try {
			System.out.println("おはよう  ".getBytes().length);
			System.out.println("おはよう".getBytes("sjis").length);
			
			System.out.println(String.format("%-6s", "おはよう").getBytes("sjis").length);
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}
}
