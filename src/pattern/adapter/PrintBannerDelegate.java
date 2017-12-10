package pattern.adapter;

public class PrintBannerDelegate extends PrintClass {
	private Banner banner;
	
	public PrintBannerDelegate(String string) {
		this.banner = new Banner(string);
	}

	@Override
	public void PrintWeak() {
		banner.showWithParen();
	}

	@Override
	public void PrintStrong() {
		banner.showWithAster();
	}

}
