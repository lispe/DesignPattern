package pattern.templateMethod;

public class CharDisplay extends AbstractDisplay {

	private char ch;
	
	public CharDisplay(char ch) {
		this.ch = ch;
	}
	
	/**
	 * 文字列"<<"を表示する。
	 */
	@Override
	public void open() {
		System.out.print("<<");
	}
	
	/**
	 * コンストラクタで与えられていた1文字を表示する。
	 */
	@Override
	public void print() {
		System.out.print(ch);
	}
	
	/**
	 * 文字列">>"を表示する。
	 */
	@Override
	public void close() {
		System.out.println(">>");
	}

}
