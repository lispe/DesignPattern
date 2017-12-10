package pattern.facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {
	
	private Writer writer;
	
	public HtmlWriter(Writer writer) {
		this.writer = writer;
	}
	
	/**
	 * HTMLのタイトルを設定する。
	 * @param title HTMLに設定するタイトル
	 * @throws IOException {@code Writer#write}で例外となった場合にスローする。
	 */
	public void title(String title) throws IOException {
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>" + title + "</title>");
		writer.write("</head>");
		writer.write("<body>\n");
		writer.write("<h1>" + title + "</h1>\n");
	}
	
	/**
	 * HTMLに末尾に段落を入れた1行テキストを設定する。
	 * @param msg 設定するテキスト
	 * @throws IOException {@code Writer#write}で例外となった場合にスローする。
	 */
	public void paragraph(String msg) throws IOException {
		writer.write("<p>" + msg + "</p>\n");
	}
	
	/**
	 * HTMLにリンクを設定する。
	 * @param href 設定するリンク
	 * @param caption リンクに表示するテキスト
	 * @throws IOException {@code Writer#write}で例外となった場合にスローする。
	 */
	public void link(String href, String caption) throws IOException {
		paragraph("<a href=\"" + href + "\">" + caption + "</a>");
	}
	
	/**
	 * HTMLにメールアドレスのリンクを設定する。
	 * @param mailaddr 設定するメールアドレス
	 * @param username リンクに表示するテキスト
	 * @throws IOException {@code Writer#write}で例外となった場合にスローする。
	 */
	public void mailto(String mailaddr, String username) throws IOException {
		link("mailto:" + mailaddr, username);
	}
	
	/**
	 * 終了処理<br>
	 * {@code body}、{@code html}タグを閉じ、{@code Writer}をクローズする。
	 * @throws IOException {@code Writer#write}で例外となった場合にスローする。
	 */
	public void close() throws IOException {
		writer.write("</body>");
		writer.write("</html>\n");
		writer.close();
	}
}
