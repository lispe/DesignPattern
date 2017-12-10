package pattern.templateMethod;

public class StringDisplay extends AbstractDisplay {

	private String str;
	private int width;
	public StringDisplay(String str) {
		this.str = str;
		this.width = str.getBytes().length;
	}
	/**
	 * 文字列"+----+"を表示する。
	 */
	@Override
	public void open() {
		printLine();
	}

	/**
	 * コンストラクタで与えられていた文字列を"|"と"|"ではさんで表示する。
	 */
	@Override
	public void print() {
		System.out.println("|" + str + "|");
	}

	/**
	 * 文字列"+----+"を表示する。
	 */
	@Override
	public void close() {
		printLine();
	}
	
	/**
	 * コンストラクタで与えられた文字列の長さに合わせて"+----+"を表示する。
	 */
	private void printLine() {
		System.out.print("+");
		for(int i = 0; i < width; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}

}
