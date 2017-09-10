package weather;

public class Cloud {

	private float bottom;
	private float top;
	
	public Cloud(float b, float t) {
		bottom = b; //assigns b to instance var
		top = t; //assigns t to instance var
	}
	
	public float getHeight() {
		return (top-bottom); //returns difference of top and bottom
	}
	
	public String rain() {
		return ("It is raining");
	}
}
