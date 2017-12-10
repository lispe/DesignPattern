package pattern.decorator;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiStringDisplay extends Display {
	List<String> strList = new ArrayList<String>();

	@Override
	public int getColumns() {
		int maxLen = 0;
		try {
			Iterator<String> it = strList.iterator();
			while(it.hasNext()) {
				int strLen;
					strLen = it.next().getBytes("sjis").length;
				if(maxLen < strLen) {
					maxLen = strLen;
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return maxLen + 2;
	}

	@Override
	public int getRows() {
		return strList.size();
	}

	@Override
	public String getRowText(int row) {
		String rtnStr = strList.get(row);
		try {
			while(rtnStr.getBytes("sjis").length < getColumns()) {
				rtnStr = rtnStr + " ";
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rtnStr;
	}
	
	public void add(String str) {
		strList.add(str);
	}

}
