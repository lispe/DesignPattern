package pattern.bridge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextDisplayImpl extends DisplayImpl {
	
	private File textFile;
	private BufferedReader br;
	private final int MAX_READAHEAD_LIMIT = 4096;
	
	
	public TextDisplayImpl(String path) {
		textFile = new File(path);
	}

	@Override
	public void rawOpen() {
		try {
			br = new BufferedReader(new FileReader(textFile));
			br.mark(MAX_READAHEAD_LIMIT);
			System.out.println("---------------");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rawPrint() {
		try {
			String line;
			br.reset();		// markした位置まで戻す
			while((line = br.readLine()) != null) {
				System.out.println("> " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rawClose() {
		try {
			br.close();
			System.out.println("---------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
