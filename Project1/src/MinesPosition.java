import java.util.Random;

public class MinesPosition
{
	private Coordinates [] MinesPosition ; 
	private Coordinates[] MinesPosition2;

	public Coordinates [] getMinesPosition() //Object Array
	{
		return MinesPosition;
	}	
	public MinesPosition(int length)
	{
		MinesPosition = new Coordinates[length];
		MinesPosition2 = new Coordinates[length];
	}
	private Coordinates CreateCoordinates()
	{  
		Random rand = new Random();
		return new Coordinates(rand.nextInt(9), rand.nextInt(9));

	}
	public void ScatterMineCoord()
	{
		for (int bucky = 0; bucky < MinesPosition.length; bucky++)   //Based on theNewBoston 
		{
			MinesPosition [bucky] = CreateCoordinates();

		}
			MinesPosition2= MinesPosition.clone();  

		for (int i = 0; i < MinesPosition.length; i++) // This for loop is made to prevent having two mines right in top of each other.
		{
			for (int j = 0; j < MinesPosition2.length-1; j++) 
			{
				if (MinesPosition[i]==MinesPosition2 [j+1]) 
				{
					MinesPosition[i]= CreateCoordinates();
				}
			}
		}

	}
	
	public boolean CompareCoord(int x, int y, Coordinates a) // Method to compare two different coordinates
	{ 
		return x == a.getX() && y == a.getY();
	}
	
	public boolean compareSelec(int x, int y ) 
	{
		for(int i=0; i < MinesPosition.length; i++)
		{ 
			if(CompareCoord(x, y, MinesPosition[i]))
			{
				return true;
			}	
		}
		return false;	
	}
	
	public boolean neighboringMines( int i, int j)    //Mines nearby method , Based on  Array Chapter 7.6.3 Big Java Early Objects
	{
		if(		compareSelec(i+1,j)|| 
				compareSelec(i-1,j)	||
				compareSelec(i,j+1)||
				compareSelec(i,j-1)||
				compareSelec(i-1,j-1)||
				compareSelec(i+1,j+1)||
				compareSelec(i-1,j+1)||
				compareSelec(i+1,j-1))
		{
			return true;
		}
		return false;

	}
	// Next: The Counter Method	
	public int  minesNearbyCounter(int  x, int y) 
	{
		int counter = 0 ;
		for (int i = x-1; i <= x+1; i++) 
		{
			for (int j = y-1; j <= y+1; j++) 
			{
				if (!(i==x && j == y))
				{
					if (compareSelec(i,j))
					{
						counter++;	
					}	
				}	
			}
		}
		return counter;
		}
}







