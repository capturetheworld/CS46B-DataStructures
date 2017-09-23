package movies;
import java.util.*;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive{
	//adds movies, but checks for duplicates
	public boolean add(Movie m) {
		
		for (Movie movie: this){
			if(movie.equals(m)) {
				return false;
			}
		}
		
		super.add(m);//uses ArrayList add, not this method
		return true;//always returns true if found
	}
	
	//sorts movies by copying to a TreeSet
	public ArrayList<Movie> getSorted(){
		TreeSet<Movie> tree = new TreeSet<Movie>(this); //passes this to a tree to be sorted
		ArrayList<Movie> sortedList = new ArrayList<Movie>(tree); //converts sorted list back to ArrayList to return
		return sortedList;
		
	}
}

