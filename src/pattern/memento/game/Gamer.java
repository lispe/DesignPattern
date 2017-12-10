package pattern.memento.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
	private int money;
	private List<String> fruits = new ArrayList<String>();
	private Random random = new Random();
	private static String[] fruitsname = {"リンゴ", "ぶどう", "バナナ", "みかん"};
	
	public Gamer(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	/**
	 * ゲームメイン処理<br>
	 * サイコロの出た目によってゲームを進める。<br>
	 */
	public void bet() {
		
		int dice = random.nextInt(6) + 1;
		
		if(dice == 1) {
			money += 100;
			System.out.println("所持金が増えました。");
		} else if(dice == 2) {
			money /= 2;
			System.out.println("所持金が半分になりました。");
		} else if(dice == 6) {
			String f = getFruit();
			System.out.println("フルーツ(" + f + ")をもらいました。");
			fruits.add(f);
		} else {
			System.out.println("何も起こりませんでした。");
		}
	}
	
	/**
	 * 状態保存処理(snapshot)<br>
	 * 現在の{@code money}とフルーツの内"おいしい"もののみを保存した{@code Memento}インスタンスを生成し、<br>
	 * 戻り値として返却する。<br>
	 * @return 状態を保存した{@code Memento}インスタンス
	 */
	public Memento createMemento() {
		Memento m = new Memento(money);
		Iterator<String> it = fruits.iterator();
		while(it.hasNext()) {
			String f = it.next();
			if(f.startsWith("おいしい")) {
				m.addFruits(f);
			}
		}
		return m;
	}
	
	/**
	 * 状態復元処理(undo)<br>
	 * 引数で渡された{@code Memento}インスタンスの状態で当インスタンスを復元する。<br>
	 * @param memento 復元したい状態を保存した{@code Memento}インスタンス
	 */
	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}
	
	/**
	 * {@code Gamer}クラスの文字列表現<br>
	 * {@code money},{@code fruits}の設定値を出力する。<br>
	 */
	public String toString() {
		return "[money = " + money + ", fruits = " + fruits + "]";
	}
	
	private String getFruit() {
		String prefix = "";
		if(random.nextBoolean()) {
			prefix = "おいしい";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}
