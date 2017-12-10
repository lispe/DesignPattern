package pattern.observer;

public class Main {

	public static void main(String[] args) {
		//NumberGenerator generator = new RandomNumberGenerator();
		NumberGenerator generator = new IncrementalNumberGenerator(10, 51, 3);
		Observer obs1 = new DigitObserver();
		Observer obs2 = new GraphObserver();
		
		generator.addObserver(obs1);
		generator.addObserver(obs2);
		
		generator.execute();
		
	}

}
