package pattern.composite;

public class Main {

	public static void main(String[] args) {
		try{
			System.out.println("Making root entries...");
			Directory rootdir = new Directory("root");
			Directory bindir = new Directory("bin");
			Directory tmpdir = new Directory("tmp");
			Directory usrdir = new Directory("usr");
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			bindir.add(new File("vi", 10000));
			bindir.add(new File("latex", 20000));
			rootdir.printList();
			
			System.out.println("");
			System.out.println("Makeing user entries...");
			Directory yukidir = new Directory("yuki");
			usrdir.add(yukidir);
			yukidir.add(new File("diary", 100));
			rootdir.printList();
			
		} catch(FileTreatmentException e) {
			e.printStackTrace();
		}
	}

}
