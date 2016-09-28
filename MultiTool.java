/**
 * 
 */
package Lab6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * @author David
 *
 */
public class MultiTool extends JPanel {
	
	private JTextField display;
	private JButton equBtn, decBtn,b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, clr;
	private JComboBox c1;
	private static double numC = 0;
	private static String numberString = "";
	
	public MultiTool(){
		
		this.setLayout(new BorderLayout());
		
		display = new JTextField();
		clr = new JButton("CLR");
		equBtn = new JButton("=");
		decBtn = new JButton(".");
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		
		//COMBO BOX**********************************************
		String[] currency= {"Inches -> Feet","£ -> € ","Cel -> Fah","Fah -> Cel"};
		c1= new JComboBox(currency);
		c1.setSelectedIndex(0);
		
		//BUTTON LISTENER**********************************************
		ButtonListener bListener = new ButtonListener();

		equBtn.addActionListener(bListener);
		decBtn.addActionListener(bListener);
		b0.addActionListener(bListener);
		b1.addActionListener(bListener);
		b2.addActionListener(bListener);
		b3.addActionListener(bListener);
		b4.addActionListener(bListener);
		b5.addActionListener(bListener);
		b6.addActionListener(bListener);
		b7.addActionListener(bListener);
		b8.addActionListener(bListener);
		b9.addActionListener(bListener);
		clr.addActionListener(bListener);
		c1.addActionListener(bListener);
		
		//DISPLAY PANEL*****************************************
		JPanel d = new JPanel();
		d.setLayout(new GridLayout(2,1));
		d.add(display);
		d.add(c1);
		
		//KEYPAD************************************************
		JPanel keypad = new JPanel();
		keypad.setLayout(new GridLayout(4,3));
		keypad.add(b7);
		keypad.add(b8);
		keypad.add(b9);
		keypad.add(b4);
		keypad.add(b5);
		keypad.add(b6);
		keypad.add(b1);
		keypad.add(b2);
		keypad.add(b3);
		keypad.add(decBtn);
		keypad.add(b0);
		keypad.add(clr);
				
		//Add components to Currency Panel
		this.add(d, "North");
		this.add(keypad, "Center");
		this.add(equBtn, "South");
	}
	
	private class ButtonListener implements ActionListener {

	     public void actionPerformed(ActionEvent e) {
	    	 if (e.getSource() == clr) {
	            numberString = "";
	            numC = 0;
	            display.setText(numberString);
	        } 
	    	else if (e.getSource() == decBtn) {
	    		
	    		if(numberString != ""){
		    		numberString += ".";
		    	}
	    		display.setText(numberString);
	        } 
	    	else if (e.getSource() == b1) {
	            numberString += "1";
	            display.setText(numberString);
	        } 
	        else if (e.getSource() == b2) {
	            numberString += "2";
	            display.setText(numberString);
	        }
	        else if (e.getSource() == b3) {
	            numberString += "3";
	            display.setText(numberString);
	        }
	        else if (e.getSource() == b4) {
	            numberString += "4";
	            display.setText(numberString);
	        }
	        else if (e.getSource() == b5) {
	            numberString += "5";
	            display.setText(numberString);
	        }
	        else if (e.getSource() == b6) {
	            numberString += "6";
	            display.setText(numberString);
	        }
	        else if (e.getSource() == b7) {
	            numberString += "7";
	            display.setText(numberString);
	        }
	        else if (e.getSource() == b8) {
	            numberString += "8";
	            display.setText(numberString);
	        }
		    else if (e.getSource() == b9) {
		        numberString += "9";
		        display.setText(numberString);
		    }
		    else if (e.getSource() == b0) {
		    	numberString += "0";
		    	display.setText(numberString);
		    }
		    else if (e.getSource() == equBtn) {
		    	if(numberString != "")
		    	{
		    		numC = Double.parseDouble(display.getText());
		    		//inches -> feet*******************************************
		    		if(c1.getSelectedIndex() == 0){
			    		numC = numC / 12;
			    		}
		    		//pounds -> euro*******************************************
		    		else if(c1.getSelectedIndex() == 1){
			    		numC = numC * 1.29;
			    		}
		    		//cels -> fah**********************************************
		    		else if(c1.getSelectedIndex() == 2){
			    		numC = (numC * 9/5) + 32;
			    		}
		    		//fah -> cels**********************************************
		    		else if(c1.getSelectedIndex() == 3){
			    		numC = (numC - 32) * 0.55555555555; 
			    		}
		    				display.setText(String.valueOf(new Double(numC)));
		    	}
		    	numberString = "";
		    	
		    }
	    }
	
	}

}
