package pattern.chainofresponsibility;

/**
 * トラブルを解決する連鎖を作る抽象クラス。
 */
public abstract class Support {
	private String name;
	private Support next;
	
	public Support(String name) {
		this.name = name;
	}
	
	public Support setNext(Support next) {
		this.next = next;
		return next;
	}
	
	/**
	 * トラブルの解決を行う。<br>
	 * 自身のクラスでは解決不可の場合は、次の{@code Support}クラスを呼び出して解決する。
	 * @param trouble 解決対象のトラブル
	 */
	public final void support(Trouble trouble) {
//		if(resolve(trouble)) {
//			done(trouble);
//		} else if(next != null) {
//			next.support(trouble);
//		} else {
//			fail(trouble);
//		}
		
		// ループに置き換えた処理
		for(Support sup = this; true; sup = sup.next) {
			if (sup.resolve(trouble)) {
				sup.done(trouble);
				break;
			} else if (sup.next == null){
				sup.fail(trouble);
				break;
			}
		}
		
		
	}
	
	public String toString() {
		return "[" + name + "]";
	}
	
	protected abstract boolean resolve(Trouble trouble);
	
	/**
	 * トラブル解決の文言を表示する。
	 * @param trouble 解決対象のトラブル
	 */
	protected void done(Trouble trouble) {
		System.out.println(trouble + " is resolved by " + this + ".");
	}
	
	/**
	 * トラブル未解決の文言を表示する。
	 * @param trouble 解決対象のトラブル
	 */
	protected void fail(Trouble trouble) {
		System.out.println(trouble + " cannot be resolved.");
	}
}
