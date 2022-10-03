/**
* The Coordinate Class contains the placement of the sheep, dog, and wolf. 
* At the start of the game, the animals are randomly assigned a tile. 
* For the TAME WOLF (EASY) level, the wolf moves one position at a time when the player clicks a tile.
* For the SNEAKY WOLF (DIFFICULT) level, the wolf moves in random position
*
* @author Cherry Dominguez
* @version 1.0
* @since 2022-03-30
*/

public class Coordinate
{
   /**
   * Instance variables
   */
   final int NUMBER_OF_GRIDS = 24;

	int sheepPosition;
   int dogPosition, wolfPosition;
   int easyWolfTurn, difficultWolfTurn;
      
   /**
   * Constructor for Coordinate
   */
	public Coordinate ()
	{   
		//generating and assigning random position to sheep, dog, and wolf when the game loads.
      sheepPosition = ((int)(Math.random() * 100) % NUMBER_OF_GRIDS);
      dogPosition = ((int)(Math.random() * 100) % NUMBER_OF_GRIDS);
      wolfPosition = ((int)(Math.random() * 100) % NUMBER_OF_GRIDS);
      
      //To make sure characters doesn't go out of bounds
      if (sheepPosition > 24)
         {
            sheepPosition = 0;
         }
       
      if (dogPosition > 24)
         {
            dogPosition = 0;
         }
         
      if (wolfPosition > 24)
         {
            wolfPosition = 0;
         }
           
      //To make sure that charcters are not in the same position at the start of the game
      if (sheepPosition == dogPosition || sheepPosition == wolfPosition)
      {
         sheepPosition = sheepPosition + 1;
         if (sheepPosition > 24)
            sheepPosition = 0;
      }
            
      if (dogPosition == wolfPosition)
      {
         dogPosition = dogPosition + 1;
         if (dogPosition > 24)
            dogPosition = 0;
      }
                     
      // Easy level wolf turn 
      easyWolfTurn = wolfPosition + 1;
      
      //Difficult level wolf turn
      difficultWolfTurn = ((int)(Math.random() * 100) % NUMBER_OF_GRIDS);
         	
   }// end of Coordinate Constructor
   	
}//end of class Coordinate