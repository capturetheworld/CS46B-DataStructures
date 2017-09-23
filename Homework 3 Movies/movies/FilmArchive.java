package movies;
import java.util.ArrayList;

//interface what all archives implement
public interface FilmArchive {
public abstract ArrayList<Movie> getSorted();
public abstract boolean add(Movie m);


}
