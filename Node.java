public class Node 
{
	/**
	 * The Movie to be contained in the Node
	 */
	private Movie movie;
	
	/**
	 * The pointer for the left Node
	 */
	private Node left;
	
	/**
	 * The pointer for the right Node
	 */
	private Node right;
	
	/**
	 * The constructor for the Node
	 * @param m the Movie to be contained
	 */
	public Node ( Movie m ) 
	{
		movie = m;
		left = null;
		right = null;
	}
	
	/**
	 * Gets the Movie in the Node
	 * @return the Movie in the Node
	 */
	public Movie getMovie() 
	{
		return movie;
	}
	
	public void setMovie(Movie m)
	{
		movie = m;
	}
	
	/**
	 * Sets a Node to the left of this Node
	 * @param l the Node to be set at the left position
	 */
	public void setLeft( Node l ) 
	{
		left = l;
	}
	
	/**
	 * gets the Node to the left of this Node
	 * @return the left Node
	 */
	public Node getLeft() 
	{
		return left;
	}
	
	/**
	 * Sets a Node to the right of this Node
	 * @param r the Node to be set at the right position
	 */
	public void setRight( Node r ) 
	{
		right = r;
	}
	
	/**
	 * gets the Node to the right of this Node
	 * @return the right Node
	 */
	public Node getRight() 
	{
		return right;
	}
}