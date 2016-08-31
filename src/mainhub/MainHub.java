package mainhub;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import resources.*;
import games.*;
import simulations.*;
import java.awt.*;
import java.awt.event.*;

public class MainHub extends JFrame {
	
	// JPanels
	JPanel centerPanel = new JPanel(new GridLayout(2, 1, 3, 3));
	JPanel westPanel = new JPanel();
	
	// test string and arrays
	String[] test = {"Simulations", "Games", "Resources"};
	String[] sims = {"Lottery Simulation"};
	String[] resources = {"Metric Converter", "Temperature Converter", "Word Counter"};
	String[] games = {"Dice Roll Game", "Number Guessing Game"};
	
	// The JList that will have all the categories 
	private JList categories = new JList(test);
	
	// the box that will have the applications of each type depending on what's selected on the JList
	private JComboBox variedList = new JComboBox();
	
	// The Select Button
	private JButton select = new JButton("Select");
	
	MainHub(){
		// left allows only single selection
		categories.setSelectionMode(0);
		
		centerPanel.setBorder(new TitledBorder("Select Program"));
		centerPanel.add(variedList);
		centerPanel.add(select);
		
		westPanel.setBorder(new TitledBorder("Categories"));
		westPanel.add(new JScrollPane(categories));
		setLayout(new BorderLayout());
		add(BorderLayout.WEST, westPanel);
		add(BorderLayout.CENTER, centerPanel);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 215);
		setLocationRelativeTo(null);
		setTitle("PracticeE Main Hub - Created by Daniel F.");
		setVisible(true);
		
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				evaluateAndExecute();
			}
		});
		
		categories.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				
				switch(categories.getSelectedIndex()){
				case 0:
					addSims();
					break;
				case 1:
					addGames();
					break;
				case 2:
					addResources();
					break;
				}
				
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		new MainHub();

	}
	
	private void addResources(){
		variedList.removeAllItems();
		
		for (int i = 0; i < 3; i++){
			variedList.addItem(resources[i]);
		}
		
	}
	
	private void addGames(){
		variedList.removeAllItems();
		
		for (int i = 0; i < 2; i++){
			variedList.addItem(games[i]);
		}
	}
	
	private void addSims(){
		variedList.removeAllItems();
		
		for (int i = 0; i < 1; i++){
			variedList.addItem(sims[i]);
		}
		
	}
	
	private void evaluateAndExecute(){
		switch(categories.getSelectedIndex()){
		case 0:
			switch(variedList.getSelectedIndex()){
			case 0:
				new Lottery();
				break;
			}
			break;
		case 1:
			switch(variedList.getSelectedIndex()){
			case 0:
				new DiceRoll();
				break;
			case 1:
				new NumberGuess();
				break;
			}
			break;
		case 2:
			switch(variedList.getSelectedIndex()){
			case 0: 
				new Meters();
				break;
			case 1:
				new Temperature();
				break;
			case 2:
				new WordCounter();
				break;
			}
			break; 
			
		}
	}

}
