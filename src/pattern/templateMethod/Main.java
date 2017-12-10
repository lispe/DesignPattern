package pattern.templateMethod;

public class Main {

	public static void main(String[] args) {
		AbstractDisplay cd = new CharDisplay('H');
		AbstractDisplay sd = new StringDisplay("Hello,World");
		
		cd.display();
		sd.display();

	}

}
