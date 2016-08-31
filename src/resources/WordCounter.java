package resources;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.util.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.*;

public class WordCounter extends JFrame {
	
	// file chooser
	JFileChooser filechooser = new JFileChooser();
	
	// file being used.
	protected File file;
	
	// buttons
	protected JButton browse = new JButton("Browse");
	protected JButton search = new JButton("Search");
	
	// check boxes
	JCheckBox ignoreCase = new JCheckBox("Ignore case", true);
	
	//text fields
	protected JTextField filePath = new JTextField(15);
	protected JTextField wordSearched = new JTextField(8);
	
	// labels
	protected JLabel wordSearchedLabel = new JLabel("Word being counted");
	
	// panels
	protected JPanel browsePanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // used for browse and filepath.
	protected JPanel wordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // used for wordsearched and label.
	protected JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // used for final button.
	
	// borders
	TitledBorder border1 = new TitledBorder("Choose file");
	TitledBorder border2 = new TitledBorder("Enter word");

	
	public WordCounter() {
		// this builds the GUI in its entirety.
		
		filePath.setEditable(false);
		browse.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				filechooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));
				if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					file = filechooser.getSelectedFile();
					filePath.setText(file.getAbsolutePath());
				}
			}
		});
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					countWord(wordSearched.getText(), file);
				}
				
				catch (NoSuchElementException ex){
					JOptionPane.showMessageDialog(null, "Word not entered or contains whitespace.");
				}
				
				catch(NullPointerException ex){
					JOptionPane.showMessageDialog(null, "File not entered.");
				}
				
				catch (FileNotFoundException ex){
					JOptionPane.showMessageDialog(null, "File not found.");
				}
				
			}
		});
		wordSearched.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					countWord(wordSearched.getText(), file);
				}
				
				catch (NoSuchElementException ex){
					JOptionPane.showMessageDialog(null, "Word not entered or contains whitespace.");
				}
				
				catch(NullPointerException ex){
					JOptionPane.showMessageDialog(null, "File not entered.");
				}
				
				catch (FileNotFoundException ex){
					JOptionPane.showMessageDialog(null, "File not found.");
				}
			}
		});
		
		browsePanel.add(browse);
		browsePanel.add(filePath);
		browsePanel.setBorder(border1);
		wordPanel.add(wordSearchedLabel);
		wordPanel.add(wordSearched);
		wordPanel.add(ignoreCase);
		wordPanel.setBorder(border2);
		searchPanel.add(search);
		
		add(browsePanel, BorderLayout.NORTH);
		add(wordPanel, BorderLayout.CENTER);
		add(searchPanel, BorderLayout.SOUTH);
		setSize(350, 180);
		setTitle("Word Counter V1.0 - Made by Daniel F.");
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	// Main method
	public static void main(String[] args) {
			
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        new WordCounter();
		    }
		});
	
	}
	
	private void countWord(String word, File file) throws FileNotFoundException, NullPointerException, NoSuchElementException {
		// numRepeated counts how many times a word is repeated.
		int numRepeated = 0;
		
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter(Pattern.compile("[.,!()/\"-; ]")); // this makes sure to skip over punctuation.
		
		if (word.contains(" ") || word.equals(""))
			throw new NoSuchElementException();
		
		// while the scanner still has stuff to read, do this.
		while (scanner.hasNext()){
			
			//
			if (ignoreCase.isSelected()){ // if the ignore case checkbox is checked
				if (scanner.next().equalsIgnoreCase(word)){
					numRepeated++;
				}
			}
			else{ // if the ignore case checkbox isn't checked
				if (scanner.next().equals(word)){
					numRepeated++;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "The word " + "\"" + word + "\"" + 
				" is repeated " + numRepeated + " time(s) in the file."); 
		// once there's nothing left to read, results are displayed (above 2 lines)
		
	}
		
}
