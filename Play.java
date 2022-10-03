/**
* The Play Class contains the difficulty of the 2 game level options
* gameLevelEasy () method - TAME WOLF (EASY) playing level, where the wolf moves one tile at a time, and WOLF always dies vs DOG 
* gameLevelDifficult () method - SNEAKY WOLF (DIFFICULT) playing level, 
*
* @author Cherry Dominguez
* @version 1.0
* @since 2022-04-13
*/

import javax.swing.*;
import java.awt.*; 

public class Play 
{   
   /**
   * Instance variables
   */
   final int NUMBER_OF_GRIDS = 24;
   
   String name;
   

   /**
   * gameLevelEasy () method
   * Easy wolf Turn - wolf moves one position at a time
   */
   public void gameLevelEasy (Coordinate coordinate, Character character, JFrame frame, JButton [] tiles, int player, int dog)
   {
      //easy level wolf turn
      tiles[coordinate.wolfPosition].setIcon(null);
      tiles[coordinate.wolfPosition].setText(null);
                                    
      coordinate.wolfPosition = coordinate.easyWolfTurn; 
               
      tiles[coordinate.easyWolfTurn].setIcon(character.imgWolf);
      tiles[coordinate.easyWolfTurn].setText(""+character.easyWolfStrength);
                  
      ++coordinate.easyWolfTurn;
      if (coordinate.easyWolfTurn > 24)
         {
            coordinate.easyWolfTurn = 0;
         }
                  
      //wolf found the sheep while it takes its turn, sheep dies. Game over!
      if (coordinate.sheepPosition == coordinate.wolfPosition)              
      {
         tiles[coordinate.sheepPosition].setIcon(character.imgWolfSheep);
         
         JOptionPane.showMessageDialog (null,"You heared a BAAHHHH! The WOLF got the SHEEP.","Sheep Herder Game",1);                
         JOptionPane.showMessageDialog(null,"GAME OVER!! You lose. Goodbye!","Sheep Herder Game",1);               
         
         frame.dispose();
         new SheepHerder ();
       }
                                 
       //wolf found the dog while it takes its turn. Since the dog is stronger, the wolf dies and player win
       if (coordinate.dogPosition == coordinate.wolfPosition)
       {  
          tiles [coordinate.dogPosition].setIcon(character.imgDogWolf);
                                              
          JOptionPane.showMessageDialog (null,"The WOLF attacked the DOG! THE STRONGER DOG KILLED THE WOLF! There is no more WOLF to eat the SHEEP!","Sheep Herder Game",1);
          JOptionPane.showMessageDialog (null,"CONGRATULATIONS!! YOU WIN!! Click OK to play again.","Sheep Herder Game",1);
              
          tiles [coordinate.dogPosition].setIcon(character.imgDog);
          tiles [coordinate.dogPosition].setText(""+character.easyDogStrength); 
          
          frame.dispose();
          new Level (name); 
       }
                           
       //wolf found the player while it takes its turn. If the player is with a dog, wolf dies and player wins. If found alone, player dies. 
       if (coordinate.wolfPosition == player)
       {  
          if (dog == 1)
          {  
             tiles[player].setIcon(null);
             tiles[player].setText(null); 
                               
             tiles [coordinate.easyWolfTurn].setIcon(character.imgPlayerDogWolf);
             tiles [coordinate.easyWolfTurn].setText(null);             
                                   
             JOptionPane.showMessageDialog (null,"The WOLF attacked you and the dog! THE STRONGER DOG KILLED THE WOLF! There is no more WOLF to eat the SHEEP!","Sheep Herder Game",1);
             JOptionPane.showMessageDialog (null,"CONGRATULATIONS!! YOU WIN!! Click OK to play again.","Sheep Herder Game",1);
              
             tiles [coordinate.easyWolfTurn].setIcon(character.imgPlayerDog);
             tiles [coordinate.easyWolfTurn].setText(""+character.easyDogStrength); 
             
             frame.dispose();
             new Level (name);            
                        
           }
           else
           {
              tiles [player].setIcon(character.imgPlayerWolf);
                                                  
              JOptionPane.showMessageDialog (null,"OH NO!! THE WOLF FOUND YOU!! The WOLF attacked and killed you","Sheep Herder Game",1);
              JOptionPane.showMessageDialog (null,"SORRY, YOU LOSE! Goodbye!","Sheep Herder Game",1);
              
              frame.dispose();
              new SheepHerder ();
            }
             
        }//end of if (coordinate.wolfPosition == player)

   }//end of gameLevelEasy () method
   
   /**
   * gameLevelDifficult () method
   * Difficult wolf Turn - the wolf moves in random position 
   */
   public void gameLevelDifficult (Coordinate coordinate, Character character, JFrame frame, JButton [] tiles, int player, int dog)
   {
      //difficult level wolf turn
      tiles[coordinate.wolfPosition].setIcon(null);
      tiles[coordinate.wolfPosition].setText(null);
                                    
      coordinate.wolfPosition = coordinate.difficultWolfTurn; 
               
      tiles[coordinate.difficultWolfTurn].setIcon(character.imgWolf);
      tiles[coordinate.difficultWolfTurn].setText(""+character.difficultWolfStrength);
      
      coordinate.difficultWolfTurn = ((int)(Math.random() * 100) % NUMBER_OF_GRIDS);
      if (coordinate.difficultWolfTurn > 24)
         {
            coordinate.difficultWolfTurn = 0;
         }
         
      //wolf found the sheep while it takes its turn, sheep dies. Game over!
      if (coordinate.sheepPosition == coordinate.wolfPosition)              
      {
         tiles[coordinate.sheepPosition].setIcon(character.imgWolfSheep);
         
         JOptionPane.showMessageDialog (null,"You heared a BAAHHHH! The WOLF got the SHEEP.","Sheep Herder Game",1);                
         JOptionPane.showMessageDialog(null,"GAME OVER!! You lose. Goodbye!","Sheep Herder Game",1);               
         
         frame.dispose();
         new SheepHerder ();
       }
       
       //wolf found the dog while it takes its turn. 
       if (coordinate.dogPosition == coordinate.wolfPosition)
       {  
         //stronger dog - wolf dies
         if (character.difficultDogStrength > character.difficultWolfStrength)
          {
            tiles [coordinate.dogPosition].setIcon(character.imgDogWolf);
            tiles [coordinate.dogPosition].setText(""+character.difficultDogStrength);
                                              
            JOptionPane.showMessageDialog (null,"The WOLF attacked the DOG! THE STRONGER DOG KILLED THE WOLF! There is no more WOLF to attack the SHEEP!","Sheep Herder Game",1);
            JOptionPane.showMessageDialog (null,"CONGRATULATIONS!! YOU WIN!! Click OK to play again.","Sheep Herder Game",1);
              
            tiles [coordinate.dogPosition].setIcon(character.imgDog);
            tiles [coordinate.dogPosition].setText(""+character.difficultDogStrength); 
          
            frame.dispose();
            new Level (name);         
          } // end of stronger dog
          
          //stronger wolf - dog dies
          else 
            if (character.difficultWolfStrength >= character.difficultDogStrength)
            {
               tiles [coordinate.dogPosition].setIcon(character.imgDogWolf);
               tiles [coordinate.dogPosition].setText(""+character.difficultWolfStrength);
                                              
               JOptionPane.showMessageDialog (null,"The WOLF attacked the DOG! THE STRONGER WOLF KILLED THE DOG! There is no more DOG to help you!","Sheep Herder Game",1);
              
               tiles [coordinate.dogPosition].setIcon(null);
               tiles [coordinate.dogPosition].setText(null);
               
               coordinate.dogPosition = 25;
               
               coordinate.wolfPosition = coordinate.difficultWolfTurn; 
               
               JOptionPane.showMessageDialog (null,"You hear a wolf move...","Sheep Herder Game",1);     
                      
               tiles[coordinate.wolfPosition].setIcon(character.imgWolf);
               tiles[coordinate.wolfPosition].setText(""+character.difficultWolfStrength);
          
               //frame.dispose();
               //new Level (name);
               //System.exit(0);     
            } //end of stronger wolf
            
         }// end of if wolf found the dog
          
   }//end of gameLevelDifficult () method
   
}//end of class Play