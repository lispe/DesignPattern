package pattern.adapter;

public class PrintBannerInherit extends Banner implements PrintInterface {

	public PrintBannerInherit(String string) {
		super(string);
	}

	@Override
	public void printWeak() {
		showWithParen();
	}

	@Override
	public void printStrong() {
		showWithAster();
	}

}
