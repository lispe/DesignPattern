package pattern.singleton;

public class SingletonMain {
	public static void main(String[] args) {
		System.out.println("Start.");
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		if(obj1 == obj2) {
			System.out.println("obj1とobj2は同じインスタンスです。");
		} else {
			System.out.println("obj1とobj2は同じインスタンスではありません。");
		}
		System.out.println("End.");
		
		// 練習問題5-1
		TicketMaker tMaker1 = TicketMaker.getInstance();
		System.out.println(tMaker1.getNextTicketNumber());
		System.out.println(tMaker1.getNextTicketNumber());
		
		TicketMaker tMaker2 = TicketMaker.getInstance();
		System.out.println(tMaker2.getNextTicketNumber());
		System.out.println(tMaker1.getNextTicketNumber());
		
		if(tMaker1 == tMaker2) {
			System.out.println("一致");
		}
		
		// 練習問題5-2
		Triple tripleA = Triple.getInstance(0);
		Triple tripleB = Triple.getInstance(1);
		Triple tripleC = Triple.getInstance(2);
		Triple tripleD = Triple.getInstance(3);
		
		if(tripleA == tripleD) {
			System.out.println("triple0とtriple3は同じインスタンスです。");
		} else {
			System.out.println("triple0とtriple3は同じインスタンではありません。");
		}
		if(tripleA == tripleB) {
			System.out.println("triple0とtriple1は同じインスタンスです。");
		} else {
			System.out.println("triple0とtriple1は同じインスタンではありません。");
		}
	}

}
