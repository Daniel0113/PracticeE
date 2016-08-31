package resources;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Meters extends JFrame {
	// Panel
	JPanel center = new JPanel(new GridLayout(5, 2, 10, 10));
	// All labels
	private JLabel labelmm = new JLabel("Millimeters");
	private JLabel labelcm = new JLabel("Centimeters");
	private JLabel labeldm = new JLabel("Decimeters");
	private JLabel labelm = new JLabel("Meters");
	private JLabel labelkm = new JLabel("Kilometers");
	
	// All text Fields
	private JTextField mm = new JTextField(7);
	private JTextField cm = new JTextField(7);
	private JTextField dm = new JTextField(7);
	private JTextField m = new JTextField(7);
	private JTextField km = new JTextField(7);
	
	public Meters(){
		
		// Adding Components
		setLayout(new BorderLayout());
		center.add(labelmm);
		center.add(mm);
		center.add(labelcm);
		center.add(cm);
		center.add(labeldm);
		center.add(dm);
		center.add(labelm);
		center.add(m);
		center.add(labelkm);
		center.add(km);
		add(center, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setSize(350, 200);
		setTitle("Metric Length Converter");
		setVisible(true);
		
		// ActionListeners
		mm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				convertMM();
				
			}
		});
		
		dm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				convertDM();
				
			}
		});
		
		cm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				convertCM();
				
			}
		});
		
		m.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				convertM();
				
			}
		});
		
		km.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				convertKM();
				
			}
		});
	}
	
	public static void main(String[] args) {
		
		new Meters();

	}
	
	private void convertMM(){
		
		double n = Double.parseDouble(mm.getText());
		
		double centimeters = n * 0.1;
		cm.setText("" + centimeters);
		
		double decimeters = n * 0.01;
		dm.setText("" + decimeters);
		
		double meters = n * 0.001;
		m.setText("" + meters);
		
		double kilometers = n * 0.000001;
		km.setText("" + kilometers);
		
	}
	
	private void convertCM(){
		
		double n = Double.parseDouble(cm.getText());
		
		double millimeters = n * 10;
		mm.setText("" + millimeters);
		
		double decimeters = n * 0.1;
		dm.setText("" + decimeters);
		
		double meters = n * 0.01;
		m.setText("" + meters);
		
		double kilometers = n * 0.00001;
		km.setText("" + kilometers);
	}
	
	private void convertDM(){
		
		double n = Double.parseDouble(dm.getText());
		
		double millimeters = n * 100;
		mm.setText("" + millimeters);
		
		double centimeters = n * 10;
		cm.setText("" + centimeters);
		
		double meters = n * 0.1;
		m.setText("" + meters);
		
		double kilometers = n * 0.0001;
		km.setText("" + kilometers);
		
	}
	
	private void convertM(){
		
		double n = Double.parseDouble(m.getText());
		
		double millimeters = n * 1000;
		mm.setText("" + millimeters);
		
		double centimeters = n * 100;
		cm.setText("" + centimeters);
		
		double decimeters = n * 10;
		dm.setText("" + decimeters);
		
		double kilometers = n * 0.001;
		km.setText("" + kilometers);
		
	}
	
private void convertKM(){
		
		double n = Double.parseDouble(km.getText());
		
		double millimeters = n * 1000000;
		mm.setText("" + millimeters);
		
		double centimeters = n * 100000;
		cm.setText("" + centimeters);
		
		double decimeters = n * 10000;
		dm.setText("" + decimeters);
		
		double meters = n * 1000;
		m.setText("" + meters);
		
	}
	

}
