/**
* The Level Class displays the playing level options: Tame Wolf (Easy), Sneaky Wolf (Difficult), Player's Quest (Special)
* This class fires the game when "START HERDING SHEEP" button is pressed
* If the player chooses the TAME WOLF (EASY) level, they will be directed to Grid class
* If SNEAKY WOLF (DIFFICULT) level, they will be directed to Grid2 class
* If PLAYER'S QUEST (SPECIAL) level, to Grid3 class
*
* Note: If the game cannot be seen when you run the application, click minimize or maximize button.
*
* @author Cherry Dominguez
* @version 1.0
* @since 2022-04-10
*/

import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  

public class Level extends JFrame implements ActionListener
{
   /**
   * Instance variables
   */
   final int WIDTH = 600;
   final int HEIGHT = 450;
   
   String name, gameLevel;
   
   JPanel head, body, bottom;
   JLabel heading; 
   JRadioButton easyButton, difficultButton, specialButton;
   JButton startButton;
  
   /**
   * Constructor for Level ()
   */
   public Level (String name)
   {
     //JFrame settings
      super ("Sheep Herder Game");
      setSize (WIDTH, HEIGHT);
      setVisible (true);
      setResizable (true);
      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
      
      this.name = name;
      
      //header
      head = new JPanel ();
      head.setBackground (Color.cyan);
      head.setLayout (new FlowLayout (FlowLayout.CENTER, 15, 15)); 
      add (head, BorderLayout.NORTH);
      
      heading = new JLabel (name + ", please select your enemy:");
      Font bigFont = new Font ("Arial", Font.BOLD, 30);
      heading.setFont (bigFont);
      head.add (heading);
      
      //select      
      body = new JPanel ();
      body.setLayout (null);
      add (body, BorderLayout.CENTER);
      
      //level radio buttons
      easyButton = new JRadioButton ("Tame Wolf");
      easyButton.setText ("Tame Wolf");
      Font medFont1 = new Font ("Arial", Font.PLAIN, 25);
      easyButton.setFont (medFont1);
      easyButton.setBounds (150,50,200,30);
      body.add (easyButton);
      
      difficultButton = new JRadioButton ("Sneaky Wolf");
      difficultButton.setText ("Sneaky Wolf");
      Font medFont3 = new Font ("Arial", Font.PLAIN, 25);
      difficultButton.setFont (medFont3);
      difficultButton.setBounds (150,110,200,30);
      body.add (difficultButton);
      
      specialButton = new JRadioButton ("Player's Quest Special");
      specialButton.setText ("Player's Quest Special");
      Font medFont4 = new Font ("Arial", Font.PLAIN, 25);
      specialButton.setFont (medFont4);
      specialButton.setBounds (150,170,300,30);
      body.add (specialButton);
 
      //button group
      ButtonGroup levelGroup = new ButtonGroup ();    
      levelGroup.add (easyButton); 
      levelGroup.add (difficultButton);
      levelGroup.add (specialButton);
      
      //start button
      bottom = new JPanel ();
      bottom.setBackground (Color.cyan);
      bottom.setLayout (new FlowLayout (FlowLayout.CENTER, 15, 15));
      add (bottom, BorderLayout.SOUTH);
      
      startButton = new JButton ("START HERDING SHEEP");
      startButton.setBackground (Color.yellow);
      Font font2 = new Font ("Arial", Font.BOLD, 20);
      startButton.setFont (font2);
      bottom.add (startButton);
      
      //start button event listener
      startButton.addActionListener (this);
      
   }//end of Level constructor ()
  
   /**
   * actionPerformed method ()
   * This method is invoked automatically whenever the registered component is clicked.
   *
   */
   @Override
   public void actionPerformed (ActionEvent event)
   {
      Object source = event.getSource();
      
         if (easyButton.isSelected())
         {
            gameLevel = easyButton.getText().toString();
            this.dispose();
            new Grid (name,gameLevel);   
         }
         else
            if (difficultButton.isSelected())
            {
               gameLevel = difficultButton.getText().toString();
               this.dispose();
               new Grid2 (name,gameLevel);
            }
            else
            {
               gameLevel = specialButton.getText().toString();
               this.dispose();
               new Grid3 (name);
            }
      } // end of actionPerformed method ()
  
   /**
   * Main method
   * @param args the command line arguments
   */
   public static void main (String [] args) 
   { 
      new Level ("Shepherd");      
   }//end of main method

}//end of Level class
