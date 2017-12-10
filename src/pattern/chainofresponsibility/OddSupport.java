package pattern.chainofresponsibility;

/**
 * {@code Support}クラスのサブクラス。<br>
 * 奇数番号のトラブルを処理するクラス。
 */
public class OddSupport extends Support {
	
	public OddSupport(String name) {
		super(name);
	}
	
	@Override
	protected boolean resolve(Trouble trouble) {
		if ((trouble.getNumber() % 2) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
