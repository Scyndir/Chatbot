package chat.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The model for our Chatbot project. Used for exploration of string methods and text processing. 
 * It's a bit dumb, but that's alright
 * @author Michael Watts
 *
 */
public class Chatbot
{
	private String name;
	private int greetingCount;
	private int farewellCount;
	
	public Chatbot(String name)
	{
		this.name = name;
		this.greetingCount = 0;
		this.farewellCount = 4;
	}
	
	@Override
	public String toString()
	{
		String description = "I am a Chatbot called: " + name + "\n";
		description += "My favourite topic is: N/A";
		
		return description;
	}

	/**
	 * Processes supplied text and provides response for external method calls.
	 * @param text The text sent from the user via Controller.
	 * @return The chatbot's answer to continue conversation.
	 */
	public String processText(String text)
	{	
		String response = "";//sayGreeting() + "\nYou said: ";
		
		response += sayGreeting() + "\n";
		
		if (text.toLowerCase().indexOf("date") >= 0)
		{
			response += getDate() + "\n";
		}
		
		if (text.toUpperCase().indexOf("TIME") >= 0)
		{
			response += getTime() + "\n";
		}
		
		if (isPolitical(text))
		{
			response += respondToPolitical() + "\n";
		}
		
		if (isPolite(text))
		{
			response += respondToPolite() + "\n";
		}
		
		if (containsQuestion(text))
		{
			response += answerQuestion(text) + "\n";
		}

		response += getRandomTopic() + "\n";
				
		return response;
	}
	/**
	 * A simple method used to greet people interacting with chatbot.
	 * @return returns one of 5 possible greetings
	 */
	public String sayGreeting()
	{
		String greeting = "";
		
		ArrayList<String> greetings = new ArrayList<String>();
		
		greetings.add("Hi there!");
		greetings.add("Hello");
		greetings.add("G'day mate");
		greetings.add("Howdy");
		greetings.add("What's up?");
		
		greeting = greetings.get(greetingCount);
		greetingCount++;
		if (greetingCount == greetings.size())
		{
			greetingCount = 0;
		}
		
		return greeting;
	}
	/**
	 * A method that corresponds to sayGreeting, except this is for ending a conversation with a farewell.
	 * @return similar to sayGreeting, returns one of 5 possible farewells
	 */
	public String sayFarewell()
	{
		String farewell = "";
		
		ArrayList<String> farewells = new ArrayList<String>();
		
		farewells.add("Goodbye");
		farewells.add("Au revoir");
		farewells.add("Do svidaniya");
		farewells.add("cya");
		farewells.add("Have a good day!");
		
		farewell = farewells.get(farewellCount);
		
		if (farewellCount == 0)
		{
			farewellCount = 4;
		}
		farewellCount--;
		return farewell;
	}
	
	public String getName()
	{
		name = "My name is " + this.name;
		return name;
	}
	
	private String getDate()
	{
		String date = "The date is ";
		
		LocalDateTime currentDate = LocalDateTime.now();
		
		String day = currentDate.getDayOfWeek().toString();
		
		date += day + ", ";
		
		day = "the " + currentDate.getDayOfMonth() + " ";
		
		date += day + "of ";
		
		String month = currentDate.getMonth().toString();
		
		date += month + ", " + currentDate.getYear();
		
		return date;
	}
	
	private String getTime()
	{
		String time = "The time is ";
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		time += currentTime.getHour() + ":";
		time += currentTime.getMinute();
		
		
		
		return time;
	}
	
	private String getRandomTopic()
	{
		String topic = "";
		
		
		ArrayList<String> randomTopics = new ArrayList<String>();
		
		randomTopics.add("Pancakes or waffles?");
		randomTopics.add("Have you read Ready Player One?");
		randomTopics.add("What's your favourite flavour of ice cream?");
		randomTopics.add("I would love some coffee right now");
		randomTopics.add("What is your favourite academic subject?");
		randomTopics.add("What's the largest word you know?");
		randomTopics.add("What is your favourite dinosaur");
		randomTopics.add("Where would you take a first date?");
		randomTopics.add("I love hiking, do you?");
		randomTopics.add("Do you enjoy wakeboarding?");
		
		int randomIndex = (int) (Math.random() * randomTopics.size());
		
		topic = randomTopics.get(randomIndex);
		
		return topic;
	}
	
	private boolean isPolitical(String parameter)
	{
		boolean political = false;
		
		ArrayList<String> politics = new ArrayList<String>();
		
		politics.add("politics");
		politics.add("republican");
		politics.add("democrat");
		politics.add("election");
		politics.add("biden");
		
		for (String current : politics)
		{
			if (parameter.toLowerCase().indexOf(current) >= 0)
			{
				political = true;
			}
		}
		
		return political;
	}
	
	private boolean isPolite(String parameter)
	{
		boolean polite = false;
		
		ArrayList<String> politeness = new ArrayList<String>();
		
		politeness.add("please");
		politeness.add("thank you");
		
		for (String current : politeness)
		{
			if (parameter.toLowerCase().indexOf(current) >= 0)
			{
				polite = true;
			}
		}
		return polite;
	}
	
	private String respondToPolite()
	{
		String response = "How polite of you!";
		
		return response;
	}
	
	private String respondToPolitical()
	{
		String response = "gross, politics";
		
		return response;
	}
	
	private boolean containsQuestion(String parameter)
	{
		boolean question = false;
		
		ArrayList<String> questionWords = new ArrayList<String>();
		
		questionWords.add("?");
		questionWords.add("can you");
		questionWords.add("will you");
		
		for (String index : questionWords)
		{
			if (parameter.toLowerCase().indexOf(index) >= 0)
			{
				question = true;
			}
		}
		
		return question;
	}
	
	private String answerQuestion(String parameter)
	{
		String answer = parameter;
		
		ArrayList<String> questionWords = new ArrayList<String>();
		ArrayList<String> identifiers = new ArrayList<String>();
		
		questionWords.add("can you");
		questionWords.add("will you");
		identifiers.add(" i ");
		identifiers.add(" me");
		
		for (String index : identifiers)
		{
			if (parameter.toLowerCase().contains(index))
			{
				answer = answer.replace(index, " you");
			}
		}
		
		for (String index : questionWords)
		{
			if (parameter.toLowerCase().contains(index))
			{
				answer = answer.replace(index, "You asked me to");
			}
		}
		
		if (parameter.toLowerCase().contains("?"))
		{
			answer = answer.replace("?", "");
		}
		
		answer += ". That is very interesting.";
		
		return answer;
	}
	
	public String getMostCommonWord(ArrayList<String> source)
	{
		String common = "";
		
		ArrayList<String> actualWords = new ArrayList<String>();
		
		for (String sentence : source)
		{
			String [] words = sentence.split(" ");
			for (String word : words)
			{
				actualWords.add(word);
			}
		}
		
		int most = 0;
		
		for (int index = 0; index < actualWords.size(); index++)
		{
			String current = actualWords.get(index);
			int count = 1;
			
			for (int inner = index + 1; inner < actualWords.size(); inner++)
			{
				if (actualWords.get(inner).equalsIgnoreCase(current))
				{
					count++;
				}
			}
			if (count > most)
			{
				most = count;
				common = current;
			}
		}
		
		common = "The most common word was: " + common + ", and it occurs: " + most + " times";
		return common;
	}
//	public ArrayList<String> getUserInputs()
//	{
//		return this.userInputs;
//	}
//	
//	public ArrayList<String> getChatbotResponses()
//	{
//		return this.chatbotResponses;
//	}
//	
//	public void setUserInputs(ArrayList<String> input) 
//	{
//		this.userInputs = input;
//	}
//	
//	public void setChatbotResponses(ArrayList<String> responses)
//	{
//		this.chatbotResponses = responses;
//	}
//	
}
