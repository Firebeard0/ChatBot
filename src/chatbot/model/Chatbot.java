package chatbot.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;


public class Chatbot

//declares the variables
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	private String []  letters;
	
	//initializes variables
	public Chatbot(String username)
	{
		this.movieList = new  ArrayList<Movie>();
		this.shoppingList = new  ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String[10];                             
		this.username = username;
		this.content = "Content"; 
		this.intro = "";
		this.currentTime = LocalTime.now();
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		this.letters = new String [26];
		
		buildVerbs();
		buildTopics();
//		buildFollowups();
		buildQuestions();
		buildShoppingList();
		buildMovieList();
		buildCuteAnimals();
		toString();
	}

	private void alphabet()
	{
		letters[1] = "a";
		letters[2] = "b";
		letters[3] = "c";
		letters[4] = "d";
		letters[5] = "e";
		letters[6] = "f";
		letters[7] = "g";
		letters[8] = "h";
		letters[9] = "";
		letters[10] = "j";
		letters[11] = "k";
		letters[12] = "l";
		letters[13] = "m";
		letters[14] = "n";
		letters[15] = "o";
		letters[16] = "p";
		letters[17] = "q";
		letters[18] = "r";
		letters[19] = "s";
		letters[20] = "t";
		letters[21] = "u";
		letters[22] = "v";
		letters[23] = "w";
		letters[24] = "x";
		letters[25] = "y";
		letters[26] = "z";
		
	}
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	private void buildMovieList()
	{
		movieList.add(new Movie("Captain America"));
		movieList.add(new Movie("Thor"));
		movieList.add(new Movie("Hulk"));
		movieList.add(new Movie("Ironman"));
		movieList.add(new Movie("Spiderman"));
		movieList.add(new Movie("Hidden Figures"));
	}
	// makes a list containing strings about food
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("crab");
		shoppingList.add("salmon");
		shoppingList.add("gold fish");
		shoppingList.add("oreos");
		shoppingList.add("chips");
		shoppingList.add("lasagna");
		shoppingList.add("pizza");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("floofer");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("dog");
		cuteAnimalMemes.add("bear");
	}
	private void buildTopics()
	{
		topics[0]="animals";
		topics[1]="Disney land";
		topics[2]="cannibals";
		topics[3]="school";
		topics[4]="superheroes";
		topics[5]="stupidity";
		topics[6]="ferocity";
	}
	private void buildQuestions()
	{
		questions[0]="What is your name?";
		questions[1]="What is your favorite color?";
		questions[2]="What is your weight?";
		questions[3]="What is your number?";
		questions[4]="What is your adress?";
		questions[5]="What is your call sign?";
		questions[6]="What is your favorite car?";
		questions[7]="What is your favorite candy?";
		questions[8]="What is your hair color?";
		questions[9]="What is your toothbrush color?";
		
	}
	/**
	 * puts together 
	 * @param input
	 * @return
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		currentTime = LocalTime.now();
		chatbotResponse+= currentTime.getHour() + ":" + currentTime.getMinute() +  " ";
		chatbotResponse += "you said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	/**
	 * builds how the chatbot will respond
	 * @return the response to the input
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		
		random = (int) (Math.random() * topics.length);
		response  += " " + topics[random] + ". \n";
		
		random = (int) (Math.random() * 2);
				
			if (random % 2 == 0)
			{
				random = (int) (Math.random() * movieList.size());
				response += "\n" +  movieList.get(random).getTitle() + " is a great movie!";
			}
		return response;
	}
	/**
	 * Takes the input and makes sure it's long enough
	 * @param input
	 * @return if the input is long enough or not
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null)
		{
			if (input.length() > 2)
			{
				validLength = true;
			}
		}
		
		
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		if(!input.contains("<") && !input.contains(">"))
		{
			return false;
		}
		else if(input.contains("<>"))
			{
				return false;
			}
		else if (input.contains("< >"))
		{
			return false;
		}
		for (int i = 0; i < 27; i++)
		{
			if (input.toLowerCase().contains("<" + letters[i] + ">") && !input.toLowerCase().contains("</" + letters[i] + ">"))
			{
				return false;
			}
		}
		return true;
//		else if(input.contains("<B>") && !input.contains("</B>"))
//		{
//			return false;
//		}
//		else if(input.contains("<I>") && !input.contains("</i>"))
//		{
//			return false;
//		}
		
		
	} 
	/**
	 * checks the user name
	 * @param input takes in user name
	 * @return if the user name is valid or not
	 */
	public boolean userNameChecker(String input)
	{
		boolean valid = false;
		if (input != null && input.startsWith("@") && !input.substring(1, input.length() - 1).contains("@")) {
			valid = true;
		}
		return valid;
	}
/**
 * checks if the input is usable
 * @param contentCheck takes in the content
 * @return the validity of the content
 */
	public boolean contentChecker(String contentCheck)
	{
		boolean valid = false;
		if (contentCheck == content)
		{
			valid = true;
		}
		
		
		for (int i=0; i >  contentCheck.length(); i++ )
		{
			if (contentCheck.substring(i, i + 1) == " ") 
			{
				valid = false;
			}
		}
		
		if (contentCheck.length() > 5)
		{
			valid = true;
		}
		return valid;
	}
	/**
	 * Checks memes to see if it's not racist
	 * @param input the meme's name
	 * @return if the meme isn't racist it will pass as valid
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean valid = true;
		if (input == "pepe")
		{
			valid = false;
		}
		return valid;
	}
/**
 * looks at item in list and checks if its correct
 * @param shoppingItem String in the list in which the item is stated as
 * @return validity of the item, if its an actual item it will pass
 */
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean valid  = false;
		if (shoppingItem != "slug bait")
		{
			valid = true;
		}
        return valid;
	}
	/**
	 * Checks if the movie titles in the list are legitimate
	 * @param title takes the string which is the title in
	 * @return validity of the movie title
	 */
	public boolean movieTitleChecker(String title)
	{
		boolean valid = false;
		if (title != "")
		{
			valid = true;
		}
		return valid ;
	}
	
	/**
	 * Looks at the genre and makes sure it's reakl
	 * @param genre takes in string that is the genre
	 * @return validity of the genre
	 */
	public boolean movieGenreChecker(String genre)
	{
		boolean valid = false;
		if (genre != "")
		{
			valid = true;
		}
		
		return valid;
	}
/**
 * It's the method that checks whether you're trying to tell it to quit or not
 * @param exitString takes in the input and sees if it's telling you to quit
 * @return to quit or not depending on what they say
 */
	public boolean quitChecker(String exitString)
	{
		if (exitString == null)
		{
			return false;
		}
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	/**
	 * takes in input and makes sure it isn't keyboard mashing
	 * @param sample takes in the users input
	 * @return if its keyboard mashing or not
	 */
	public boolean keyboardMashChecker(String sample)
	{
		boolean valid  = false;
		String[] Mash = new String[] {"sdf", "dfg", "cvb", "kjh", ",./"};
    for (String mash : Mash) {
    	if (mash.equalsIgnoreCase(sample)) {
    		valid = true;
    	}
    }
	return valid;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
