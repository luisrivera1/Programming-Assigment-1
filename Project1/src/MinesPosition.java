import java.util.Random;

public class MinesPosition // 
{
	
	private Coordinates[] mineCoords;
	
	//MineCoordinates placement
	
	public Coordinates[] getMineCoordinates() 
	{
		
		return mineCoords;
		
	}


	public MinesPosition(int length){
		
		mineCoords = new Coordinates[length];
		
	} 
	
	// Uses the Coordinates class to create coordinates with random numbers.
	
	private Coordinates CreateCoordinates() 
	{
		
		Random rand = new Random();
		
		return new Coordinates(rand.nextInt(9), rand.nextInt(9));
		
	}
	
	// Fills up the MineCoordinates array with the use of the CreateCoordinates method.
	
	public void PopulateMineCoordinates() 
	{
		
		
		for(int i=0; i < mineCoords.length; i++)
		{
			mineCoords[i] = CreateCoordinates();
			
	}
}




// Method created to compare two different coordinates.

public boolean CompareCoordinates(int x, int y, Coordinates b) 
{
	
	return x == b.getX() && y == b.getY();
			
}	

// Uses the CompareCoordinates method to compare the clicked grid coordinate with all the mines coordinates.

public boolean CompareSelection(int x, int y)
{ 
	
	for(int i=0; i < mineCoords.length; i++)
	{ 
		
		if(CompareCoordinates(x, y, mineCoords[i]))
		{
			
			return true;
			
		}
		
	}
	
	return false;
	
}

// Checks if there's a mine nearby.

public boolean MinesNearby(int x, int y) 
{
	
	 if(CompareSelection(x+1, y) || 
			   CompareSelection(x-1, y) ||
			   CompareSelection(x, y-1) ||
			   CompareSelection(x+1, y-1) ||
			   CompareSelection(x-1, y-1) ||
			   CompareSelection(x, y+1) ||
			   CompareSelection(x+1, y+1) ||
			   CompareSelection(x-1, y+1)){
				
				return true;
				
			} 
			
			 else return false;
			
		}
		
		
		
		public int MinesNearbyCounter(int x, int y) // Mine Counter
		{
			
			int counter = 0;
			
			for(int i = x-1; i <= x+1; i++)
			{
				for(int j = y-1; j <= y+1; j++)
				{
					
					
					
					if(!(i == x && j == y))
					{
					
						if(CompareSelection(i, j))
							counter++;
						
						}
					}
				}
			
			return counter;
			
		}


}