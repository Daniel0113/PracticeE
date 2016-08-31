package simulations;
import javax.swing.*;

import java.util.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;


public class Lottery extends JFrame {

	// Random variable
	Random random = new Random();
	
	// JLabel
	JLabel matches = new JLabel("Matches: ");
	
	// The three sub-sections of the frame
	private JPanel Top = new JPanel(new GridLayout(1, 6, 5, 5));
	private JPanel Middle = new JPanel(new GridLayout(1, 6, 5, 5));
	private JPanel Bottom = new JPanel(new GridLayout(1 , 3, 10, 10));
	
	// All JTextFields
	private JTextField[] winningNums = new JTextField[6];
	private JTextField[] yourNums = new JTextField[6];
	
	// Play Button
	private JButton Play = new JButton("Play");
	
	public Lottery() {
		
		Setup();
	
	}
	
	
	public static void main(String[] args) {
		
		new Lottery();

	}
	
	private void Setup(){
		
		// setting up components in the JPanels
		for(int i = 0; i < 6; i++){
			winningNums[i] = new JTextField(3);
			winningNums[i].setEditable(false);
			yourNums[i] = new JTextField(3);
			Top.add(winningNums[i]);
			Middle.add(yourNums[i]);
		}
		
		Top.setBorder(new TitledBorder("Winning Numbers"));
		Middle.setBorder(new TitledBorder("Your Chosen Numbers"));
		Bottom.add(new JLabel(""));
		Bottom.add(Play);
		Bottom.add(matches);
		
		// Working with ActionListeners
		
		Play.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				try {
					Check();
					Play();
				}
				
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "Characters not valid.");
				}
				
				
			}
			
		});
		
		// setting up layout of the frame and adding components
		setLayout(new GridLayout(3, 1, 5, 5));
		add(Top);
		add(Middle);
		add(Bottom);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Lottery Simulation");
		setSize(450, 200);
		setVisible(true);
	}
	
	private void Check(){
		for (int i = 0; i < 6; i++){
			int y = Integer.parseInt(yourNums[i].getText());
		}
	}
	private void Play(){
		
		int matches = 0;
		
		for(int i = 0; i < 6; i++){
			
			winningNums[i].setText(Integer.toString(random.nextInt(53) + 1));
			
			if(Integer.parseInt(yourNums[i].getText()) == Integer.parseInt(winningNums[i].getText()))
				matches++;
			
		}
		
		this.matches.setText("Matches: " + matches);
	}

}
