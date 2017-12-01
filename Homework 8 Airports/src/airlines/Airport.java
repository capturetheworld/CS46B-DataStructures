package airlines;

import java.util.*;


public class Airport implements Comparable<Airport>
{
	private String					name;
	private int						x;
	private int						y;
	private Set<Airport>			connections;	// all airports with a direct route to/from this airport
	
	
	public Airport(String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		connections = new TreeSet<>();
	}
	
	
	public String getName()
	{
		return name;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	
	public int getY()
	{
		return y;
	}
	
	//returns an ArrayList of connections
	public List<Airport> getConnections()
	{
		return new ArrayList<>(connections);
	}
	
	
	// Adds that airport to the list of connections.
	public void connectTo(Airport that)
	{
		connections.add(that);
	}
	
	
	//
	// Does nothing if this airport is not connected to that.
	//Removes the connection if connected
	//
	public void disconnectFrom(Airport that) {
	
		if(!isConnectedTo(that))
			return;
		connections.remove(that);
		

	}
	
	
	// Checks to see if airports are equals based on name
	public boolean equals(Object x)
	{
		Airport that = (Airport)x;
		return this.compareTo(that) ==0;
		
		
	}
	
	
	// Orders airports based on name
	public int compareTo(Airport that)
	{
		if(this.name.compareTo(that.name)<0)
			return -1;
		else if(this.name.compareTo(that.name)>0)
			return 1;
		else
			return 0;

	}
	
	//checks to see if that airport is connected to this one
	public boolean isConnectedTo(Airport that)
	{
		boolean isConnected = false;
		for(Airport a: connections) {
			if(a.equals(that))
				isConnected = true;
		}
		return isConnected;
			

	}
	
	//prints out airports
	public String toString()
	{
		return "Airport " + name + " @(" + x + "," + y + ")";
	}
}
