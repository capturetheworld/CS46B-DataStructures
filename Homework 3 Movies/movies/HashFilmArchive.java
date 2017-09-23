package movies;
import java.util.*;
public class HashFilmArchive extends TreeSet<Movie> implements FilmArchive {
//	doesn't need add method because add already checks for duplicates

	//returns the sorted TreeList by copying the HashSet
	public ArrayList<Movie> getSorted(){
		TreeSet<Movie> tree = new TreeSet<Movie>(this); //passes this to a tree to be sorted
		ArrayList<Movie> sortedList = new ArrayList<Movie>(tree); //converts sorted list back to ArrayList to return
		return sortedList;
	}
	
	public static void main(String[] args) {
		 HashFilmArchive archive = new HashFilmArchive();
		 for (Movie m: Movie.getTestMovies())
		  archive.add(m);
		 for (Movie m: archive)
		  System.out.println(m);
		 System.out.println("**************");
		 for (Movie m: archive.getSorted())
		  System.out.println(m);
		}

}
