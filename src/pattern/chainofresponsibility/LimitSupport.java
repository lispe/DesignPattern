package pattern.chainofresponsibility;

/**
 * {@code Support}クラスのサブクラス。<br>
 * コンストラクタの{@code limit}で指定した番号未満のトラブルを処理するクラス。
 */
public class LimitSupport extends Support {
	private int limit;
	
	public LimitSupport(String name, int limit) {
		super(name);
		this.limit = limit;
	}
	
	@Override
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() < limit) {
			return true;
		} else {
			return false;
		}
	}

}
