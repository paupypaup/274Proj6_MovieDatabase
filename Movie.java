import java.util.ArrayList;
public class Movie 
{
	/**
	 * Title of the movie
	 */
	private String title;
	/**
	 * Year the movie was released
	 */
	private int year;
	/**
	 * The rating of the movie
	 */
	private String rating;
	/**
	 * The length of the movie
	 */
	private int length;
	/**
	 * The number of stars of the movie
	 */
	private double stars;
	/**
	 * ArrayList containing the actors in the movie
	 */
	private ArrayList <String > actors; 
	
	/**
	 * Constructor for a Movie object
	 * @param t title
	 * @param y year
	 * @param r rating
	 * @param l length
	 * @param s star
	 */
	public Movie(String t, int y, String r, int l, double s)
	{
		title = t;
		year = y;
		rating = r;
		length = l;
		stars = s;
		actors = new ArrayList<String>();
	}
	
	/**
	 * Gets the title of the movie
	 * @return title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Gets the year of the movie
	 * @return the movie year
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Gets the rating of the movie
	 * @return the rating
	 */
	public String getRating()
	{
		return rating;
	}
	
	/**
	 * Gets the length of the movie
	 * @return movie length
	 */
	public int getLength()
	{
		return length;
	}
	
	/**
	 * Gets the number of stars for the movie
	 * @return the number of stars
	 */
	public double getStars()
	{
		return stars;
	}
	
	/**
	 * Prints all the actors in the movie
	 * @return the string of actor names
	 */
	public String printActors()
	{
		String s = "";
		for (int i = 0; i< (actors.size() -1); i++)
		{
			s = s + actors.get(i) + ", ";
		}
		
		if (actors.size() > 0)
		{
			s = s + actors.get(actors.size() -1) +".";
		}
		return s;
	}
	
	/**
	 * Gets the ArrayList of the list of actors
	 * @return the ArrayList containing the actors
	 */
	public ArrayList <String> getActors()
	{
		return actors;
	}
	
	/**
	 * Sets a new title for the movie
	 * @param t the new title
	 */
	public void setTitle(String t)
	{
		title = t;
	}
	
	/**
	 * Sets a new year of the movie
	 * @param y the new year
	 */
	public void setYear(int y)
	{
		year = y;
	}
	
	/**
	 * Sets a new rating for the movie
	 * @param r the new rating
	 */
	public void setRating(String r)
	{
		rating = r;
	}
	
	/**
	 * Sets a new length for the movie
	 * @param l the new length to be set
	 */
	public void setLength(int l)
	{
		length = l;
	}
	
	/**
	 * Sets a new number of stars
	 * @param s the new number of stars
	 */
	public void setStars(double s)
	{
		stars = s;
	}
	
	/**
	 * Adds a new actor to the Movie
	 * @param a actor to be added
	 */
	public void addActor(String a)
	{
		actors.add(a);
	}
	
	/**
	 * Removes an actor
	 * @param actor actor to be removed
	 * @return the name of the actor to be removed 
	 */
	public String removeActor ( String actor )
	{
		String foundActor = null;
		for( int i = 0; i < actors.size(); i ++)
		{
			if ( actors.get(i).equalsIgnoreCase(actor) )
			{
				foundActor = actors.get(i);
				actors.remove(i);
			}
		}
		return foundActor;
	}
	
	/**
	 * toString form of a Movie
	 */
	public String toString()
	{
		return title + " | " + String.valueOf(year) + " | " + rating + " | " + String.valueOf(length) +" mins" + " | " + String.valueOf(stars) + " | " + printActors();
	}
	
	/**
	 * Compares two movies by alphabetical order
	 * @param m the movie to compare
	 * @return -1 if in right order, 0 if two movies are equal, 1 if wrong order
	 */
	public int compareTo(Movie m)
	{
		if ( this.getTitle().compareToIgnoreCase( m.getTitle() ) < 0)
		{
			return -1;
			
		} else if ( this.getTitle().compareToIgnoreCase( m.getTitle() ) > 0)
		{
			return 1;
		}
		
		return 0;
	}
}
