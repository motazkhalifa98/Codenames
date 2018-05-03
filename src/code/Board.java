package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import code.Person;

public class Board{
	/**
	 * This String contains the current clue
	 */
	private String CLUE = "this is a clue";
	/**
	 * This String contains the current player
	 */
	private String currentPlayer = "RedAgent";
	/**
	 * This String contains the winning team(if the game is won)
	 */
	private String winningTeam = "no winner";
	/**
	 * Matrix of Location instances
	 */
	private Location[][] board;
	/**
	 * List of all code names from given file
	 */
	private List<String> fullCodenames=new ArrayList<String>();
	/**
	 * List of code names chosen for game
	 */
	private List<String> codenames=new ArrayList<String>();
	/**
	 * true if the game is won, false otherwise
	 */
	private boolean winningState;
	/**
	 * current count integer
	 */
	private int count;
	/**
	 * true if assassin has been revealed
	 */

	private boolean assassinFound;
	/**
	 * number of red agents to be found
	 */
	private int redAgentsToBeFound=9;
	/**
	 * number of blue agents to be found
	 */
	private int blueAgentsToBeFound=8;
	/**
	 * ArrayList containing Person instances
	 */
	private ArrayList<Person> persons = new ArrayList<Person>();
	/**
	 * Board constructor creates a Location Matrix using paramters given
	 * @param x the number of rows
	 * @param y the number of columns
	 */
	public Board(int x, int y) {
		Location[][] thisboard = new Location[x][y];
		this.board = thisboard;

	}
	/**
	 * Access method for the Boards matrix
	 * @return the current Location matrix for this instance
	 */
	public Location[][] getBoard() {
		return board;
	}
	/**
	 * Access method for String winningTeam
	 * @return a string containing the winning team
	 */
	public String getWinningTeam() {
		return winningTeam;
	}
	/**
	 * Setter for the Location matrix of this board
	 * @param board new location matrix
	 */
	public void setBoard(Location[][] board) {
		this.board = board;
	}
	/**
	 * Setter for the full list of codenames and for the 25 randomly chosen names to be used in the game
	 * @param filename given file of codenames
	 */
	public void setCodeNames(String filename) {
		try {
			for(String line : Files.readAllLines(Paths.get(filename))){
				fullCodenames.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.shuffle(fullCodenames);
		for(int name=0; name<25; name++) {
			codenames.add(fullCodenames.get(name));
		}

	}
	/**
	 * Getter for the full list of codenames
	 * @return all codenames from file
	 */
	public List<String> getAllCodeNames(){
		return fullCodenames;
	}
	/**
	 * Getter for the 25 codenames being used in the game
	 * @return the List containing the 25 random codenames in use
	 */
	public List<String> getGameCodeNames(){
		return codenames;
	}
	/**
	 * Creates all persons, shuffles them, puts them in a matrix, and sends it to the board
	 */
	public void makeList() {
		for (int i=0; i <9; i++) {
			RedAgent red = new RedAgent();
			persons.add(red);
		}
		for (int x=0; x< 8; x++) {
			BlueAgent blue = new BlueAgent();
			persons.add(blue);
		}
		for (int y=0; y< 7; y++) {
			InnocentBystander innocent = new InnocentBystander();
			persons.add(innocent);
		}
		Assassin assassin = new Assassin();
		persons.add(assassin);
		Collections.shuffle(persons);
		int count=0;
		Location[][] board2=new Location[board.length][board[0].length];
		for(int i=0; i<board2.length; i++) 
			for(int j=0; j<board2[0].length; j++) {
				Location newLoc= new Location(codenames.get(count),persons.get(count),0);
				board2[i][j] = newLoc;
				count++;
			}
		setBoard(board2);
	}
	/**
	 * Getter for the current clue
	 * @return current clue
	 */
	public String getClue() {
		return CLUE;
	}
	/**
	 * Setter for the current clue
	 * @param setClue new desired clue string
	 */
	public void setClue(String setClue) {
		CLUE = setClue;
	}
	/**
	 * Setter for the current player
	 * @param player desired current player string
	 */
	public void setCurrentPlayer(String player) {
		currentPlayer = player;
	}
	/**
	 * Getter for the current player
	 * @return the current player
	 */
	public String getCurrentPlayer() {
		return currentPlayer;
	}
	/**
	 * Setter for the count variable
	 * @param desired new count
	 */
	public void setCount(String count) {
		this.count=new Integer(count);
	}
	/**
	 * Getter for count variable
	 * @return the current count
	 */

	public int getCount() {
		return count;
	}
	/**
	 * Determines if a clue is legal or illegal by checking to see whether that codename is revealed or not
	 * @return false if illegal, true if legal
	 */
	public boolean legalClue() {
		for (int i=0; i<board.length; i++) {
			for(int k=0; k<board[0].length; k++) {
				if (CLUE.equals(board[i][k].getCodeName()) && board[i][k].getReveal() == 0) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Makes one in game "move" by revealing one location and decreasing the count if it is the opposite teams player
	 * @param row desired row for move
	 * @param col desired column for move
	 */
	public String makeMove(int row, int col) {
		String which;
		board[row][col].setReveal(1); 
		if(board[row][col].getPersonType()=="Red Agent") {
			which="Red";
			redAgentsToBeFound--;
		}else if(board[row][col].getPersonType()=="Blue Agent") {
			which="Blue";
			blueAgentsToBeFound--;
		}
		else if(board[row][col].getPersonType()=="Assassin") {
			assassinFound=true;
			which="Assassin";
			if (currentPlayer == "Red") {
				winningTeam = "Blue";
			return "Blue Wins";
			}else {
				winningTeam= "Red";
				return "Red Wins";
			}}
	
		else {which="Innocent";}
		if(which==currentPlayer)
		return "You found your agent!";
		else return which;
	}
	/**
	 * Setter for red agents to be found
	 */
	public void setRedCount(int red) {
		redAgentsToBeFound=red;
	}
	/**
	 * Setter for blue agents to be found
	 */
	public void setBlueCount(int blue) {
		blueAgentsToBeFound=blue;
	}
	/**
	 * Access method for the red agent count
	 * 
	 * @return The number of red agents that have not been revealed
	 */
	public int getRedCount() {
		return redAgentsToBeFound;
	}
	/**
	 * Access method for the blue agent count
	 * 
	 * @return The number of blue agents that have not been revealed
	 */
	public int getBlueCount() {
		return blueAgentsToBeFound;
	}
	/**
	 * Determines if the game is in a winning state by checking to see if all red/blue agents are revealed or is the assassin is revealed. Method also sets the winning team
	 */
	public Boolean gameState() {
		if(assassinFound==true) {
			winningState = true;
			
		}
		else if(redAgentsToBeFound == 0) {
			winningState = true;
			winningTeam = "Red";
		}
		else if(blueAgentsToBeFound == 0) {
			winningState = true;
			winningTeam = "Blue";
		}
		return winningState;
	}
	/**
	 * Getter method for the string winning state
	 * @return which team won
	 */
	public boolean getWinningState()
	{
		return winningState;
	}
	/**
	 * main method which starts the game
	 * @param args
	 */
	public void main(String[] args) {
		startGame();
	}
	/**
	 * Runs the method makeList when called upon
	 */
	public void startGame() {
		makeList();
	}
	public boolean legalCount() {
		if(count<1 || count>25)
			return false;
		else return true;
	}
}