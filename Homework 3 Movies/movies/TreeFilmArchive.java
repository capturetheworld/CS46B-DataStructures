package movies;
import java.util.*;

public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive  {
	//again doesn't need add, bc TreeSet already checks for duplicates
	
	//converts the TreeSet back into ArrayList
	public ArrayList<Movie> getSorted(){
		ArrayList<Movie> sortedList = new ArrayList<Movie>(this);
		return sortedList;
	}
	
	public static void main(String[] args) {
		 TreeFilmArchive archive = new TreeFilmArchive();
		 for (Movie m: Movie.getTestMovies())
		  archive.add(m);
		 for (Movie m: archive)
		  System.out.println(m);
		 System.out.println("**************");
		 for (Movie m: archive.getSorted())
		  System.out.println(m);
		}
}
