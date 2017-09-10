package weather;

import java.util.ArrayList;

public class Sky2 extends ArrayList<Cloud>{ //extends directly from ArrayList
	
public Sky2() {
	super(100); //create an ArrayList of Clouds
}

public float getMeanHeight() {
	float meanHeight = 0;
	
	for(Cloud c: this) {
		meanHeight += c.getHeight(); //sums the height of clouds
	}	
	
	meanHeight = meanHeight/this.size(); //divides by the number of clouds
	return meanHeight; //returns mean height of all clouds
	}

public static void main(String[] args)
{
	StratusCloud strat = new StratusCloud(100, 1000);
	if (!strat.rain().startsWith("It is raining"))
		System. out .println("Bad StratusCloud::rain");
	CumulusCloud cumu = new CumulusCloud(200, 2000);
	if (!cumu.rain().startsWith("It is raining"))
		System. out .println("Bad CumulusCloud::rain");
	CirrusCloud cirr = new CirrusCloud(300, 3000);
	if (!cirr.rain().startsWith("I cannot make"))
		System. out .println("Bad CirrusCloud::rain");
	Sky2 sky = new Sky2();
	sky.add(strat);
	sky.add(cumu);
	sky.add(cirr);
	float mean = sky.getMeanHeight();
	if (mean < 1799 || mean > 1801)
		System. out .println("Bad mean height: expected 1800, saw " + mean);
	System. out .println("Everything (else) is ok");
}
}
