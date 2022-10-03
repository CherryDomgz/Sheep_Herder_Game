/**
* The SheepHerder application displays the welcome message and game instruction.
* It also asks for the player's name, and directs them to playing level options when "Enter" button is clicked.
*
* Note: If messages cannot be seen when you run the application, click minimize or maximize button. 
*
* @author Cherry Dominguez
* @version 1.0
* @since 2022-03-30
*/

import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;

public class SheepHerder extends JFrame implements ActionListener
{
   /**
   * Instance variables
   */
   final int WIDTH = 600;
   final int HEIGHT = 450;
   
   String name;
   
   JPanel head, body, start;
   JLabel heading, goal, playerName;
   JTextField nameField;
   JButton button;
   
   /**
   * Constructor for SheepHerder ()
   */
   public SheepHerder ()
   {
      //JFrame settings
      super ("Sheep Herder Game");
      setSize (WIDTH, HEIGHT);
      setVisible (true);
      setResizable (true);
      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      
      //header
      head = new JPanel ();
      head.setBackground (Color.cyan);
      head.setLayout (new FlowLayout (FlowLayout.CENTER, 15, 15)); 
      add (head, BorderLayout.NORTH);
      
      heading = new JLabel ("WELCOME TO SHEEP HERDER GAME");
      Font bigFont = new Font ("Arial", Font.BOLD, 30);
      heading.setFont (bigFont);
      head.add (heading);
      
      //instructions      
      body = new JPanel ();
      body.setLayout (new FlowLayout (FlowLayout.LEFT, 15, 15));
      add (body, BorderLayout.CENTER);
      
      goal = new JLabel ("GOAL:");
      Font medFont = new Font ("Arial", Font.BOLD, 20);
      goal.setFont (medFont);
      body.add (goal);
      
      goal = new JLabel ("Find the SHEEP before it gets eaten by the WOLF.");
      Font medFont2 = new Font ("Arial", Font.PLAIN, 20);
      goal.setFont (medFont2);
      body.add (goal);
      
      goal = new JLabel ("If the SHEEP gets eaten, the PLAYER will lose.");
      Font medFont3 = new Font ("Arial", Font.PLAIN, 20);
      goal.setFont (medFont3);
      body.add (goal);
          
      goal = new JLabel ("If the PLAYER and the WOLF meet, the PLAYER will lose ");
      Font medFont4 = new Font ("Arial", Font.PLAIN, 20);
      goal.setFont (medFont4);
      body.add (goal);
    
      goal = new JLabel ("   unless the PLAYER finds the valiant DOG first.");
      Font medFont5 = new Font ("Arial", Font.PLAIN, 20);
      goal.setFont (medFont5);
      body.add (goal);
     
      goal = new JLabel ("The fearless hunting DOG fights the WOLF when they meet,");
      Font medFont6 = new Font ("Arial", Font.PLAIN, 20);
      goal.setFont (medFont6);
      body.add (goal);

      goal = new JLabel ("   and the PLAYER may get an extra turn.");
      Font medFont7 = new Font ("Arial", Font.PLAIN, 20);
      goal.setFont (medFont7);
      body.add (goal);
      
      //start button
      start = new JPanel ();
      start.setBackground (Color.cyan);
      start.setLayout (new FlowLayout (FlowLayout.CENTER, 10, 15)); 
      add (start, BorderLayout.SOUTH);
     
      playerName = new JLabel ("ENTER PLAYER NAME:");
      Font font = new Font ("Arial", Font.BOLD, 20);
      playerName.setFont (font);
      start.add (playerName);
       
      nameField = new JTextField (15);
      Font font1 = new Font ("Arial", Font.PLAIN, 15);
      nameField.setFont (font1);
      start.add (nameField);
     
      button = new JButton ("Enter");
      button.setBackground (Color.yellow);
      Font font2 = new Font ("Arial", Font.PLAIN, 15);
      button.setFont (font2);
      start.add (button);
      
      //event listener
      button.addActionListener (this);
   }
   
   /**
   * actionPerformed method ()
   * This method executes when "Enter" button is pressed
   */
   @Override
   public void actionPerformed (ActionEvent event)
   {
      Object source = event.getSource();
      
		if(source == button)
		{
			if(nameField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please enter your name","Empty Field",1);
			}
			else
			{
				name = nameField.getText().toString();
				this.dispose();
            new Level(name);
			}
		}
   }// end of actionPerformed method ()
       
   /**
   * Main method
   * @param args the command line arguments
   */
   public static void main (String [] args) 
   { 
      new SheepHerder ();   
   }//end of main method
   
}//end of SheepHerder Class