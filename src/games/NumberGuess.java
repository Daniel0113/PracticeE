package games;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;

public class NumberGuess {
	
	// initial variables
	private Random r;
	private boolean gtfo = false, win = false;
	private int number;
	
	public NumberGuess() throws NumberFormatException {
		while(!gtfo){
			r = new Random();
			number = r.nextInt(99) + 1;
			
			for(int i = 8; i > 0; i--){
				String entry = JOptionPane.showInputDialog(null, 
						"Guess a number between 1 and 100. You have " + i + " tries",
						"Guessing Game", 
						JOptionPane.QUESTION_MESSAGE);
				
				if(Integer.parseInt(entry) == number){
					gtfo = true;
					win = true;
					JOptionPane.showMessageDialog(null, "Good job! You successfully guessed the number: " + number);
				}
				
				else if (i == 1){
					gtfo = true;
					JOptionPane.showMessageDialog(null, "You ran out of guesses. You lose! " + number );
				}
				
				else {
					compare(Integer.parseInt(entry), number);
				}
				
				if(gtfo){
					
					yesOrNoWindow();
					
					if(win)
						break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			new NumberGuess();
		}
		
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Incorrect input method or cancellation. Closing program...");
		}
	}
	
	private void compare(int guessed, int number){
		if (guessed > number) 
			JOptionPane.showMessageDialog(null, "The number is lower than your guess.");
		
		else
			JOptionPane.showMessageDialog(null, "The number is higher than your guess.");
	}
	
	private void yesOrNoWindow(){
		int answer = JOptionPane.showConfirmDialog(null, "Would you like to try again?");
		
		switch(answer){
		case JOptionPane.YES_OPTION:
			new NumberGuess();
			break;
		case JOptionPane.NO_OPTION:
			JOptionPane.showMessageDialog(null, "Okay. Thanks for playing!");
			break;
		case JOptionPane.CANCEL_OPTION:
			JOptionPane.showMessageDialog(null, "Okay, Thanks for playing!");
		}
		
	}

}
