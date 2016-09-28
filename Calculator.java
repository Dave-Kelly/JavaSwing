/**
 * 
 */
package Lab6;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * @author David Kelly c00193216
 * Date: 15/03/2016
 * Calculator Application
 */
public class Calculator extends JPanel{
	
	//VARIABLES
	private JTextField display; //Display
	private JButton addBtn, subBtn, mulBtn, divBtn, equBtn, decBtn, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, clr;
	private static double num1 = 0; //Calculation variables
	private static double num2 = 0; //Calculation variables
	private static String op = "";  //Calculation operand
	private static String numberString = " "; //Display string (input/output)

	public Calculator(){
		this.setLayout(new BorderLayout());
		display = new JTextField();
		addBtn = new JButton("+");
		subBtn = new JButton("-");
		mulBtn = new JButton("*");
		divBtn = new JButton("/");
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
		
		ButtonListener bListener = new ButtonListener();
		addBtn.addActionListener(bListener);
		subBtn.addActionListener(bListener);
		mulBtn.addActionListener(bListener);
		divBtn.addActionListener(bListener);
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
		
		JPanel keypad = new JPanel();
		keypad.setLayout(new GridLayout(4,4));
		
		keypad.add(addBtn);
		keypad.add(b7);
		keypad.add(b8);
		keypad.add(b9);
		
		keypad.add(subBtn);
		keypad.add(b4);
		keypad.add(b5);
		keypad.add(b6);
		
		keypad.add(mulBtn);
		keypad.add(b1);
		keypad.add(b2);
		keypad.add(b3);
		
		keypad.add(divBtn);
		keypad.add(decBtn);
		keypad.add(b0);
		keypad.add(clr);
		
		this.add(display, "North");
		this.add(keypad, "Center");
		this.add(equBtn, "South");
	
	}
	private class ButtonListener implements ActionListener {

	     public void actionPerformed(ActionEvent e) {
	    	if (e.getSource() == clr) {
	            numberString = "";
	            num1 = 0;
	            num2 = 0;
	            op = "";
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
		    else if (e.getSource() == addBtn) {
		    	num1 = Double.parseDouble(display.getText());
		    	op = "+";
		    	numberString = "";
		    	display.setText(numberString);
		    }
		    else if (e.getSource() == subBtn) {
		    	num1 = Double.parseDouble(display.getText());
		    	op = "-";
		    	numberString = "";
		    	display.setText(numberString);
		    }
		    else if (e.getSource() == mulBtn) {
		    	num1 = Double.parseDouble(display.getText());
		    	op = "*";
		    	numberString = "";
		    	display.setText(numberString);
		    }
		    else if (e.getSource() == divBtn) {
			    num1 = Double.parseDouble(display.getText());
			    op = "/";
		    	numberString = "";
		    	display.setText(numberString);
		    }
		    else if (e.getSource() == equBtn) {
		    	if(numberString != "")
		    	{
			    	num2 = Double.parseDouble(display.getText());
			    	if(op == "+")
			    	{
			    		display.setText(String.valueOf(new Double(num1 + num2)));
			    	}
			    	else if(op == "-")
			    	{
			    		display.setText(String.valueOf(new Double(num1 - num2)));
			    	}
			    	else if(op == "*")
			    	{
			    		display.setText(String.valueOf(new Double(num1 * num2)));
			    	}
			    	else if(op == "/")
			    	{
			    		display.setText(String.valueOf(new Double(num1 / num2)));
			    	}
		    	}
		    	numberString = "";
		    	
		    }
	    }
	
	}
}