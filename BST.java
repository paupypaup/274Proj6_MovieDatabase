public class BST 
{
	/**
	 * The Node at the root of the BST
	 */
	private Node root;
	
	/**
	 * Constructor for the BST
	 */
	public BST() 
	{
		root = null;
	}
	
	/**
	 * Checks if BST is empty
	 * @return returns true if empty
	 */
	public boolean isEmpty()
	{
		return root == null;
	}
	
	/**
	 * Helper function to add a Word to the BST
	 * @param w the Word to add
	 */
	public void add (Movie m) 
	{
		root = add( m, root);
	}
	
	/**
	 * Adds a Word to the BST
	 * @param w the Word to be added
	 * @param tree the subtree where the word is to be added afterwards
	 * @return the Node to add the Word to
	 */
	private Node add( Movie m, Node tree) 
	{
		if(tree == null)
		{
			return new Node(m);
			
		}else
		{
			
			if( m.compareTo( tree.getMovie() ) < 0 )
			{
				tree.setLeft(add(m, tree.getLeft()));
			} else
			{
				tree.setRight(add(m, tree.getRight()));
			}
		return tree;
		}
	}
	
	/**
	 * Helper function to print all Words in the BST in orded
	 */
	public void printBST() 
	{
		if (root == null) 
		{
		
			System.out.println("No items to print");
		} else 
		{
	
			printBST(root);
		}
	}
	
	/**
	 * Prints all Words in BST
	 * @param n the Node to print
	 */
	private void printBST(Node n) 
	{
		if (n.getLeft() != null) 
		{
			printBST(n.getLeft());
		}
		
		System.out.println( n.getMovie().getTitle() );
		
		if (n.getRight() != null) 
		{
			printBST(n.getRight());
		}
	}
	
	/**
	 * Helper function to print all Words in the BST in orded
	 */
	public void printMatchingRating(String s) 
	{
		if (root == null) 
		{
		
			System.out.println("No items to print");
		} else 
		{
	
			printMatchingRating(s, root);
		}
	}
	
	/**
	 * Prints all Words in BST
	 * @param n the Node to print
	 */
	private void printMatchingRating(String s, Node n) 
	{		
		if (n.getLeft() != null) 
		{
			printMatchingRating(s, n.getLeft());
		}
		
		if( n.getMovie().getRating().equalsIgnoreCase(s) )
		{
			System.out.println( n.getMovie().getTitle() );
		}
		
		if (n.getRight() != null) 
		{
			printMatchingRating(s, n.getRight());
		}
	}
	
	/**
	 * Helper function to print all Words in the BST in orded
	 */
	public void printMatchingYear(int low, int high) 
	{
		if (root == null) 
		{
		
			System.out.println("No items to print");
		} else 
		{
	
			printMatchingYear(low, high, root);
		}
	}
	
	/**
	 * Prints all Words in BST
	 * @param n the Node to print
	 */
	private void printMatchingYear(int low, int high, Node n) 
	{		
		if (n.getLeft() != null) 
		{
			printMatchingYear(low, high, n.getLeft());
		}
		
		if( n.getMovie().getYear() < high && n.getMovie().getYear() > low )
		{
			System.out.println( n.getMovie().getTitle() );
		}
		
		if (n.getRight() != null) 
		{
			printMatchingYear(low, high, n.getRight());
		}
	}
	
	/**
	 * Helper function to print all Words in the BST in orded
	 */
	public void printMatchingStar(double d) 
	{
		if (root == null) 
		{
		
			System.out.println("No items to print");
		} else 
		{
	
			printMatchingStar(d, root);
		}
	}
	
	/**
	 * Prints all Words in BST
	 * @param n the Node to print
	 */
	private void printMatchingStar(double d, Node n) 
	{		
		if (n.getLeft() != null) 
		{
			printMatchingStar(d, n.getLeft());
		}
		
		if( n.getMovie().getStars() == d )
		{
			System.out.println( n.getMovie().getTitle() );
		}
		
		if (n.getRight() != null) 
		{
			printMatchingStar(d, n.getRight());
		}
	}
	
	/**
	 * Helper function to print all Words in the BST in orded
	 */
	public void printMatchingActor(String a) 
	{
		if (root == null) 
		{
		
			System.out.println("No items to print");
		} else 
		{
	
			printMatchingActor(a, root);
		}
	}
	
	/**
	 * Prints all Words in BST
	 * @param n the Node to print
	 */
	private void printMatchingActor(String a, Node n) 
	{		
		if (n.getLeft() != null) 
		{
			printMatchingActor(a, n.getLeft());
		}
		
		for (int i = 0; i < n.getMovie().getActors().size(); i++)
		{
			if( a.equalsIgnoreCase(n.getMovie().getActors().get(i) ) )
			{
				System.out.println( n.getMovie().getTitle() );
			}
		}
		if (n.getRight() != null) 
		{
			printMatchingActor(a, n.getRight());
		}
	}
	
	/**
	 * Helper function to search the BST for a specific Word
	 * @param w the Word to search for
	 * @return the Node the Word is contained it, or null if Word is not found
	 */
	public Node search(String s) 
	{
		if (root == null) 
		{
			System.out.println("No items to search");
			return null;
		} else 
		{
			return search(s, root);
		}
	}
	
	/**
	 * searches the BST for a specific Word
	 * @param w the Word to search for
	 * @param n the Node in the subtree to search for
	 * @return returns the Node if Word is found, null if no
	 */
	private Node search(String s, Node n) 
	{
		if ( s.equalsIgnoreCase( n.getMovie().getTitle() ) ) 
		{
			return n;
		}
	
		if ( s.compareToIgnoreCase( n.getMovie().getTitle() ) < 0) 
		{
			if (n.getLeft() == null) 
			{
				System.out.println("Movie Not Found");
				return null;
			} else 
			{
				return search(s, n.getLeft());
			}
		} else 
		{
			if (n.getRight() == null) 
			{
				System.out.println("Movie Not Found");
				return null;
			} else 
			{
				return search(s, n.getRight());
			}
		}
	}
	
	
	
	//find min and max value of tree
	public Movie findMin()
	{
		return findMin(root).getMovie();
	}
	
	private Node findMin(Node n)
	{
		if(n == null)
		{
			return null;
			
		}else if(n.getLeft() == null)
		{
			return n;
		}
		return findMin(n.getLeft());
	}
	
	public Movie findMax()
	{
		return findMax(root).getMovie();
	}
	
	private Node findMax(Node n)
	{
		if(n == null)
		{
			return null;
			
		}else if(n.getRight() == null)
		{
			return n;
		}
		return findMax(n.getRight());
	}
	
	public void remove(Movie m) 
	{
		if (root == null) 
		{
			System.out.println("No movies to remove");
		} else 
		{
			root = remove(m, root);
		}
	}
	
	private Node remove(Movie m, Node n) 
	{
		if(n == null)
		{
			return n;
		}
		//traverse to node to be removed
		if(m.getTitle().compareToIgnoreCase( n.getMovie().getTitle() ) < 0)
		{
			n.setLeft( remove( m, n.getLeft() ) );
		
		}else if(m.getTitle().compareToIgnoreCase( n.getMovie().getTitle() ) > 0)
		{
			n.setRight( remove( m, n.getRight() ) );
			
		} else if(n.getLeft() !=null && n.getRight() != null)
		{
			if((int)(Math.random()*2) == 0)
			{
				n.setMovie(findMin(n.getRight()).getMovie());
				n.setRight(remove(n.getMovie(),n.getRight()));
			}else
			{
				n.setMovie(findMax(n.getLeft()).getMovie());
				n.setLeft(remove(n.getMovie(), n.getLeft()));
			}
		}else
		{ //one child
			if(n.getLeft() != null)
			{
				n = n.getLeft();
			}else
			{
				n = n.getRight();
			}
		}
		return n;
	}
}
