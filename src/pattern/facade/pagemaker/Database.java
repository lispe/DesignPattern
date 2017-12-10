package pattern.facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {
	
	private Database() {
	}
	
	/**
	 * {@code dbname}から{@code Properties}のインスタンスを得る。
	 * @param dbname
	 * @return 
	 */
	public static Properties getProperties(String dbname) {
		String filename = "C:/workspace/DesignPattern/src/pattern/facade/" +dbname + ".txt";
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(filename));
		} catch (IOException e) {
			System.out.println("Warning: " + filename + " is not found");
		}
		return prop;
	}
}
