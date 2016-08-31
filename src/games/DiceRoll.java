package games;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;

public class DiceRoll extends JFrame {

	// All components are listed below
	
	// JPanels
	private JPanel gameManager = new JPanel(new GridLayout(3, 2, 5, 5));
	
	// JTextFields
	private JTextField yourRollInt = new JTextField(5);
	private JTextField compRollInt = new JTextField(5);
	
	// JButtons
	private JButton roll = new JButton("Roll");
	
	// JLabels
	private JLabel yourRoll = new JLabel("Your Roll");
	private JLabel compRoll = new JLabel("Computer's Roll");
	private JLabel winOrLose = new JLabel("Click Roll To Play");
	
	
	// Constructor
	public DiceRoll() {
		
		// setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// Editing the JTextFields
		yourRollInt.setEditable(false);
		compRollInt.setEditable(false);
		
		// adding an actionlistener to the button
		roll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int intComp = roll();
				int intYou = roll();
				String comp = Integer.toString(intComp);
				String you = Integer.toString(intYou);
				
				if(intComp > intYou)
					winOrLose.setText("You Lose");
				else if (intComp == intYou)
					winOrLose.setText("Draw");
				else
					winOrLose.setText("You Win");
				
				yourRollInt.setText(you);
				compRollInt.setText(comp);
				
			}
		});
		
		// Adding components to the Panel and frame
		gameManager.add(yourRoll);
		gameManager.add(yourRollInt);
		gameManager.add(compRoll);
		gameManager.add(compRollInt);
		gameManager.add(winOrLose);
		gameManager.add(roll);
		
		add(gameManager);
		
		// Setting up frame configuration
		setLocationRelativeTo(null);
		setTitle("Dice Roll Game");
		setSize(255, 130);
		setResizable(false);
		setVisible(true);
		
	
	}
	
	public static void main(String[] args) {
		
		new DiceRoll();
		
	}
	
	private static int roll() {
		
		Random r = new Random();
		int n = r.nextInt(6) + 1;
		
		return n;
			
	}

}
