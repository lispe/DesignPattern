package pattern.singleton;

public class Singleton {
	
	private static Singleton singleton = new Singleton();
	
	// privateのコンストラクタ
	private Singleton() {
		System.out.println("インスタンスを生成しました。");
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
}
