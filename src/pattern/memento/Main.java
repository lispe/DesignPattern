package pattern.memento;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pattern.memento.game.Gamer;
import pattern.memento.game.Memento;

public class Main {
	private static final String GAME_DAT_FILE = "./infiles/Memento/game.dat";

	public static void main(String[] args) {
		Gamer gamer = new Gamer(100);				// 初期値設定
//		Memento memento = gamer.createMemento();
		Memento memento = null;
		try {
			// 保存ファイルの読み込み
			memento = readMemento();
			
			System.out.println("前回保存した結果からスタートします。");
			gamer.restoreMemento(memento);
			
		} catch (FileNotFoundException e1) {
			System.out.println("新規にスタートします。");
			memento = gamer.createMemento();
			
		}
		
		for (int i = 0; i < 20; i++) {
			System.out.println("====" + i);
			System.out.println("現状:" + gamer);
			
			gamer.bet();
			
			System.out.println("所持金は" + gamer.getMoney() + "円になりました。");
			
			if (gamer.getMoney() > memento.getMoney()) {
				System.out.println("    (だいぶ増えたので、現在の状態を保存しておこう)");
				memento = gamer.createMemento();
				writeMemento(memento);
			} else if (gamer.getMoney() < memento.getMoney()) {
				System.out.println("    (だいぶ減ったので、以前の状態に復帰しよう)");
				gamer.restoreMemento(memento);
				
			}
			
			// 時間待ち
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("");
		}
	}
	
	/**
	 * {@code game.dat}ファイル読込処理<br>
	 * 保存されている{@code game.dat}ファイルを読込み、{@code Memento}インスタンスを復元し返却する。<br>
	 * @return 復元された{@code Memento}インスタンス
	 * @throws FileNotFoundException {@code game.dat}ファイルが存在しない場合にthrowされる。
	 */
	private static Memento readMemento() throws FileNotFoundException {
		Memento memento = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(GAME_DAT_FILE));
			memento = (Memento) in.readObject();
			in.close();
			
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return memento;
	}
	
	/**
	 * {@code game.dat}ファイル書込処理<br>
	 * 引数で渡された{@code Memento}インスタンスを{@code game.dat}ファイルに書き込んで保存する。<br>
	 * @param memento 保存する{@code Memento}インスタンス
	 */
	private static void writeMemento(Memento memento) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(GAME_DAT_FILE));
			out.writeObject(memento);
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
