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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 2-29-16
 * 
 * @author htha9587 Version 1.6
 */
public class ChatbotPanel extends JPanel {
	private ChatbotController baseController;
	private JButton firstButton;
	private JButton fileSave;
	private JButton fileLoad;
	private JButton twitterSend;
	private JButton twitterSearch;
	private JTextField firstTextField;
	private JTextArea firstTextArea;
	private SpringLayout baseLayout;
	private JLabel firstLabel;
	private JScrollPane chatPane;
	private JTextArea chatArea;

	public ChatbotPanel(ChatbotController baseController) {
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new JButton("Chatbot's button.");
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, 0, SpringLayout.EAST, this);
		firstTextField = new JTextField("Please type here",20);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, 0, SpringLayout.EAST, this);
		firstTextArea = new JTextArea("I'm an area!");
		firstLabel = new JLabel("Talk to Chatbot");
		baseLayout.putConstraint(SpringLayout.NORTH, firstLabel, 16, SpringLayout.NORTH, this);
		twitterSend = new JButton("Send to Twitter ");
		twitterSearch = new JButton("Search Twitter");
		baseLayout.putConstraint(SpringLayout.WEST, twitterSearch, 123, SpringLayout.WEST, this);
		fileSave = new JButton("Save to File ");
		baseLayout.putConstraint(SpringLayout.NORTH, fileSave, 0, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, fileSave, -6, SpringLayout.WEST, firstButton);
		fileLoad = new JButton("Load from File ");
		baseLayout.putConstraint(SpringLayout.NORTH, fileLoad, 0, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, fileLoad, -6, SpringLayout.WEST, fileSave);
		chatArea = new JTextArea(10,25);
		
		
		setUpChatPane();
		setUpPanel();
		setUpLayout();
		setUpListeners();
	}

	private void setUpChatPane() 
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		chatArea.setBackground(Color.RED);
		chatPane = new JScrollPane(chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 6, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 30, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, 250, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -30, SpringLayout.EAST, this);
		chatPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	/**
	 * Loads content into panel.
	 */

	private void setUpPanel() {
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(fileSave);
		this.add(fileLoad);
		this.add(chatPane);
		this.add(twitterSend);
		this.add(twitterSearch);
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
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextArea, -230,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextArea, 155,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstLabel, 10,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, twitterSend, 6, SpringLayout.SOUTH, firstTextArea);
		baseLayout.putConstraint(SpringLayout.WEST, twitterSend, 122, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, twitterSearch, 6, SpringLayout.SOUTH, twitterSend);
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
						
					    String userText = firstTextField.getText(); //Grab user text.   x
						String response = baseController.fromUserToChatbot(userText); //Displays user text.  x
						firstTextArea.append("\nUser: " + userText); //Gives Text to model for processing.   x
						firstTextArea.append("\nChatbot: " + response); //Gets and displays answer.          x
						firstTextField.setText(""); //Clears user field.   
					}
					
	});
		
		/**
		 * Checks for mouse  to change window color.	
		 */
			this.addMouseListener(new MouseListener()
			{
				public void mouseClicked(MouseEvent clicked)
				{
		changeRandomColor();
				if(SwingUtilities.isLeftMouseButton(clicked))
				{
					
				}
				else if (SwingUtilities.isRightMouseButton(clicked))
				{
					
				}
			
			}
			
			public void mouseReleased(MouseEvent released)
			{
	//			changeRandomColor();
			}
			
			public void mousePressed(MouseEvent pressed)
			{
				
			}
			public void mouseEntered(MouseEvent entered)
			{
		//		changeRandomColor();
			}
			
			public void mouseExited(MouseEvent exited)
			{
//				changeRandomColor();
			}
		});
	
	/**
	 * Checks for mouse motion to change color.
	 */
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
	/**
	 * Changes color randomly when mouse is clicked.
	 */
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