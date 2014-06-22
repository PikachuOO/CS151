package cs151_assignment3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SlideShowJMenuBar extends JMenuBar implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1686924456234878847L;
	private static JMenu fileMenu;
	
	private static JFileChooser openFileChooser;
	private static JFileChooser saveFileChooser;
	
	
	public static final int NEW_FILE_LISTENER = 0;
	public static final int OPEN_FILE_LISTENER = 1;
	public static final int SAVE_FILE_LISTENER = 2;
	
	
	/**
	 * Constructor for the Slide Show GUI Menu Bar.
	 */
	public SlideShowJMenuBar(){
		

		
		//----- Create the JMenu
		fileMenu = new JMenu("File");
		
		//----- Create the "File" menu items.
		String[] menuLabels = { "New", "Open", "Save", "Exit" };
		
		//----- Add the menu items to the JMenu
		for(int i = 0; i < menuLabels.length; i++){
			
			JMenuItem menuItem = new JMenuItem(menuLabels[i]);
			menuItem.setActionCommand("fileMenu" + menuLabels[i]);
			menuItem.addActionListener(this); //---- The class is its own action listener
			
			fileMenu.add(menuItem); //---- Add the menu item to the list
		}
		
		//---- Create the menu bar.
		this.add(fileMenu);
		
		//----- Create the open file chooser
		FileFilter fileNameExtensionFiter = new FileNameExtensionFilter("Slide Show Files (*.show)", "show" );//---- File extension is "show". Use for all file tools
		openFileChooser = new JFileChooser();
		openFileChooser.setFileFilter( fileNameExtensionFiter );		
	
		//----- Create the Save File Chooser
		saveFileChooser = new JFileChooser();
		saveFileChooser.setFileFilter( fileNameExtensionFiter );
		
		
	}
	
	
	
	public void addActionListener( ActionListener listener, int objectType ){
		
		switch(objectType){
			case NEW_FILE_LISTENER:
				//---- Iterate through all the menu items
				for(Component menuComponent : fileMenu.getMenuComponents()){
					
					JMenuItem menuItem = (JMenuItem)menuComponent;
					//---- Check if the "New" Menu Item
					if(objectType == NEW_FILE_LISTENER && menuItem.getText().toLowerCase().equals("new")){
						menuItem.addActionListener(listener);
						return;
					}
				}
				return;
			case OPEN_FILE_LISTENER:
				openFileChooser.addActionListener(listener);
				return;
			case SAVE_FILE_LISTENER:
				saveFileChooser.addActionListener(listener);
				return;
		}
	}
		
	/**
	 * Action Listener for the Menu bar.  Menu items that have effects are Open, Save, and Exit.
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("fileMenuNew")){
		}
		else if(e.getActionCommand().equals("fileMenuOpen")){
			openFileChooser.showOpenDialog(null);
		}
		else if(e.getActionCommand().equals("fileMenuSave")){
			saveFileChooser.showSaveDialog(null);
		}
		else if(e.getActionCommand().equals("fileMenuExit")){
			menuExitAction();
		}		
	}
	
	
	/**
	 * Closes the entire GUI.
	 */
	private void menuExitAction(){
		System.exit(0); //---- Kill the program
	}	
	
}
