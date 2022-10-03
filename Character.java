/**
* The Character Class refers to all the characters of the Sheep Herder game.
* It includes the following characters: Player, Sheep, Dog, and Wolf
* Images used in this game are from www.pixabay.com
* It also contains dog and wolf strengths
* For the TAME WOLF (EASY) level, the dog strength is 10 and the wolf strength is 8 (Dog always defeated the wolf)
* For the SNEAKY WOLF (DIFFICULT) level, random strength value for both dog and wolf
*
* @author Cherry Dominguez
* @version 1.0
* @since 2022-03-31
*/

import javax.swing.*;

public class Character 
{
   /**
   * Instance variables
   */
   Icon imgPlayer, imgSheep, imgDog, imgWolf, imgPlayerSheep, imgPlayerWolf, imgPlayerDog, imgPlayerDogWolf, imgWolfSheep, imgDogWolf, imgGrass; 
   StringBuilder sbChar;
   
   final int STRENGTH_LIMIT = 10;
   
   int easyWolfStrength, difficultWolfStrength;
   int easyDogStrength, difficultDogStrength;
  
   /**
   * Constructor for Character 
   */
   public Character ()
   {
      //access characters images from the images folder 
      sbChar=new StringBuilder("/images/Player.jpg");
		imgPlayer=new ImageIcon(getClass().getResource(String.valueOf(sbChar)));
      
      sbChar=new StringBuilder("/images/Sheep.jpg");
		imgSheep=new ImageIcon(getClass().getResource(String.valueOf(sbChar)));

		sbChar=new StringBuilder("/images/Dog.jpg");
		imgDog=new ImageIcon(getClass().getResource(String.valueOf(sbChar)));
		
		sbChar=new StringBuilder("/images/Wolf.jpg");
		imgWolf=new ImageIcon(getClass().getResource(String.valueOf(sbChar)));	
      
      sbChar=new StringBuilder("/images/PlayerSheep.jpg");			
		imgPlayerSheep=new ImageIcon(getClass().getResource(String.valueOf(sbChar)));

		sbChar=new StringBuilder("/images/PlayerWolf.jpg");			
		imgPlayerWolf=new ImageIcon(getClass().getResource(String.valueOf(sbChar)));
      
      sbChar=new StringBuilder("/images/PlayerDog.jpg");
		imgPlayerDog=new ImageIcon(getClass().getResource(String.valueOf(sbChar)));

		sbChar=new StringBuilder("/images/PlayerDogWolf.jpg");					
		imgPlayerDogWolf=new ImageIcon(getClass().getResource(String.valueOf(sbChar)));
      
      sbChar=new StringBuilder("/images/WolfSheep.jpg");					
		imgWolfSheep=new ImageIcon(getClass().getResource(String.valueOf(sbChar)));
      
      sbChar=new StringBuilder("/images/DogWolf.jpg");					
		imgDogWolf=new ImageIcon(getClass().getResource(String.valueOf(sbChar)));

      sbChar=new StringBuilder("/images/Grass.jpg");					
		imgGrass=new ImageIcon(getClass().getResource(String.valueOf(sbChar))); 
           
      //Easy Level wolf strength
      easyWolfStrength = 8;
      easyDogStrength = 10;
      
      // Difficult level random strength value of dog and wolf  
      difficultWolfStrength = ((int)(Math.random() * 100) % STRENGTH_LIMIT);
      difficultDogStrength = ((int)(Math.random() * 100) % STRENGTH_LIMIT);   
      
   }//end of Character () constructor
   
}//end of Class Characters