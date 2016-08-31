package resources;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Temperature extends JFrame {
	
	// Text Fields (just 2)
	private JTextField fahrenheit = new JTextField(10);
	private JTextField celsius = new JTextField(10);
	
	// Labels
	private JLabel celsiusLabel = new JLabel("Celsius");
	private JLabel fahrenheitLabel = new JLabel("Fahrenheit");
	
	// Border
	TitledBorder border = new TitledBorder("Conversion");
	
	JPanel panel = new JPanel(new GridLayout(2, 2));
	
	public Temperature(){
		
		fahrenheit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double input = Double.parseDouble(fahrenheit.getText());
				System.out.println("The Input is " + input);
				ConvertF(input);
			}
		});
		
		celsius.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double input = Double.parseDouble(celsius.getText());
				System.out.println("The Input is " + input);
				ConvertC(input);
			}
		});
		
		// adding components
		panel.add(fahrenheitLabel);
		panel.add(fahrenheit);
		panel.add(celsiusLabel);
		panel.add(celsius);
		panel.setBorder(border);
		
		add(panel);

		// setting up JFrame
		setLocationRelativeTo(null);
		setTitle("Temperature Converter");
		setSize(275, 125);
		setResizable(false);
		setVisible(true);
		
	}
	
	public static void main(String args[]){
		new Temperature();
	}
	
	protected void ConvertF(double in){
		double answer = (5.0/9.0) * (in - 32.0);
		answer = Math.round(100 * answer) / (100.0);
		celsius.setText(Double.toString(answer));
	}
	
	protected void ConvertC(double in){

		double answer = 1.8 * in + 32.0;
		answer = Math.round(100 * answer) / (100.0);
		fahrenheit.setText(Double.toString(answer));
	}
}
