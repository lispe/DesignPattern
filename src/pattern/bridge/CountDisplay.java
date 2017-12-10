package pattern.bridge;

public class CountDisplay extends Display {

	public CountDisplay(DisplayImpl impl) {
		super(impl);
	}
	
	/**
	 * スーパークラスのメソッドdisplayの拡張メソッド<br>
	 * 引数で指定した回数分表示する。
	 * @param times 表示回数
	 */
	public void multiDisplay(int times) {
		open();
		for(int i = 0; i < times; i++) {
			print();
		}
		close();
	}

}
