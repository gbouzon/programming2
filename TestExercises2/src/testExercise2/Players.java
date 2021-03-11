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

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
* Class based on Niloufar's Self-Test Exercise II - Q3.
* Using arraylists.
* @author Giuliana Bouzon
*/
public class Players {
    
    static Scanner scan = new Scanner(System.in);
    static int[] validTypes = {1, 2, 3, 4, 5, 0};
    
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
     * Adds a player to the players list and its correspondent score to the scores list.
     * @param players, the input players list.
     * @param scores, the input scores list.
     * @param player, the input player to be added to the list.
     * @param score, the input score to be added to the score list.
     */
    public static void addPlayer(ArrayList<String> players, ArrayList<Double> scores, String player, double score) {
	if (players.contains(player))
	    System.out.println("Player already exists.");
	else if (players.size() == 10)
	    System.out.println("List has reached its capacity.");
	
	else {
	    players.add(player);
	    scores.add(score);
	}
    }
    
    /**
     * Prints all the players in the list and their corresponding scores.
     * @param players, the input players list.
     * @param scores, the input scores list.
     * @return the String to be printed.
     */
    public static void printPlayers(ArrayList<String> players, ArrayList<Double> scores) {
	String str = "";
	if (players.size() == 0 && scores.size() == 0)
	    System.out.println("There are no players to display at the moment.");
	for (int i = 0; i < players.size(); i++) {
	    str += String.format("%s's %s: %.2f\n", players.get(i), "score", scores.get(i));   
	}
	System.out.print(str);
    }
    
    /**
     * Lists the specified player and its corresponding score.
     * @param players, the input players list.
     * @param scores, the input scores list.
     * @param player, the specified player.
     * @return the player and its corresponding score.
     */
    public static String getPlayerScore(ArrayList<String> players, ArrayList<Double> scores, String player) {
	int position = 0;
	if (players.contains(player)) {
	    position = players.indexOf(player);
	    return String.format("%s %s %.1f.", player, "has a score of", scores.get(position));
	}
	else
	    return String.format("'%s' %s.", player, "does not exist");
	
    }
    
    /**
     * Removes a player from the players list and its corresponding score from the scores list.
     * @param players, the input players list.
     * @param scores, the input scores list.
     * @param player, the specified player to be removed.
     */
    public static void removePlayer(ArrayList<String> players, ArrayList<Double> scores, String player) {
	if (players.contains(player)) {
	    int position = players.indexOf(player);
	    players.remove(player);
	    scores.remove(position);
	}
	else
	    System.out.printf("'%s' %s.\n", player, "does not exist");
    }
    
    /**
     * Lists all the players that have the specified score as a score.
     * @param players, the input players list.
     * @param scores, the input scores list.
     * @param playerScore, the specified score to be found.
     * @return all the players that possess playerScore.
     */
    public static String getAllPlayersWithScore(ArrayList<String> players, ArrayList<Double> scores, double playerScore) {
	String str = ""; 
	if (scores.contains(playerScore))
	    for (int i = 0; i < scores.size(); i++) 
		if (scores.get(i) == playerScore)
		   str += players.get(i) + ", ";
	
	return (str + "have a score of " + playerScore);
    }
    

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	ArrayList<String> players = new ArrayList<>(10);
	ArrayList<Double> scores = new ArrayList<>(10);

	int userOption;
	boolean userActive = true;
	
	try {
	    while(userActive) {
		userOption = retrieveUserOption();
		switch(userOption) {
	    	    case 1:
	    		String player = retrievePlayer();
	    		player = scan.nextLine();  //because Java scanners are trash 
	    		double score = retrievePlayerScore();
	    		addPlayer(players, scores, player, score);
	    		break;
	    	    case 2:
	    		printPlayers(players, scores);
	    		break;
	    	    case 3:
	    		double score2 = retrievePlayerScore();
	    		System.out.println(getAllPlayersWithScore(players, scores, score2));
	    		break;
	    	    case 4:
	    		String player2 = retrievePlayer();
	    		player2 = scan.nextLine();
	    		removePlayer(players, scores, player2);
	    		break;
	    	    case 5:
	    		String player3 = retrievePlayer();
	    		player3 = scan.nextLine();
	    		System.out.println(getPlayerScore(players, scores, player3));
	    		break;
	    	    default:
	    		System.out.println("Exiting....");
	    		userActive = false;
		}    
	    } 
	}
	
	catch(Exception exception) {
	    System.out.println("Error please check me ;("); 
	    exception.printStackTrace(); //doing this to pinpoint error
	}
	
	//closing the scanner
	scan.close();
    }
}