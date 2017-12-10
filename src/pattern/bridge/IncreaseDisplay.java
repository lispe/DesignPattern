package pattern.bridge;

public class IncreaseDisplay extends CountDisplay {

	private int step;
	
	public IncreaseDisplay(DisplayImpl impl, int step) {
		super(impl);
		this.step = step;
	}
	
	public void incrDisplay(int level) {
		int times = 0;
		for(int i = 0; i < level; i++) {
			multiDisplay(times);
			times+=step;
		}
	}

}
