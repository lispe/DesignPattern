package pattern.singleton;

// 練習問題5-1
public class TicketMaker {
	private static TicketMaker ticketMaker = new TicketMaker();
	private int ticket = 1000;
	
	private TicketMaker() {
	}
	
	public static TicketMaker getInstance() {
		return ticketMaker;
	}
	
	// マルチスレッド対応のためsynchronized修飾子を付加
	public synchronized int getNextTicketNumber() {
		return ticket++;
	}
}
