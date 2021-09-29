package chat.model;

import java.time.LocalDateTime;

public class Chatbot
{
	private String name;
	
	public Chatbot(String name)
	{
		this.name = name;
	}
	public String processText(String text)
	{
		String response = "You said: ";
		
		response += text + "\n";
		
		response += getDate() + "\n";
		
		response += getTime();
		
		return response;
	}
	
	
	
	@Override
	public String toString()
	{
		String description = "I am a Chatbot called: " + name + "\n";
		description += "My favourite topic is: N/A";
		
		return description;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getDate()
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
	
	public String getTime()
	{
		String time = "The time is ";
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		time += currentTime.getHour() + ":";
		time += currentTime.getMinute();
		
		
		
		return time;
	}
}
