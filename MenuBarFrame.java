/**
 * 
 */
package Lab6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
/**

/**
 * @author David
 *
 */
public class MenuBarFrame extends JFrame implements ActionListener {
	
	private MenuBar menuBar; //Menu bar item
	private Menu file; //File menu item
	//File menu items
	private MenuItem calc; //Calculator Option
	private MenuItem currency; //Currency Converter Option
	private MenuItem multiTool; //MultiTool option
	
	private JPanel cards;
	//JPanels (cards)
	private Calculator cal;
	private Currency cur;
	private MultiTool mul;
	

	public MenuBarFrame(){
		this.setSize(250,300); //Initial size of the window frame
		this.setTitle("My Menu Frame"); //Set title
		WindowCloser listener = new WindowCloser();
		addWindowListener(listener);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
		
		// add our menu bar into the GUI
		menuBar = new MenuBar();
		file = new Menu();
		calc = new MenuItem();
		currency = new MenuItem();
		multiTool = new MenuItem();
		
		this.setMenuBar(menuBar);
		this.menuBar.add(file); 
		
		file.setLabel("File");
		
		//configure MenuItems
		this.calc.setLabel("Calculator"); // set the label of the menu item
		this.calc.addActionListener(this); // add an action listener 
		this.file.add(this.calc); // add it to the "File" menu
		
		this.currency.setLabel("Currency"); // set the label of the menu item
		this.currency.addActionListener(this); // add an action listener 
		this.file.add(this.currency); // add it to the "File" menu
		
		this.multiTool.setLabel("MultiTool"); // set the label of the menu item
		this.multiTool.addActionListener(this); // add an action listener 
		this.file.add(this.multiTool); // add it to the "File" menu
		
		//Create the "cards".
		cal = new Calculator();
		cur = new Currency();
		mul = new MultiTool();
		
		//Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add("Calculator", cal);
        cards.add("Currency Converter",cur);
        cards.add("Multi Tool", mul);
        
        contentPane.add(cards);
	}
	
	//Action Listener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.calc){
			//this.getContentPane().add(cal, "Center");
			((CardLayout)cards.getLayout()).show(cards, "Calculator");
		}
		if (e.getSource() == this.currency){
			//this.getContentPane().add(cur, "Center");
			((CardLayout)cards.getLayout()).show(cards, "Currency Converter");
		}
		if (e.getSource() == this.multiTool){
			//this.getContentPane().add(mul, "Center");
			((CardLayout)cards.getLayout()).show(cards, "Multi Tool");
		}
	}
	
	private class WindowCloser extends WindowAdapter{
		public void windowClosing(WindowEvent event){
			System.exit(0);
		}

	}
}
	
