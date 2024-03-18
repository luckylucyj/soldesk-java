package JavaFunsionData;

public class Product {

	public String text = "";
	public String title = "";
	public String content = "";
	public String write = "";
	public String id = "";
	public String pw = "";
	public int pin = 0;
	
	public int removed = 0;
	
	// 0
	
	
	public Product (String aa) {
		this.text = aa;
	}
	
	
	public Product (String aa ,String bb){
		this.id = aa;
		this.pw = aa;
	}
	
	public Product(String aa ,String bb, String cc) {
		title = aa;
		content = bb;
		write = cc;
	}

	
}
