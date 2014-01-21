package chatbot.controller;

import java.util.ArrayList;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotView;

/**
 * Removed the references to the popup view. Added documentation..
 * 
 * @author nathan johnson
 * @version 1.4 10/13/13
 */

public class ChatBotController
{
	/**
	 * Getter method for the Chatbot instance.
	 * 
	 * @return The Chatbot for the application.
	 */

	// private ChatbotView appView;
	private Chatbot appBot;
	private ChatbotFrame appFrame;

	public ChatBotController()
	{
		// appView = new ChatbotView();
		appBot = new Chatbot();
	}

	public void start()
	{
		/**
		 * Tells it what to run.
		 */
		appFrame = new ChatbotFrame(this);
		// appView.showApp();
	}
	
	public String memeValidation(String currentInput)
	{
		String memeReaction = "Why aren't you talknig about the memes?";
		if(appBot.memeChecker(currentInput))
		{
			memeReaction = currentInput + " is the coolest meme huh?";
		}
		
		return memeReaction;
	}
	
	public String fruitValidation(String currentInput)
	{
		String fruitReaction = "Why aren't you talknig about the fruits?";
		if(appBot.fruitsChecker(currentInput))
		{
			fruitReaction = currentInput + " is the tastiest fruit huh?";
		}
		
		return fruitReaction;
	}
	public String randomValidation(String currentInput)
	{
		String randomReaction = "Why aren't you talknig about the random topics?";
		if(appBot.randomChecker(currentInput))
		{
			randomReaction = "Thats random huh?";
		}
		
		return randomReaction;
	}
	public String colorValidation(String currentInput)
	{
		String colorReaction = "Why aren't you talknig about the colors?";
		if(appBot.colorChecker(currentInput))
		{
			colorReaction = currentInput + " is the coolest color huh?";
		}
		
		return colorReaction;
	}
	
	private String conversationHelper(ArrayList<String> currentList)
	{
		String currentPhrase = "";
		
		if(currentList.size() < 0)
		{
			currentPhrase = currentList.remove(0);
		}
		
		return currentPhrase;
	}
	
	public String dominateTheConversation()
	{
		String currentConversationPeice = "";

		currentConversationPeice = conversationHelper(appBot.conversationPiece());
		
		return currentConversationPeice;
	}

	public String processUserInput(String currentInput)
	{
		/**
		 * Sets a variable and then sends it back.
		 */
		String response = "";

		if (appBot.memeChecker(currentInput))
		{
			response = "meme!!!";
		}
		else if (true)
		{

		}

		return response;

	}

	public Chatbot getAppBot()
	{
		/**
		 * Initilizes the ChatbotFrame for the GUI.
		 */
		return appBot;
	}
	

}