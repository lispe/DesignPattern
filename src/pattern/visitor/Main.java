package pattern.visitor;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		Directory rootdir = new Directory("root");
		Directory bindir = new Directory("bin");
		Directory tmpdir = new Directory("tmp");
		Directory usrdir = new Directory("usr");
		rootdir.add(bindir);
		rootdir.add(tmpdir);
		rootdir.add(usrdir);
		
		bindir.add(new File("vi",10000));
		bindir.add(new File("latex", 2000));
		
		Directory yuki = new Directory("yuki");
		Directory hanako = new Directory("hanako");
		Directory tomura = new Directory("tomura");
		usrdir.add(yuki);
		usrdir.add(hanako);
		usrdir.add(tomura);
		
		yuki.add(new File("diary.html", 100));
		yuki.add(new File("Composit.java", 200));
		hanako.add(new File("memo.txt", 300));
		hanako.add(new File("index.html", 350));
		tomura.add(new File("game.doc", 400));
		tomura.add(new File("junk.mail", 500));
		
		
		Directory root2dir = new Directory("root2");
		Directory bin2dir = new Directory("bin2");
		Directory tmp2dir = new Directory("tmp2");
		Directory usr2dir = new Directory("usr2");
		root2dir.add(bin2dir);
		root2dir.add(tmp2dir);
		root2dir.add(usr2dir);
		
		bin2dir.add(new File("vi",10000));
		bin2dir.add(new File("latex", 2000));
		
		FileFindVisitor ffv = new FileFindVisitor(".html");
		rootdir.accept(ffv);
		
		System.out.println("HTML files are:");
		Iterator<File> it = ffv.getFoundFiles();
		while(it.hasNext()) {
			File file = it.next();
			System.out.println(file.toString());
		}
		
		System.out.println(rootdir.getSize());
		
		ElementArrayList list = new ElementArrayList();
		list.add(rootdir);
		list.add(root2dir);
		list.accept(new ListVisitor());
	}
}
