package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatBotController;

public class ChatbotFrame extends JFrame
{
	/**
	 * Establishes data members.
	 */
	private ChatBotController baseController;
	private ChatbotPanel basePanel;

	public ChatbotFrame(ChatBotController baseController)
	{
		/**
		 * Sets up the Chatbot frame.
		 */
		this.baseController = baseController;
		basePanel = new ChatbotPanel(baseController);

		setupFrame();
	}

	private void setupFrame()
	{
		/**
		 * Sets up the chatbot frame.
		 */
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		this.setVisible(true);
	}
}
