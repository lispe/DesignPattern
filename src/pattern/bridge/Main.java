package pattern.bridge;

public class Main {

	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImpl("Hello,Japan."));
		CountDisplay d2 = new CountDisplay(new StringDisplayImpl("Hello,World."));
		//d1.display();
		//d2.multiDisplay(2);
		
		//RandomCountDisplay d3 = new RandomCountDisplay(new StringDisplayImpl("Hello,World."));
		//d3.randomDisplay(10);
		//d1 = new Display(new TextDisplayImpl("infiles/test.txt"));
		//d1.display();
		//d2 = new CountDisplay(new TextDisplayImpl("infiles/test.txt"));
		//d2.multiDisplay(3);
		
		IncreaseDisplay id = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'),1);
		id.incrDisplay(6);
		
	}
}
