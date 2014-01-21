package chatbot.view;

import javax.swing.JOptionPane;
import chatbot.model.Chatbot;

/**
 * GUI view for the Chatbot project
 * 
 * @author computer.class
 * @version 1.3 10/13/13
 */
public class ChatbotView
{
	/**
	 * Chatbot used for internal chat methods.
	 */
	private Chatbot myChatbot;

	public ChatbotView()
	{
		/**
		 * Makes Chatbot.
		 */
		myChatbot = new Chatbot();
	}

	public void showApp()
	{
		/**
		 * Captures the users input based on a question.
		 * 
		 * @return The String object typed by the user.
		 */
		String input = "keep going";

		while (input == null || !input.equals("no"))
		{
			JOptionPane.showMessageDialog(null, myChatbot.getRandomTopic());
			getInput();
		}

		myChatbot.conversationPiece();

	}

	private String getInput()
	{
		/**
		 * allows a the user to change the variable.
		 */
		String input = "";

		input = JOptionPane
				.showInputDialog("What would you want to talk with me about?");

		return input;
	}

	private void useInput(String userInput)
	{
		/**
		 * Allows user to use talk with computer.
		 */
		JOptionPane.showMessageDialog(null,
				"Wow that is so intersesting that you want to talk with me about "
						+ userInput);
		if (myChatbot.memeChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, "you knew that " + userInput
					+ " is a meme!!!");
		}
		JOptionPane.showMessageDialog(null,
				"Wow that is so intersesting that you want to talk with me about "
						+ userInput);
		if (myChatbot.fruitsChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, "you knew that " + userInput
					+ " is a meme!!!");
		}
		JOptionPane.showMessageDialog(null,
				"Wow that is so intersesting that you want to talk with me about "
						+ userInput);
		if (myChatbot.colorChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, "you knew that " + userInput
					+ " is a meme!!!");
		}
	}

}
