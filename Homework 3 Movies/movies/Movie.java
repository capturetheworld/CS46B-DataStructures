package movies;

public class Movie implements Comparable<Movie> {
	
	String title;
	int year;
    //creates a movie object requiring a title and year
	public Movie (String title, int year) {
		this.title = title;
		this.year = year;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	@Override
	//compares each and every movie by overriding Comparable for the Object Movie
	public int compareTo(Movie that) {
		if(this.getTitle().equals(that.getTitle())) { //if year and title are same
			if(this.getYear() == that.getYear())
				return 0;
			else if(this.getYear() < that.getYear()) 
				return -1; //this year comes before that and titles are same
			else
				return 1; //this year comes after that and titles are same	
		}
		else if(this.getTitle().compareTo(that.getTitle()) < 0)
			return -1; //this title comes before that title
		else
			return 1; //this title comes after that title
	}
	
  //overrides the equals method for the Object Movie
	public boolean equals(Movie that){
		if(this.getTitle().equals(that.getTitle()) && this.getYear()== that.getYear())
			return true;
		else
			return false;
	}
//returns the tiles by printing to the screen
	public String toString() {
		return("Movie " + this.getTitle() + " " + this.getYear() );
	}
	
	
	//filmList -test  array of films, returns an array
	public static Movie[] getTestMovies() {
		
		Movie[] filmList = new Movie[] {
				new Movie("The Thomas Crown Affair", 1968),
				new Movie("The Thomas Crown Affair", 1999),
				new Movie("The Martian", 2015),
				new Movie("Bridge of Spies", 2015),
				new Movie("Star Trek Beyond",2016),
				new Movie("Star Trek Beyond", 2016),
				new Movie("Nemesis", 2002),
				new Movie("Into Darkness", 2013),
				new Movie("The Final Fontier", 1989),
				new Movie("The Undiscovered Country",1991)
				
		};
		return filmList;
	}
	
	public int hashCode()
	{
		return title.hashCode() + year;
	}
	//prints out sorted list overridden with ArrayList
	public static void main(String[] args) {
		 ListFilmArchive archive = new ListFilmArchive();
		 for (Movie m: Movie.getTestMovies())
		  archive.add(m);
		 for (Movie m: archive)
		  System.out.println(m);
		 System.out.println("**************");
		 for (Movie m: archive.getSorted())
		  System.out.println(m);
		}
	
}





















