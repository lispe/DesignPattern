package pattern.flyweight;

public class Main {

	public static void main(String[] args) {
		
		long used;
		
		BigString bs1 = new BigString("0101010101",true);
		Runtime.getRuntime().gc();
		used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("共有あり 使用メモリ = " + used);
		
		BigString bs2 = new BigString("0101010101",false);
		Runtime.getRuntime().gc();
		used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("共有なし 使用メモリ = " + used);
	}

}
