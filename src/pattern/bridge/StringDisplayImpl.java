package pattern.bridge;

public class StringDisplayImpl extends DisplayImpl {

	private String dispStr;	// 表示する文字列
	private int width;		// バイト単位で計算した文字列の「幅」
	
	public StringDisplayImpl(String dispStr) {
		this.dispStr = dispStr;
		this.width = dispStr.getBytes().length;
	}
	
	@Override
	public void rawOpen() {
		printLine();
	}

	@Override
	public void rawPrint() {
		System.out.println("|" + this.dispStr + "|");
	}

	@Override
	public void rawClose() {
		printLine();
	}
	
	private void printLine() {
		System.out.print("+");
		for(int i = 0; i < this.width; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}

}
