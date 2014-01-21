package chatbot.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Model for the Chatbot project. Contains methods for evaluation Strings.
 * 
 * @author computer.class
 * @version 1.6 10/30/13
 * 
 */
public class Chatbot
{
	/**
	 * Establishes data members.
	 */

	private ArrayList<String> myColors;
	private ArrayList<String> myRandomList;
	private ArrayList<String> myFruits;
	private ArrayList<String> myMemeList;
	private ArrayList<String> conversationList;

	public Chatbot()
	{
		/**
		 * Uses variables.
		 */
		myMemeList = new ArrayList<String>();
		myColors = new ArrayList<String>();
		myRandomList = new ArrayList<String>();
		myFruits = new ArrayList<String>();
		conversationList = new ArrayList<String>();

		fillTheMemeList();
		fillThecolorList();
		fillTheRandomList();
		fillTheFruits();
		fillTheConversationList();

	}

	private void fillTheFruits()
	{
		/**
		 * Helper method to fill the myRandomList with strings.
		 */
		myFruits.add("cantalope");
		myFruits.add("apple");
		myFruits.add("orange");
		myFruits.add("honeydue");
	}

	public boolean fruitsChecker(String currentPhrase)
	{
		/**
		 * Checks the variables.
		 */
		boolean isFruits = false;

		if (currentPhrase != null)
		{
			for (String currentFruits : myFruits)
			{
				if (currentPhrase.equalsIgnoreCase(currentFruits))
				{
					isFruits = true;
				}
			}
		}

		return isFruits;

	}
	
	public boolean randomChecker(String currentPhrase)
	{
		/**
		 * Checks the variables.
		 */
		boolean isRandom = false;

		if (currentPhrase != null)
		{
			for (String currentRandom : myRandomList)
			{
				if (currentPhrase.equalsIgnoreCase(currentRandom))
				{
					isRandom = true;
				}
			}
		}

		return isRandom;

	}

	private void fillTheRandomList()
	{
		/**
		 * Helper method to fill the myRandomList with strings.
		 */
		myRandomList.add("penguins");
		myRandomList.add("I have to say something random?");
		myRandomList.add("you don't want that?");
		myRandomList.add("cat");

	}

	public String getRandomTopic()
	{
		/**
		 * Method to retrieve a random value from the myRandomList.
		 * 
		 * @return The String value randomly selected from the list.
		 */
		String randomTopic = "";

		double myRandomNumber = Math.random();
		int myRandomListPosition = (int) (myRandomNumber * myRandomList.size());
		randomTopic = myRandomList.get(myRandomListPosition);

		return randomTopic;
	}

	public String getMemeTopic()
	{
		/**
		 * Method to retrieve a random value from the myRandomList.
		 * 
		 * @return The String value randomly selected from the list.
		 */
		String memeTopic = "";

		double myMemeNumber = Math.random();
		int myMemeListPosition = (int) (myMemeNumber * myMemeList.size());
		memeTopic = myMemeList.get(myMemeListPosition);

		return memeTopic;
	}

	private void fillTheMemeList()
	{
		/**
		 * Establishes what the varables are.
		 */
		myMemeList.add("my jammies are rustled");
		myMemeList.add("cats");
		myMemeList.add("What does the fox say?");
		myMemeList.add("Philosoraptor");
		myMemeList.add("I am disappointed?");
	}

	public boolean memeChecker(String currentPhrase)
	{
		/**
		 * Checks the variables.
		 */
		boolean isMeme = false;

		if (currentPhrase != null)
		{
			for (String currentMeme : myMemeList)
			{
				if (currentPhrase.equalsIgnoreCase(currentMeme))
				{
					isMeme = true;
				}
			}
		}

		return isMeme;

	}

	private void fillThecolorList()
	{
		/**
		 * Establishes variables.
		 */
		myColors.add("red");
		myColors.add("blue");
		myColors.add("green");
		myColors.add("orange");
		myColors.add("purple");
	}

	public boolean colorChecker(String currentPhrase)
	{
		/**
		 * Checks the variables.
		 */
		boolean isColor = false;

		if (currentPhrase != null)
		{
			for (String currentcolor : myColors)
			{
				if (currentPhrase.equalsIgnoreCase(currentcolor))
				{
					isColor = true;
				}
			}
		}

		return isColor;
	}

	public String putNameInAlphabeticOrder(String first, String middle,
			String last)
	{
		/**
		 * Compares variables alphabetically.
		 */
		String sortedName = "";

		if (first.compareTo(middle) < 0)
		{
			if (first.compareTo(last) < 0)
			{
				if (middle.compareTo(last) < 0)
				{
					sortedName = first + ", " + middle + ", " + last;
				}
				else
				{
					sortedName = first + ", " + last + ", " + middle;
				}
			}
			else
			{
				sortedName = last + ", " + first + ", " + middle;
			}
		}
		else
		{
			if (middle.compareTo(last) < 0)
			{
				if (last.compareTo(first) < 0)
				{
					sortedName = middle + ", " + last + ", " + first;
				}
				else
				{
					sortedName = middle + ", " + first + ", " + last;
				}
			}
			else
			{
				sortedName = last + ", " + middle + ", " + first;
			}
		}

		return sortedName;
	}

	public String usesContent(String current)
	{
		/**
		 * Checks a String if it has a certain String in it.
		 */
		String processedString = "";
		if (current.contains("boo"))
		{
			processedString = "wooo scary";
		}
		else
		{
			processedString = "booooooring";
		}
		return processedString;
	}

	public void fillTheConversationList()
	{
		conversationList.add("I am dissapointed in you");
		conversationList.add("What does the fox say?");
		conversationList.add("Your a cheap bastard.");
		conversationList.add("Come on dude you need to work on that...");
		conversationList.add("You should be sorry.");
	}

	public ArrayList<String> conversationPiece()
	{
		/**
		 * The conversation part of the chatbot.
		 */
		return conversationList;

	}
}
