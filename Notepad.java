/**
 * 
 */
package Lab6;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

/**
 * @author David Kelly C00193216
 * Date: 20/04/2016
 * Java Notepad Application
 */
public class Notepad extends JFrame implements ActionListener {

	//Variables
	private TextArea textArea;
	private MenuBar menuBar; //Menu bar item
	private Menu file; //File menu item
	//File menu items
	private MenuItem openFile; //Open option
	private MenuItem saveFile; //Save option
	private MenuItem close; //Close option
	
	//Constructor
	public Notepad() {
		this.setSize(500, 500); //Initial size of the window frame
		this.setTitle("Java Notepad"); //Set title
		WindowCloser listener = new WindowCloser();
		addWindowListener(listener);
	
		
		textArea = new TextArea("", 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		this.getContentPane().setLayout(new BorderLayout()); 
		this.getContentPane().add(textArea);
		
		// add menu bar
		menuBar = new MenuBar();
		file = new Menu();
		openFile = new MenuItem();
		saveFile = new MenuItem();
		close = new MenuItem();
		
		this.setMenuBar(menuBar);
		this.menuBar.add(file); 
		
		file.setLabel("File");
		
		// OPEN option
		this.openFile.setLabel("Open"); // set  label of the menu item
		this.openFile.addActionListener(this); // add  action listener 
		this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false)); // keyboard shortcut
		this.file.add(this.openFile); // add to the "File" menu
 
		// SAVE option
		this.saveFile.setLabel("Save");
		this.saveFile.addActionListener(this);
		this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
		this.file.add(this.saveFile);
 
		// CLOSE option
		this.close.setLabel("Close");
		this.close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
		this.close.addActionListener(this);
		this.file.add(this.close);
		
		
	}
	//Action Listener
	public void actionPerformed(ActionEvent e) {
			// if the source was "close" option
			if (e.getSource() == this.close){
				this.dispose(); //close the application
			}
			// if the source was "open" option
			else if (e.getSource() == this.openFile) {
			JFileChooser open = new JFileChooser(); // open file chooser
			int option = open.showOpenDialog(this); // get the option user selected
				if (option == JFileChooser.APPROVE_OPTION) {
					textArea.setText(""); // clear the TextArea before applying the file contents
					try {
						// create scanner to read file
						Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
						while (scan.hasNext()){ //while there's something to read
							textArea.append(scan.nextLine() + "\n"); 
						}
					} 
					catch (Exception ex) { // catch any exceptions
							// write to the debug console
							System.out.println(ex.getMessage());
						}
				}
			}
				//  if source was "save" option
				else if (e.getSource() == this.saveFile) {
					JFileChooser save = new JFileChooser(); //open a file chooser
					int option = save.showSaveDialog(this); // similar to the open file, only this time we call
					if (option == JFileChooser.APPROVE_OPTION) {
						try {
							// create buffered writer to write to a file
							BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
							out.write(textArea.getText()); // write the contents of the TextArea to the file
							out.close(); // close the file stream
						} catch (Exception ex) { // catch any exceptions and...
							// write to the debug console
							System.out.println(ex.getMessage());
						}
					}
				}			
	}
	private class WindowCloser extends WindowAdapter{
		public void windowClosing(WindowEvent event){ //window closer sub class
			System.exit(0); //close window
		}

	}
}
