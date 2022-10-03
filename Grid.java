/**
* The Grid Class contains the actual Sheep Herder Game for TAME WOLF (EASY) level
* In the TAME WOLF (EASY) level, the wolf strength (8) and dog strength (10) are definite
* As for the turns, the wolf moves one position at a time, while the dog and the sheep stay in one place   
* 
* This class consists of 5x5 playing grid 
* It also displays the player's name, TAME WOLF (EASY) playing level, and "NEW GAME" button that starts a new set of game.
*
* Note: If the game cannot be seen when you run the application, click minimize or maximize button.
+
* @author Cherry Dominguez
* @version 1.0
* @since 2022-04-02
*/

import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;

public class Grid implements ActionListener
{
   /**
   * Instance variables
   */
   private final JFrame frame;
   
   final int ROWS = 5;
   final int COLUMNS = 5;
   final int GAP = 1;
   final int GRID = 25;
   final int WIDTH = 800;
   final int HEIGHT = 700;
   final String BLANK = "  ";
   
   int position, player, playerChoice, dog; 
   String name, gameLevel;
   
   JPanel head, body, bottom;
   JLabel heading, level;
   JButton [] tiles = new JButton [26];
   JButton resetButton = new JButton ();
   
   Character character = new Character ();
   Coordinate coordinate = new Coordinate ();
   Play play = new Play ();
   
   /**
   * Constructor for Grid ()
   */
   public Grid (String name, String gameLevel)
   {      
      
      //JFrame settings 
      frame = new JFrame ("Sheep Herder Game");
      frame.setSize (WIDTH, HEIGHT);
      frame.setVisible (true);
      frame.setResizable (true);
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
              
      //access player's name and game level from SheepHerder class & Level class
      this.name = name;
      this.gameLevel = gameLevel;
            
      //header
      head = new JPanel ();
      head.setBackground (Color.cyan);
      head.setLayout (new FlowLayout (FlowLayout.CENTER, 15, 15));
      frame.add (head, BorderLayout.NORTH);
           
      heading = new JLabel ("Welcome " + name);
      Font bigFont = new Font ("Arial", Font.BOLD, 30);
      heading.setFont (bigFont);
      head.add (heading);
      
      level = new JLabel ("           Your enemy is a "+ gameLevel);
      Font font = new Font ("Arial", Font.PLAIN, 27);
      level.setFont (font);
      head.add (level); 
      
      //body
      body = new JPanel ();
      body.setLayout (new GridLayout(ROWS, COLUMNS, GAP, GAP));
      frame.add (body, BorderLayout.CENTER);
      
      //grid tiles for EASY playing level - 1 sheep, easy wolf and dog strength
      //randomly set characters' position (class Coordinate)
      //access animal strengths and images (class Character)
      for (position = 0; position < GRID; ++position)
      {        
         if  (position == coordinate.sheepPosition)     
         {
            tiles [position] = new JButton (character.imgSheep);
            body.add (tiles [position]);            
         }    
         else 
            if (position == coordinate.wolfPosition)
            {
               tiles [position] = new JButton (character.imgWolf);
               tiles [position].setText (""+character.easyWolfStrength);
               body.add (tiles [position]);       
            }
            else
               if (position == coordinate.dogPosition)
               {
                   tiles [position] = new JButton (character.imgDog);
                   tiles [position].setText (""+character.easyDogStrength);
                   body.add (tiles [position]);       
               }
               else
               {
                   tiles [position] = new JButton (BLANK);
                   body.add (tiles [position]);
               } 
               
             //grid tiles action listener  
             tiles [position].addActionListener(this); 
             
         }//end of grid tiles
                   
        //reset
        bottom = new JPanel ();
        bottom.setBackground (Color.cyan);
        bottom.setLayout (new FlowLayout (FlowLayout.CENTER, 15, 15));
        frame.add (bottom, BorderLayout.SOUTH);
      
        resetButton = new JButton("NEW GAME");
        resetButton.setBackground (Color.yellow);
        Font font2 = new Font ("Arial", Font.BOLD, 20);
        resetButton.setFont (font2);
        bottom.add (resetButton);
      
        //reset event listener
        resetButton.addActionListener (this);  
      
   }//end of Grid constructor
   
   /**
   * actionPerformed method ()
   * This method is invoked automatically whenever the registered component is clicked.
   *
   */
   @Override
   public void actionPerformed (ActionEvent event)
   {
      Object source = event.getSource();
      
      //reset button
      if (source == resetButton)
      {
          frame.dispose();
          new Level (name);  
      } 
      else
      {
         position = 0;
         playerChoice = 0;
                   
         tiles [player].setIcon (null);
         tiles [player].setText (null);
         
         while (source != tiles [position])
         {
            ++position;
         }
                                  
         //player's tiles choice
         player = position;
                     
         if (source == tiles [coordinate.sheepPosition])
         {
            playerChoice = 1;
         }
         else
           if (source == tiles [coordinate.dogPosition])
           {
                  playerChoice = 2;
           }
           else
              if (source == tiles [coordinate.wolfPosition])
              {
                 playerChoice = 3;
              } 
              else
              {
                 playerChoice = 4;
                 tiles [player].setIcon(null);
                 tiles [player].setText(null);
              }
                
         switch (playerChoice)
         {
           //if player found the sheep 
           case 1: 
           {   
              tiles [player].setIcon(character.imgPlayerSheep);
              JOptionPane.showMessageDialog (null,"You found the SHEEP safely eating grass!","Sheep Herder Game",1);
				  JOptionPane.showMessageDialog (null,"CONGRATULATIONS!!! YOU WIN!!! Click OK to play again.","Sheep Herder Game",1);

              frame.dispose();
              new Level (name);
              break;                  
           } //end of case 1 sheep position 
               
           //if player found the dog
           case 2: 
           {
              tiles [position].setIcon(character.imgPlayerDog);
              tiles [position].setText(""+character.easyDogStrength);
              
              player = coordinate.dogPosition;
              dog = 1; // player with dog
              coordinate.dogPosition = 25; // to hide the dog
                      
              JOptionPane.showMessageDialog (null,"You found the fearless DOG with a strength of 10! It will defend you against the WOLF.","Sheep Herder Game",1);      
              JOptionPane.showMessageDialog (null,"You hear a WOLF move...","Sheep Herder Game",1);            
               
              if (gameLevel == "Tame Wolf")
              {
                  play.gameLevelEasy (coordinate,character,frame,tiles,player,dog);
              }
              
              break;                         
            }//end of case 2 dog position
               
            //if player found the wolf
            case 3: 
            {
              //if dog and player found the wolf
              if (dog == 1)
              {  
                tiles[player].setIcon(null);
                tiles[player].setText(null); 
                               
                tiles [coordinate.easyWolfTurn].setIcon(character.imgPlayerDogWolf);
                tiles [coordinate.easyWolfTurn].setText(null);             
                                   
                JOptionPane.showMessageDialog (null,"You and the DOG found the WOLF! The DOG and WOLF fought.. THE STRONGER DOG KILLED THE WOLF! There is no more WOLF to attack the SHEEP!","Sheep Herder Game",1);
                JOptionPane.showMessageDialog (null,"CONGRATULATIONS!! YOU WIN!! Click OK to play again.","Sheep Herder Game",1);
              
                tiles [coordinate.easyWolfTurn].setIcon(character.imgPlayerDog);
                tiles [coordinate.easyWolfTurn].setText(""+character.easyDogStrength); 
                
                frame.dispose();
                new Level (name);      
              }
              
              //only the player found the wolf
              else
              {
                 player = coordinate.wolfPosition;
                 tiles [player].setIcon(character.imgPlayerWolf);  
                                  
                 JOptionPane.showMessageDialog (null,"OH NO!! YOU FOUND THE WOLF!!! The WOLF attacked and killed you","Sheep Herder Game",1);
                 JOptionPane.showMessageDialog (null,"SORRY, YOU LOSE! Goodbye!","Sheep Herder Game",1);
                 
                 frame.dispose();
                 new SheepHerder ();
               } 
                             
             break;
            }//end of case 3 wolf position
            
            //player clicks an empty tiles
            case 4:
            {                                   
              //player with dog           
              if (dog == 1)                    
              {  
                 tiles [position].setIcon(character.imgPlayerDog);
                 tiles [position].setText(""+character.easyDogStrength);                             
              }
              
              //player only
              else                  
              {              
                  tiles [position].setIcon(character.imgPlayer);                     
              }
                  
              if (gameLevel == "Tame Wolf")
              {
                  play.gameLevelEasy (coordinate,character,frame,tiles,player,dog);
              }
 
              break;
            }//end of case 4 empty tiles

            default:
				{
				   JOptionPane.showMessageDialog(null,"Invalid move.","Sheep Herder Game",1);	
					break;
				}
              
        }//end of playerChoice switch   
                                
      }//end of reset button
           
   }// end of actionPerformed method ()
 
   /**
   * Main method
   * @param args the command line arguments
   */
   public static void main(String[] args)
   {
      new Grid ("Shepherd", "Tame Wolf");

   }// end of Main method
   
}//end of Grid class