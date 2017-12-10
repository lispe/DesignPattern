package pattern.adapter;

import java.io.IOException;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
//		// Adapterパターン(継承を使ったもの)
//		System.out.println("***継承を使ったのも***");
//		PrintInterface p = new PrintBannerInherit("Hello");
//		p.printWeak();
//		p.printStrong();
//		
//		// Adapterパターン(委譲を使ったもの)
//		System.out.println("***委譲を使ったのも***");
//		PrintClass pc = new PrintBannerDelegate("Hello");
//		pc.PrintWeak();
//		pc.PrintStrong();
		
		// 練習問題
		FileIO f = new FileProperties();
		try {
			f.readFromFile("file.txt");
			check(f);
			f.setValue("year", "2004");
			f.setValue("month", "4");
			f.setValue("day", "21");
			f.writeToFile("newfile.txt");
			f.readFromFile("newfile.txt");
			check(f);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}
	public static void check(FileIO f) {
		System.out.println("year=" + f.getValue("year"));
		System.out.println("month=" + f.getValue("month"));
		System.out.println("day=" + f.getValue("day"));
	}

}
