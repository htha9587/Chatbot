package chat.view;

import java.awt.event.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import chat.controller.ChatbotController;

import java.awt.Color;

/**
 * 12-02-15
 * 
 * @author htha9587 Version 1.4
 */
public class ChatbotPanel extends JPanel {
	private ChatbotController baseController;
	private JButton firstButton;
	private JTextField firstTextField;
	private JTextArea firstTextArea;
	private SpringLayout baseLayout;
	private JLabel firstLabel;

	public ChatbotPanel(ChatbotController baseController) {
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new JButton("Chatbot's button.");

		firstTextField = new JTextField("Please type here");

		firstTextArea = new JTextArea("I'm an area!");

		firstLabel = new JLabel("Talk to Chatbot");

		setUpPanel();
		setUpLayout();
		setUpListeners();
	}

	/**
	 * Loads content into panel.
	 */

	private void setUpPanel() {
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(firstTextArea);
		this.add(firstLabel);
		firstTextArea.setEnabled(false);
		firstTextField.setToolTipText("Logic test");
		firstTextArea.setToolTipText("Mr Test");
		firstTextArea.setToolTipText("Mimick Test");
		firstLabel.setToolTipText("Testing!");
		/**
		 * Sets up Chatbot panel.
		 */
	}

	private void setUpLayout() {
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 134,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 10,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextArea, -230,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 93,
				SpringLayout.SOUTH, firstTextArea);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextArea, 155,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 37,
				SpringLayout.EAST, firstLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, firstLabel, 6,
				SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstLabel, 10,
				SpringLayout.WEST, this);
		/**
		 * Sets Layout.
		 */
	}

	private void setUpListeners()
	{
			firstButton.addActionListener(new ActionListener()
					{
					public void actionPerformed(ActionEvent click)
					{
						firstTextField.setText("Hi ho!");
					    String userText = firstTextField.getText(); //Grab user text.   x
						String response = baseController.fromUserToChatbot(userText); //Displays user text.  x
						firstTextArea.append("\nUser: " + userText); //Gives Text to model for processing.   x
						firstTextArea.append("\nChatbot: " + response); //Gets and displays answer.          x
						firstTextField.setText(""); //Clears user field.   x
						
					}
					
	});
		
			
			this.addMouseListener(new MouseListener()
			{
				public void mouseClicked(MouseEvent clicked)
				{
//			changeRandomColor();
				if(SwingUtilities.isLeftMouseButton(clicked))
				{
					
				}
				else if (SwingUtilities.isRightMouseButton(clicked))
				{
					
				}
			
			}
			
			public void mouseReleased(MouseEvent released)
			{
				changeRandomColor();
			}
			
			public void mousePressed(MouseEvent pressed)
			{
				
			}
			public void mouseEntered(MouseEvent entered)
			{
				changeRandomColor();
			}
			
			public void mouseExited(MouseEvent exited)
			{
//				changeRandomColor();
			}
		});
	
	
			this.addMouseMotionListener(new MouseMotionListener()
			{
				public void mouseMoved(MouseEvent moved)
				{
					
				}
				
				public void mouseDragged(MouseEvent dragged)
				{
					if(dragged.isAltDown())
					{
						
					}
				}
			});
		}
			private void changeRandomColor()
			{
				int red, green, blue;
				
				red = (int) (Math.random() * 256);
				green = (int) (Math.random() * 256);
				blue = (int) (Math.random() * 256);
				
				this.setBackground(new Color(red, green, blue));
			}
			
			public JTextField getTextField()
			{
				return firstTextField;
			}
		}