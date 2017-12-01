package airlines;
import java.lang.Math;
import java.util.*;


public class FlightNet extends HashSet<Airport> implements Iterable<Airport> {
	//checks to see if hashSet doesn't have airport w/ that name
	public boolean nameIsAvailable(String name) {
		for(Airport a: this) {
			if(a.getName().equals(name))
				return false;
		}
		return true;
	}
	
	//adds connection either way
	public void connect(Airport a1, Airport a2) {
		a1.connectTo(a2);
		a2.connectTo(a1);
	}
	
	//removes connections either way
	public void disconnect(Airport a1, Airport a2) {
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}
	
	//removes airport from this List
	//disconnects all connections in 
	//remaining airports that connect to the removedMe
	public void removeAndDisconnect(Airport removeMe){
	
		this.remove(removeMe); //removes it
		
		//removes the connection if it exists
		//doesn't have to check, Airport already checks for connection
		for(Airport a: this) {
			a.disconnectFrom(removeMe);
		}
		
		
	}
	
	public Airport getAirportNearXY(int x, int y, int maximumDistance) {
		for(Airport a: this) {
			if(Math.hypot(a.getX()-x,a.getY()-y)<maximumDistance) {
				return a;
			}
		}
		return null;
	}
	
	public static FlightNet makeTestInstance()

	{
	

	  Airport sfo = new Airport("SFO",  31, 207);
	  Airport lax = new Airport("LAX",  81, 291);
	  Airport jfk = new Airport("JFK", 724, 169);
	  Airport mia = new Airport("MIA", 667, 455);
	  Airport sea = new Airport("SEA",  92,  31);
	  
	  FlightNet net = new FlightNet();
	  
	  net.add(sfo);
	  net.add(lax);
	  net.add(jfk);
	  net.add(mia);
	  net.add(sea);

	  net.connect(sfo, sea);

	  net.connect(sfo, jfk);

	  net.connect(sfo, lax);

	  net.connect(jfk, mia);

	  net.connect(jfk, sea);
	  

	 

	  return net;

	}
		
	

}
