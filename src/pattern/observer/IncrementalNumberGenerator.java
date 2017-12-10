package pattern.observer;

public class IncrementalNumberGenerator extends NumberGenerator {

	private int start;
	private int end;
	private int increase;
	private int number;
	
	public IncrementalNumberGenerator(int start, int end, int increase) {
		this.start = start;
		this.end = end;
		this.increase = increase;
	}
	
	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void execute() {
		for(int i = start; i < end; i += increase) {
			number = i;
			notifyObservers();
		}
	}

}
