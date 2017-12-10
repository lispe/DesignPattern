package pattern.singleton;

public class Triple {
	// 3個のインスタンス
	private static Triple triple[] = {
		new Triple(0),
		new Triple(1),
		new Triple(2)
		};
	private int id;
	private Triple(int id) {
		this.id = id;
		System.out.println("インスタンス生成:(id=" + id + ")");
	}
	
	public static Triple getInstance(int id) throws IllegalArgumentException {
		Triple retObj = null;
		for(int i = 0; i < triple.length; i++) {
			if(triple[i].id == id) {
				retObj = triple[i];
				break;
			}
		}
		if(retObj == null) {
			throw new IllegalArgumentException("idが不正です。(id=" + id + ")");
		}
		return retObj;
	}
}
