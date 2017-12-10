package pattern.strategy;

public class Main {

	public static void main(String[] args) {
		int seed1 = 7;
		int seed2 = 49;
		Player player1 = new Player("Taro", new WinningStrategy(seed1));
		Player player2 = new Player("Hana", new ProbStrategy(seed2));
		for(int i = 0; i < 10000; i++) {
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();
			if(nextHand1.isStrongerThan(nextHand2)) {
				player1.win();
				player2.lose();
			} else if(nextHand2.isStrongerThan(nextHand1)) {
				player1.lose();
				player2.win();
			} else {
				player1.even();
				player2.even();
			}
		}
		System.out.println("Total result:");
		System.out.println(player1.toString());
		System.out.println(player2.toString());
	}

}
