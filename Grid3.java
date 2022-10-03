/**
* The Grid3 Class contains the actual Sheep Herder Game for PLAYER'S QUEST (SPECIAL) level
* In this special level, player has only 5 chances to find the sheep
* If failed to do so, the player loses and the game ends
* No dog and wolf in this level.
*
* This class also consists of 5x5 playing grid 
* It also displays the player's name, Instruction for this level, and "NEW GAME" button that starts a new set of game.
*
* Note: If the game cannot be seen when you run the application, click minimize or maximize button.
+
* @author Cherry Dominguez
* @version 1.0
* @since 2022-04-19
*/

import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;

public class Grid3 implements ActionListener
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
   
   int position, player, playerChoice; 
   int numOfChances;
   String name;
   
   JPanel head, body, bottom;
   JLabel heading, level;
   JButton [] tiles = new JButton [26];
   JButton resetButton = new JButton ();
   
   Character character = new Character ();
   Coordinate coordinate = new Coordinate ();
   
   /**
   * Constructor for Grid ()
   */
   public Grid3 (String name)
   {      
      
      //JFrame settings 
      frame = new JFrame ("Sheep Herder Game");
      frame.setSize (WIDTH, HEIGHT);
      frame.setVisible (true);
      frame.setResizable (true);
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            
      //access player's name and game level from SheepHerder class & Level class
      this.name = name;
      //this.gameLevel = gameLevel;
            
      //header
      head = new JPanel ();
      head.setBackground (Color.cyan);
      head.setLayout (new FlowLayout (FlowLayout.CENTER, 15, 15));
      frame.add (head, BorderLayout.NORTH);
           
      heading = new JLabel ("Welcome " + name);
      Font bigFont = new Font ("Arial", Font.BOLD, 30);
      heading.setFont (bigFont);
      head.add (heading);
      
      level = new JLabel ("          > 5 chances to find the sheep <");
      Font font = new Font ("Arial", Font.PLAIN, 27);
      level.setFont (font);
      head.add (level); 
      
      //body
      body = new JPanel ();
      body.setLayout (new GridLayout(ROWS, COLUMNS, GAP, GAP));
      frame.add (body, BorderLayout.CENTER);
      
      //grid tiles
      for (position = 0; position < GRID; ++position)
      {
         if  (position == coordinate.sheepPosition)     
         {
            tiles [position] = new JButton (character.imgSheep);
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
         //player = 0;
         numOfChances = 5;
         //playerChoice = 0;
         ++playerChoice;
            
         tiles [player].setIcon (null);
         tiles [player].setText (null);
            
         while (source != tiles [position])
         {
            position++;
         }

         if (numOfChances != 0)
         {
            //if player found the sheep                   
            if (source == tiles [coordinate.sheepPosition])
            {
               tiles [position].setIcon(character.imgPlayerSheep);
                  
               JOptionPane.showMessageDialog (null,"You found the SHEEP safely eating grass!","Sheep Herder Game",1);
				   JOptionPane.showMessageDialog (null,"CONGRATULATIONS!!! YOU WIN!!! Click OK to play again.","Sheep Herder Game",1);

               frame.dispose();
               new Level (name);
             }
             
             //if no sheep
             else
             {
               tiles [position].setIcon(character.imgGrass);
             }
             
             // 5 chances to find the sheep
              if (playerChoice >= numOfChances)
              {
                  JOptionPane.showMessageDialog (null,"You did not find the SHEEP!","Sheep Herder Game",1);
                  JOptionPane.showMessageDialog (null,"SORRY, YOU LOSE! Goodbye!","Sheep Herder Game",1);
                      
                  frame.dispose();
                  new SheepHerder ();
              }
    
         } //end of if (numOfChances != 0)
         
      } //end of else reset button
         
   }// end of actionPerformed method ()
 
   /**
   * Main method
   * @param args the command line arguments
   */
   public static void main(String[] args)
   {
      new Grid3 ("Shepherd");
   }// end of Main method
   
}//end of Grid3 class