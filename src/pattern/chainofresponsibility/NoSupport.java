package pattern.chainofresponsibility;

/**
 * {@code Support}クラスのサブクラス。<br>
 * このクラスはトラブルの処理を行わない({@code resolve}メソッドは常に{@code false}を返す)。
 */
public class NoSupport extends Support {
	
	public NoSupport(String name) {
		super(name);
	}
	
	@Override
	protected boolean resolve(Trouble trouble) {
		return false;
	}

}
