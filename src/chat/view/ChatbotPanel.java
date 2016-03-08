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
 * 3-8-16
 * 
 * @author htha9587 Version 1.8
 */
public class ChatbotPanel extends JPanel {
	private ChatbotController baseController;
	private JButton firstButton;
	private JButton fileSave;
	private JButton fileLoad;
	private JTextField firstTextField;
	private JTextArea firstTextArea;
	private SpringLayout baseLayout;
	private JLabel firstLabel;
	private JScrollPane chatPane;
	private JTextArea chatArea;
	private JButton twitterButton;
	private JButton searchTwitterButton;

	public ChatbotPanel(ChatbotController baseController) {
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new JButton("Chatbot's button.");
		firstTextField = new JTextField("Please type here",20);
		firstTextArea = new JTextArea("I'm an area!");
		firstLabel = new JLabel("Talk to Chatbot");
		fileSave = new JButton("Save to File ");
		fileLoad = new JButton("Load from File ");
		chatArea = new JTextArea(10,25);
		searchTwitterButton = new JButton("Search Twitter");
		twitterButton = new JButton("Send to Twitter ");
		
		
		setUpChatPane();
		setUpPanel();
		setUpLayout();
		setUpListeners();
		setUpListenersTwitter();
		setUpListenersSave();
		
	}



	private void setUpChatPane() 
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		chatArea.setBackground(Color.RED);
		chatPane = new JScrollPane(chatArea);
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
		this.add(twitterButton);
		this.add(chatPane);
		this.add(firstTextField);
		this.add(firstTextArea);
		this.add(firstLabel);
		this.add(searchTwitterButton);
		
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
		baseLayout.putConstraint(SpringLayout.WEST, firstLabel, 10,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, twitterButton, 0, SpringLayout.NORTH, searchTwitterButton);
		baseLayout.putConstraint(SpringLayout.EAST, twitterButton, -6, SpringLayout.WEST, searchTwitterButton);
		baseLayout.putConstraint(SpringLayout.NORTH, searchTwitterButton, 6, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, searchTwitterButton, 169, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, fileLoad, 0, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, fileLoad, -1, SpringLayout.WEST, fileSave);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 6, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 30, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, 250, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -30, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstLabel, 16, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, fileSave, 0, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, fileSave, -6, SpringLayout.WEST, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextArea, 150,
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
						
					    String userText = firstTextField.getText(); //Grab user text.   x
						String response = baseController.fromUserToChatbot(userText); //Displays user text.  x
						chatArea.append("\nUser: " + userText); //Gives Text to model for processing.   x
						chatArea.append("\nChatbot: " + response); //Gets and displays answer.          x
						firstTextField.setText(""); //Clears user field.   
					}
					
	}); }
			
			private void setUpListenersTwitter() 
			{
				twitterButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String userText = firstTextField.getText();
						String response = baseController.fromChatbottoTwitter(userText);
						chatArea.append("\nUser: " + userText);
						chatArea.append("\nUser: " + response);
						firstTextField.setText("");
					}
				
					
				});	
			}
			
				private void setUpListenersSave() 
				{
					fileSave.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent click)
						{
							String userText = chatArea.getText();
							baseController.bufferedWriter(userText);
							chatArea.append("\nUser: " + userText);
							firstTextField.setText("");
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