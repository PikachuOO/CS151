package cs151_assignment3;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class CaptionPanel extends JPanel {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = -8073474470479993782L;
	private static JTextField captionTextField;
	private static JLabel captionLabel;
	
	
	public CaptionPanel(int panelWidth, int panelHeight, int labelWidth, int padding){
				

		
		//---- Use the imports to set the panel size
		Dimension panelDimension = new Dimension(panelWidth, panelHeight);
		this.setSize(panelDimension);		
		this.setPreferredSize(panelDimension);
		this.setMinimumSize(panelDimension);
		this.setMaximumSize(panelDimension);
		this.setVisible(true);
		
		
		//------ Spring Layout Creation
		SpringLayout captionSpringLayout = new SpringLayout();
		this.setLayout(captionSpringLayout);
		
		//----- Create the captions
		captionLabel = new JLabel();
		captionLabel.setText("Caption:");
		this.add(captionLabel);
		
		//----- Set the captions layout constraints
		SpringLayout.Constraints captionLabelConstraints = captionSpringLayout.getConstraints(captionLabel);
		captionLabelConstraints.setX(Spring.constant(labelWidth - captionLabelConstraints.getWidth().getValue()));
		
		
		//---- Create and Add the Caption Field
		captionTextField = new JTextField("", JTextField.TRAILING);
		this.add(captionTextField);
		

		//----- Place the components relative to each other.
		captionSpringLayout.putConstraint(SpringLayout.WEST, captionTextField, padding, SpringLayout.EAST, captionLabel);	//---- Space the caption padding pixels from the label
		captionSpringLayout.putConstraint(SpringLayout.NORTH, captionTextField, padding, SpringLayout.NORTH, this);		//---- Space "padding" pixels from the top of the panel
		captionSpringLayout.putConstraint(SpringLayout.VERTICAL_CENTER, captionLabel, 0, SpringLayout.VERTICAL_CENTER, captionTextField); //---- Make the label and caption field centered with respect to one another
		
		//----- Set the size of the caption text field.
		Dimension captionTextFieldDimension = new Dimension(panelWidth - 2*padding - labelWidth, panelHeight - 2*padding);
		captionTextField.setSize(captionTextFieldDimension);
		captionTextField.setPreferredSize(captionTextFieldDimension);
		SpringLayout.Constraints captionTextFieldConstraints = captionSpringLayout.getConstraints(captionTextField);
		captionTextFieldConstraints.setWidth( Spring.constant( captionTextFieldDimension.width ) ); 
		
	}
	
	
	
	public void initialize(){
		captionTextField.setText(""); //---- Empty the TextArea
	}
	
	
}