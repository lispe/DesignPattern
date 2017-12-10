package pattern.bridge;

import java.util.Random;

public class RandomCountDisplay extends CountDisplay {

	Random random = new Random();
	
	public RandomCountDisplay(DisplayImpl impl) {
		super(impl);
	}
	
	/**
	 * 0以上、指定回数未満だけランダムに表示する。
	 * @param times 指定回数
	 */
	public void randomDisplay(int times) {
		multiDisplay(random.nextInt(times));
	}

}
