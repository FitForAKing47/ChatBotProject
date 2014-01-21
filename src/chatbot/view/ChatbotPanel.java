package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatBotController;
import chatbot.model.Chatbot;

public class ChatbotPanel extends JPanel
{
	/**
	 * Establishes data members.
	 */
	private ChatBotController baseController;
	private Chatbot appBot;
	
	private SpringLayout baseLayout;
	private JButton submitChatButton;
	private JTextField userTextField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private int clickCount;

	public ChatbotPanel(ChatBotController baseController)
	{
		/**
		 * Creates a ChatbotPanel with a linked ChatbotController object.
		 * @param baseController The referenced controller.
		 */
		
		this.baseController = baseController;
		this.appBot = baseController.getAppBot();
		
		submitChatButton = new JButton("Click here to type to the chatbot!");
		baseLayout = new SpringLayout();
		userTextField = new JTextField(30);
		chatArea = new JTextArea(10, 30);
		chatPane = new JScrollPane(chatArea);
		
		
		clickCount = 0;
		
		setupPanel();		
		setupLayout();
		setupListeners();
		
		setupChat();
	}

	private void setupChat()
	{
		/**
		 * Starts the chatbot chat screen with a topic.
		 */
		chatArea.setText(appBot.getMemeTopic());
	}
	
	private void setupPanel()
	{
		/**
		 * Loads all components into panel and sets the layout manager and color.
		 */
		this.setBackground(Color.GREEN);
		this.setLayout(baseLayout);
		
		this.add(chatPane);
		this.add(submitChatButton);
		this.add(userTextField);
		
		
		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
		
		
	}
	
	
	private void setupListeners()
	{
		/**
		 * Creates listeners for all user interactive objects in the panel.
		 */
		submitChatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				clickCount++;
				String userInput = userTextField.getText();
				
				if(clickCount % 7 == 0)
				{
					String currentPhrase = baseController.dominateTheConversation();
					if(currentPhrase.length() != 0)
					{
						chatArea.append(currentPhrase);
						clickCount--;
					}
				}
				else if(clickCount % 5 == 0)
				{
					chatArea.append(baseController.memeValidation(userInput));
				}
				else if(clickCount % 4 == 0)
				{
					chatArea.append(baseController.colorValidation(userInput));
				}
				else if(clickCount % 3 == 0)
				{
					chatArea.append(baseController.randomValidation(userInput));
				}
				else if(clickCount % 2 == 0)
				{
					chatArea.append(baseController.fruitValidation(userInput));
				}
				else
				{
					chatArea.append("\n" + userInput);
					
					String processedInput = baseController.processUserInput(userInput);
					chatArea.append(processedInput);
					
					chatArea.append("\n" +appBot.getRandomTopic());
					userTextField.setText("");
					
					//This should be a method in the controller that would be returned as a string to place in the chatArea.
					String me, you, other;
					me = "Nathan";
					you = "Jake";
					other = "Berry";
					chatArea.append(appBot.putNameInAlphabeticOrder(me, you, other));
				}
				
				
			}
		});
	}
		
	

	private void setupLayout()
	{
		/**
		 * Places all objects with the computer generated code.
		 */
		baseLayout.putConstraint(SpringLayout.WEST, submitChatButton, 128, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, userTextField, 29, SpringLayout.SOUTH, submitChatButton);
		baseLayout.putConstraint(SpringLayout.WEST, userTextField, 102, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 93, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, 339, SpringLayout.WEST, this);
		setForeground(Color.CYAN);
		userTextField.setBackground(Color.CYAN);
		submitChatButton.setForeground(Color.BLUE);
		submitChatButton.setBackground(Color.CYAN);
		baseLayout.putConstraint(SpringLayout.NORTH, submitChatButton, 29, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 27, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 84, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -131, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -84, SpringLayout.EAST, this);
	}
}
