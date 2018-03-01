package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import code.Person;

public class Board {
	/**
	 * This String contains the current clue
	 */
	private String CLUE = "this is a clue";
	/**
	 * This String conatins the current player
	 */
	private String currentPlayer = "Red";
	/**
	 * This String contains the winning team(if the game is won)
	 */
	private String winningTeam = "no winner";
	/**
	 * Counter---starts at 10
	 */
	private int count = 10;
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
	 * true if assassin has been revealed
	 */
	private boolean assassinFound;
	/**
	 * number of red agents found
	 */
	private int redAgentsFound;
	/**
	 * number of blue agents found
	 */
	private int blueAgentsFound;
	/**
	 * ArrayList containing Person instances
	 */
	private ArrayList<Person> persons = new ArrayList<Person>();
	/**
	 * Board constructor creates a Loacation Matrix using paramters given
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
	 * Access method for the current count
	 * @return current count
	 */
	public int getCount()
	{
		return count;
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
		int j = 0;

		for (int i=0; i <9; i++) {
			RedAgent red = new RedAgent();
			j = i;
			persons.add(red);
		}
		for (int x=0; x< 8; x++) {
			BlueAgent blue = new BlueAgent();
			j = x+j;
			persons.add(blue);
		}
		for (int y=0; y< 7; y++) {
			InnocentBystander innocent = new InnocentBystander();
			j = j+y;
			persons.add(innocent);
		}
		Assassin assassin = new Assassin();
		persons.add(assassin);
		Collections.shuffle(persons);
		Location[][] bleh = new Location[5][5];

		int tests = 0;
		int testCount = 0;
		for (int i =0; i <bleh.length; i++) {
			for (int k =0; k < bleh[i].length; k++) {
				Location newLoc= new Location(codenames.get(testCount),persons.get(tests),0);
				bleh[i][k] = newLoc;
				tests++;
				testCount++;
			}
		}
		setBoard(bleh);
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
	 * Determines if a clue is legal or illegal by checking to see whether that codename is revealed or not
	 * @return true if illegal, false is legal
	 */
	public boolean legalClue() {
		for (int i=0; i<board.length; i++) {
			for(int k=0; k<board[0].length; k++) {
				if (CLUE.equals(board[i][k].getCodeName()) && board[i][k].getReveal() == 0) {
					//forfeit turn
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Makes one in game "move" by revealing one location and decreasing the count if it is the opposite teams player
	 * @param row desired row for move
	 * @param col desired column for move
	 */
	public void makeMove(int row, int col) {
		board[row][col].setReveal(1); 
			//reveal the location
			if (currentPlayer.equals("Red")) {
				board[row][col].setReveal(1);
				if (((Person)board[row][col].getPersonType()).getPersonType().equals("RedAgent")) {
					count--;
				}
			}
			else if(currentPlayer.equals("Blue")) {
				board[row][col].setReveal(1);
			}
			else {
				System.out.println("code error somewhere in makeMove()");
		}

	}
	/**
	 * Decrements count and increments count for each respective person revealed so far
	 */
	public void checkWhoseRevealed() {
		for (int i =0; i <board.length; i++) {
			for (int k =0; k < board[i].length; k++) {
				if(((Person)board[i][k].getPersonType()).getPersonType()=="RedAgent" && board[i][k].Reveal == 1) {
					redAgentsFound += 1;
					count--;
				}
				else if(((Person)board[i][k].getPersonType()).getPersonType()=="BlueAgent" && board[i][k].Reveal == 1) {
					blueAgentsFound += 1;
					count--;
				}
			}
		}
	}
	/**
	 * Determines if the game is in a winning state by checking to see if all red/blue agents are revealed or is the assassin is revealed. Method also sets the winning team
	 */
	public void gameState() {
		if(assassinFound) {
			winningState = true;
			
		}
		else if(redAgentsFound == 9) {
			winningState = true;
			winningTeam = "Blue";
		}
		else if(blueAgentsFound == 8) {
			winningState = true;
			winningTeam = "Red";
		}
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
	/**
	 * Setter for the counter
	 * @param x desired count
	 */
	public void setCount(int x) {
		count = x;
	}
	/**
	 * Determines 1) If assassin is revealed
	 * 2) Which team won
	 *
	 */
	public void AssassinFound() {
		for (int i=0; i<board.length; i++) {
			for(int k=0; k<board[0].length; k++) {
				if (((Person)board[i][k].getPersonType()).getPersonType()== "Assassin" && board[i][k].getReveal() == 1) {
					assassinFound = true;
					if (currentPlayer == "Red") {
						winningTeam = "Blue";
					} else {
						winningTeam= "Red";
					}
				}
			}
		}
	}
}
