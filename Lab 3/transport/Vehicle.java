package transport;

public class Vehicle 
{
	private int    nWheels;
	private double xPosition;
	private double yPosition;
	
	
	
	Vehicle(int nWheels)
	{
		this.nWheels = nWheels;
	}
	
	public void setPosition(double xPosition, double yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public double getXPosition() {
		return xPosition;
	}
	
	public double getYPosition() {
		return yPosition;
	}
	
	public void changePositionBy(double xDelta, double yDelta) {
		xPosition = xPosition + xDelta;
		yPosition = yPosition + yDelta;
	}
}
