package pattern.prototype;

import pattern.prototype.framework.Product;

public abstract class ConcreteProduct {


	public Product createClone() {
		Product p = null;
		try {
			p = (Product)clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
	
}
