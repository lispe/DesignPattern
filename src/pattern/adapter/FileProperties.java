package pattern.adapter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {
	
	private static final String FOLDER_PATH = "./infiles/";

	@Override
	public void readFromFile(String filename) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		InputStream in = new FileInputStream(FOLDER_PATH+filename);
		load(in);
	}

	@Override
	public void writeToFile(String filename) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		OutputStream out = new FileOutputStream(FOLDER_PATH+filename);
		store(out, "#");

	}

	@Override
	public void setValue(String key, String value) {
		// TODO 自動生成されたメソッド・スタブ
		setProperty(key, value);

	}

	@Override
	public String getValue(String key) {
		// TODO 自動生成されたメソッド・スタブ
		return getProperty(key);
	}

}
