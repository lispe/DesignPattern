package pattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitor extends Visitor {
	// 検索する拡張子
	private String ext;
	// 検索したファイルの一覧リスト
	private List<File> foundFileList = new ArrayList<File>();
	
	public FileFindVisitor(String ext) {
		this.ext = ext;
	}

	@Override
	public void visit(File file) {
		// ファイルの拡張子を判定
		if(file.getName().endsWith(ext)) {
			//　ファイルの拡張子が検索対象の拡張子と一致する場合はリストに格納する
			foundFileList.add(file);
		}
	}

	@Override
	public void visit(Directory directory) {
		Iterator<Entry> it = directory.iterator();
		while(it.hasNext()) {
			Entry entry = it.next();
			entry.accept(this);
		}
	}
	/**
	 * 検索したファイルの一覧をイテレータで返す。
	 * @return 検索したファイル一覧のイテレータ
	 */
	public Iterator<File> getFoundFiles() {
		return foundFileList.iterator();
	}

}
