package pattern.chainofresponsibility;

/**
 * {@code Support}クラスのサブクラス。<br>
 * コンストラクタの{@code number}で指定した番号のトラブルを処理するクラス。
 */
public class SpecialSupport extends Support {
	private int number;
	
	public SpecialSupport(String name, int number) {
		super(name);
		this.number = number;
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() == number) {
			return true;
		} else {
			return false;
		}
	}

}
