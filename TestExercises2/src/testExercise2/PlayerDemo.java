/** MIT License Copyright (c) 2021 Giuliana Bouzon

* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:

* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.

* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

package testExercise2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
* Demo class for Player.
* Used arrays this time.
* @author Giuliana Bouzon
*/
public class PlayerDemo {
    
    static Scanner scan = new Scanner(System.in);
    static int[] validTypes = {1, 2, 3, 4, 5, 0}; //valid options in the retrieveUserOption() method
    
    /**
     * Checks if the option entered by the user is valid.
     * @param option, the input int value.
     * @return true if the option is valid, and false if otherwise.
     */
    public static boolean isOptionValid(int option) {
	for (int validType : validTypes) 
	    if (option == validType)
		return true;
	
	return false; 
    }
    
    /**
     * Prompts the user to enter a menu option.
     * @return the menu option.
     */
    public static int retrieveUserOption() {
	int userOption = 0;
	boolean isValid;
	System.out.println("--------------------------------------------------------");
	System.out.println("[1] Add a new Player              [4] Remove a Player");
	System.out.println("[2] List Players                  [5] List Player Score");   
	System.out.println("[3] List Players with a Score     [0] Exit");
	System.out.println("--------------------------------------------------------");

	do {
	    isValid = true;
	    System.out.print("Please enter desired operation: ");
	    try {
		isValid = true;
                userOption = scan.nextInt();
	    }
	    catch(InputMismatchException exception) {
		isValid = false;
		System.out.println("Not a valid option.");
		scan.nextLine();
	    }
	    
	} while (!isValid || !isOptionValid(userOption)); //doing this because I don't want option "6" to go to default in my switch
	
	return userOption;
    }
    
    /**
     * Prompts the user to enter the player.
     * @return the player.
     */
    public static String retrievePlayer() {
	String player;
	
	do {
	    System.out.print("Please enter a player: ");
	    player = scan.nextLine();
	} while (player == null || player == "");
	
	return player.toLowerCase();
    }
    
    /**
     * Prompts the user to enter the player's score.
     * @return the score.
     */
    public static double retrievePlayerScore() {
	double score = 0;
	boolean isValid;

	do {
	    isValid = true;
	    System.out.print("Please enter the aforementioned player's score: ");
	    try {
		score = scan.nextDouble();
	    }
	    catch(InputMismatchException exception) {
		isValid = false;
		System.out.println("Not a valid option.");
		scan.nextLine();
	    }
	    
	} while (!isValid || score < 0 || score > 100);
	
	return score;
    }
    
    /**
     * Prints all the players in the array and their corresponding scores.
     * @param players, the input Player array.
     * @return the String to be printed.
     */
    public static void printPlayers(Player[] players) {
	String str = "";
	if (players.length > 1)
	    for (Player player : players)
		str += player.toString() + "\n";
	else
	    System.out.println(players[0].toString());
	
	System.out.println(str);
    }
    
    /**
     * Lists all the players that have the specified score as a score.
     * @param players, the input players array.
     * @param playerScore, the specified score to be found.
     * @return all the players that possess playerScore.
     */
    public static String getAllPlayersWithScore(Player[] players, double playerScore) {
	String str = ""; 
	for (Player player : players)
	    if (player.getScore() == playerScore)
		str += player.getName() + ", ";
	
	return (str + "have a score of " + playerScore);
    }
    
    /**
     * Lists the specified player and its corresponding score.
     * @param players, the input players list.
     * @param name, the specified player name.
     * @return the player and its corresponding score.
     */
    public static String getPlayerScore(Player[] players, String name) {
	for (Player player : players)
	    if (player.getName().equalsIgnoreCase(name))
		return String.format("%s %s %.1f.", player.getName(), "has a score of", player.getScore());
	
	return String.format("'%s' %s.", name, "does not exist");
    }
    
    /**
     * Removes the player with the specified name from the list.
     * @param players, the input players list.
     * @param name, the specified name to be looked for in the players list.
     */
    public static Player[] removePlayer(Player[] players, String name) {
	Player[] playersCopy = new Player[players.length - 1];
	int removed = 0;
	
	for (int i = 0; i < players.length; i++) {
	    if (!players[i].getName().equalsIgnoreCase(name))
		playersCopy[i - removed] = players[i];
	    else
		removed++;
	}
	return playersCopy;
    }
    
    /**
     * Adds the specified Player object to the players array.
     * Checks if the list can still fit more elements (length <= 10)
     * @param players, the Player array
     * @param player, the specified Player object to be added
     * @return, the Player array with the appended Player object.
     */
    public static Player[] add(Player[] players, Player player) {
	if (players.length < 10) {
	    Player[] playersCopy = Arrays.copyOf(players, players.length + 1);
	    playersCopy[playersCopy.length - 1] = player;
	
	    return playersCopy;
	}
	else
	    System.out.println("The list has reached its capacity. Erase a player before continuing.");
	
	return players;
    }
    
    /**
     * Checks if there is a player in the Player array with the specified name.
     * @param players, the Player array.
     * @param name, the specified name.
     * @return true if it already exists. False otherwise.
     */
    public static boolean isEqual(Player[] players, String name) {
	for (Player player2 : players)
	    if (player2.getName().equalsIgnoreCase(name))
		return true;
	
	return false;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	Player[] players = new Player[0];

	int userOption;
	boolean userActive = true;
	
	try {
	    while(userActive) {	
		userOption = retrieveUserOption();
		switch(userOption) {
	    	    case 1:
	    		String name = retrievePlayer();
	    		name = scan.nextLine();  //because Java scanners are trash jkjk pls don't hate on me
	    		if (!isEqual(players, name)) { //checking if name already exists
	    		    double score = retrievePlayerScore();
	    		    players = add(players, new Player(name, score));
	    		}
	    		else 
	    		    System.out.println("Name already exists sob sob. Try something else.");	    		
	    		break;
	    	    case 2:
	    		printPlayers(players);
	    		break;
	    	    case 3:
	    		double score2 = retrievePlayerScore();
	    		System.out.println(getAllPlayersWithScore(players, score2));
	    		break;
	    	    case 4:
	    		String name2 = retrievePlayer();
	    		name2 = scan.nextLine();
	    		players = removePlayer(players, name2);
	    		break;
	    	    case 5:
	    		String name3 = retrievePlayer();
	    		name3 = scan.nextLine();
	    		System.out.println(getPlayerScore(players, name3));
	    		break;
	    	    default:
	    		System.out.println("Exiting....");
	    		userActive = false;
		}    
	    } 
	}
	
	//prints stack trace to pinpoint where the problem is.
	catch(Exception exception) {
	    System.out.println("Error please check me ;(");
	    exception.printStackTrace();
	}
	
	//closing the scanner
	scan.close();
    }
}