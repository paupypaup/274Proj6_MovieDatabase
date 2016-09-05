import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class MovieDatabase 
{
	public static void main (String [] args)
	{
		BST bst = new BST();
		
		try 
		{
			Scanner read = new Scanner(new File ("movies.txt"));
			
			do
			{
				String s = read.nextLine();
					
				String [] items = s.split("/");
				
				String title = items[0];
				int year = Integer.parseInt(items[1]);
				String rating = items[2];
				int length = Integer.parseInt(items[3]);
				Double stars = Double.parseDouble(items[4]);
				
				Movie m = new Movie(title, year, rating, length, stars);

				try
				{
					if (items[5] != null)
					{		
						String [] actorList = items[5].split(",");
						for (int i = 0; i < actorList.length; i++)
						{
							m.addActor(actorList[i]);
						}
					}
				}catch (ArrayIndexOutOfBoundsException e)
				{
					
				}
				
				bst.add(m);
				
			} while(read.hasNext());
			
			read.close();
			
		} catch (FileNotFoundException e) 
		{
			System.out.println("File not found.");
		}
		
		
		boolean menu = true;
		do 
		{
			displayMenu();
			int menuInput = CheckInput.checkInt(1,7);
			switch(menuInput)
			{
				case 1: //add a new movie
					addMovie(bst);
					break;
						
				case 2: //delete movie
					removeMovie(bst);
					break;
						
				case 3: //add actor to a movie
					addActorToMovie(bst);
					break;
					
				case 4: //delete actor from a movie
					removeActorFromMovie(bst);
					break;
						
				case 5: //Display all movies
					bst.printBST();	
					System.out.println();
					break;
						
				case 6: //Find Movies
					findMovie(bst);
					break;
				
				case 7: //Quit
					writeMoviesToFile( bst);
					menu = false;
					break;
			}
		} while (menu);
	}
	
	public static void displayMenu()
	{
		System.out.println("\nMAIN MENU\n");
		System.out.println("1) Add a New Movie");
		System.out.println("2) Delete Movie");
		System.out.println("3) Add Actor to Movie");
		System.out.println("4) Delete Actor from a Movie");
		System.out.println("5) Display All Movies");
		System.out.println("6) Find Movie(s)");
		System.out.println("7) Quit");
	}
	
	public static void addMovie( BST bst )
	{
		Scanner in = new Scanner(System.in);
		System.out.println("What is the title of the movie you want to add?: ");
		String movieTitle = in.nextLine();
		
		System.out.println("What is the year that the movie was released? (enter 0 if unknown): ");
		int year = CheckInput.checkInt();
		
		System.out.println("What is the rating of the movie? (enter a blank space if unknown): ");
		String rating = in.nextLine();
		
		System.out.println("What is the length, in minutes, of the movie? (enter 0 if unknown): ");
		int length = CheckInput.checkInt();
		
		System.out.println("How many stars does the movie have? (enter 0 if unknown): ");
		double stars = CheckInput.checkDouble();
		
		Movie m = new Movie(movieTitle, year, rating, length, stars);
		
		bst.add(m);
	}
	
	public static void removeMovie( BST bst )
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is the title of the movie you want to remove?: ");
		String movieTitle = in.nextLine();
		
		if ( bst.search(movieTitle) != null)
		{
			System.out.println(bst.search(movieTitle).getMovie().getTitle() + " removed from list.");
			bst.remove( bst.search(movieTitle).getMovie() );
		}
	}
	
	public static void addActorToMovie( BST bst )
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Which movie do you want to add the actor to?:");
		String movieChoice = in.nextLine();
		
		Node n = bst.search(movieChoice);
		
		if ( n != null)
		{
			System.out.println("What is the name of the actor you want to add?");
			String actorName = in.nextLine();
			n.getMovie().addActor(actorName);
		}		
	}
	
	public static void removeActorFromMovie( BST bst )
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Which movie do you want to remove the actor from?:");
		String movieChoice = in.nextLine();
		
		Node n = bst.search(movieChoice);
		
		if ( n != null)
		{
			System.out.println("What is the name of the actor you want to remove?");
			String actorName = in.nextLine();
			
			String foundActor = n.getMovie().removeActor(actorName);
			if ( foundActor == null)
			{
				System.out.println("Actor not found.");

			}else
			{
				System.out.println(foundActor + " removed from " + n.getMovie().getTitle() );

			}
			
		}		
	}
	
	public static void findMovie( BST bst )
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("\nFIND MOVIE MENU\n");
		System.out.println("1) By Title");
		System.out.println("2) By Rating");
		System.out.println("3) By Decade");
		System.out.println("4) By Stars");
		System.out.println("5) By Actor");
		
		int findOption = CheckInput.checkInt(1,5);
		
		switch(findOption)
		{
			case 1: //by title
				System.out.println("Which movie are you looking for?:");
				String movieChoice = in.nextLine();
				if ( bst.search(movieChoice) != null)
				{
					System.out.println( bst.search(movieChoice).getMovie() );
				}
				break;
					
			case 2: //by rating
				System.out.println("Which rating are you looking for?:");
				String ratingChoice = in.nextLine();
				bst.printMatchingRating(ratingChoice);
				break;
					
			case 3: //by decade
				System.out.println("Which decade are you looking for?:");
				System.out.println("1) 1940s");
				System.out.println("2) 1950s");
				System.out.println("3) 1960s");
				System.out.println("4) 1970s");
				System.out.println("5) 1980s");
				System.out.println("6) 1990s");
				System.out.println("7) 2000s");				
				System.out.println("8) 2010s");
				
				int matchingYear = CheckInput.checkInt(1, 8);
				if ( matchingYear == 1)
				{
					bst.printMatchingYear(1940,1949);
				}else if (matchingYear == 2)
				{
					bst.printMatchingYear(1950,1959);

				}else if (matchingYear == 3)
				{
					bst.printMatchingYear(1960,1969);

				}else if (matchingYear == 4)
				{
					bst.printMatchingYear(1970,1979);

				}else if (matchingYear == 5)
				{
					bst.printMatchingYear(1980,1989);

				}else if (matchingYear == 6)
				{
					bst.printMatchingYear(1990,1999);

				}else if (matchingYear == 7)
				{
					bst.printMatchingYear(2000,2009);

				}else if (matchingYear == 8)
				{
					bst.printMatchingYear(2010,2019);

				}
				break;
					
			case 4: //by stars
				System.out.println("How many stars are you looking for?:");
				double starChoice = CheckInput.checkDouble();
				bst.printMatchingStar(starChoice);
				break;
					
			case 5: //by actor		
				System.out.println("Which actor are you searching for?:");
				String actorChoice = in.nextLine();
				bst.printMatchingActor(actorChoice);
				break;
		}
	}
	
	public static void writeMoviesToFile(BST bst)
	{
		try
		{
		    Random ran = new Random();
			PrintWriter writer = new PrintWriter("movies.txt");
			ArrayList <String> movieList = new ArrayList <String>();
			String movies = null;
			
			while( !bst.isEmpty() )
			{
				
				Movie top = bst.findMin();				
				
				String listOfActors = "";
				
				if (top.getActors().size() > 0)
				{
					
					for ( int i = 0; i < top.getActors().size() - 1; i++)
					{
						listOfActors = listOfActors + top.getActors().get(i) +",";						
					}
					
					listOfActors = listOfActors + top.getActors().get( top.getActors().size() -1 );
				}
				
				if ( listOfActors != "")
				{
					movies = top.getTitle() + "/" + String.valueOf(top.getYear()) + "/" + top.getRating() + "/" + String.valueOf(top.getLength()) + "/" + String.valueOf(top.getStars()) + "/" + listOfActors;
				}else
				{
					movies = top.getTitle() + "/" + String.valueOf(top.getYear()) + "/" + top.getRating() + "/" + String.valueOf(top.getLength()) + "/" + String.valueOf(top.getStars()) + "/";
				}
				
				movieList.add(movies);
				
				bst.remove(bst.findMin());
			}
			
			for (int i = 0; i < 1000; i++)
			{
				int rnd = ran.nextInt(movieList.size());
				String selectedMovie = movieList.get(rnd);
				movieList.remove(rnd);
				movieList.add(selectedMovie);
				
			}
			
			for (int i = 0; i < movieList.size(); i++)
			{
				writer.println(movieList.get(i));

			}
			
			writer.close();

		} catch (FileNotFoundException f)
		{
			
		}

		System.out.println("Saving and exiting.");
	}
}
