package pattern.memento.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * {@code money}フィールド,{@code fruits}リストを保持する{@code Memento}クラス
 */
@SuppressWarnings("serial")
public class Memento implements Serializable {
	// フィールドはデフォルト修飾子とし、同一パッケージ内からのみアクセス可能とする。
	int money;
	ArrayList<String> fruits;
	
	/**
	 * {@code Memento}クラスのコンストラクタ<br>
	 * デフォルト修飾子とし、同一パッケージ内からのみインスタンス生成が可能
	 * @param money
	 */
	Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList<String>();
	}
	
	
	/**
	 * {@code money}取得処理<br>
	 * {@code money}フィールドを取得するgetterメソッド<br>
	 * ※ 他クラスに公開されたインターフェース(narrow interface)
	 * @return {@code money}フィールド
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * フルーツ追加処理<br>
	 * 引数で渡された{@code fruit}をインスタンスが保持する{@code fruitrs}リストに{@code add}する。<br>
	 * ※ 同一パッケージ内からのみアクセス可能(wide interface)
	 * @param fruit 追加するフルーツ
	 */
	void addFruits(String fruit) {
		fruits.add(fruit);
	}
	
	/**
	 * {@code fruits}取得処理<br>
	 * {@code fruits}リストを取得するgetterメソッド<br>
	 * ※ 同一パッケージ内からのみアクセス可能(wide interface)
	 * @return {@code fruits}リストの{@code clone}
	 */
	@SuppressWarnings("unchecked")
	List<String> getFruits() {
		return (List<String>)fruits.clone();
	}
}
