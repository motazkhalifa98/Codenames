package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import code.Person;

public class Board {

	private String CLUE = "this is a clue";

	private String currentPlayer = "Red";
	private String winningTeam = "";
	private String losingTeam;

	private int count = 10;

	private Location[][] board;
	private List<String> fullCodenames=new ArrayList<String>();
	private List<String> codenames=new ArrayList<String>();
	private boolean winningState;
	private boolean assassinFound;
	private int redAgentsFound;
	private int blueAgentsFound;
	private ArrayList<Person> persons = new ArrayList<Person>();
	public Board(int x, int y) {
		Location[][] thisboard = new Location[x][y];
		this.board = thisboard;

	}

	public Location[][] getBoard() {
		return board;
	}

	public int getCount()
	{
		return count;
	}
	public void setBoard(Location[][] board) {
		this.board = board;
	}

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
	public List<String> getAllCodeNames(){
		return fullCodenames;
	}
	public List<String> getGameCodeNames(){
		return codenames;
	}

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

	//j

	public String getClue() {
		return CLUE;
	}
	public void setClue(String setClue) {
		CLUE = setClue;
	}
	public void setCurrentPlayer(String player) {
		currentPlayer = player;
	}
	public String getCurrentPlayer() {
		return currentPlayer;
	}
	public boolean legalClue() {
		for (int i=0; i<board.length; i++) {
			for(int k=0; k<board[0].length; k++) {
				if (CLUE.equals(board[i][k].getCodeName()) && board[i][k].getReveal() == 0) {
					//forfet turn
					return true;
				}
			}
		}
		return false;
	}
	public void makeMove(int row, int col) {
		board[row][col].setReveal(1); 
			//reveal the location
			if (currentPlayer.equals("Red")) {
				board[row][col].setReveal(1);
				if (((Person)board[row][col].getPersonType()).getPersonType().equals("RedAgent")) {
					count--;
				}
				//checkGameState()
			}
			else if(currentPlayer.equals("Blue")) {
				board[row][col].setReveal(1);
				//checkGameState()
			}
			else {
				System.out.println("code error somewhere in makeMove()");
		}

	}
	//public void checkGameState(int row, int col) {
	//check what thing was revealed 
	//decide what happens
	//f (board[row][col].getPersonType().equals("Assassin")) {

	//}
	//}
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
	public void gameState() {
		if(assassinFound) {
			winningState = true;
		}
		else if(redAgentsFound == 9) {
			winningState = true;
			winningTeam = "red";
		}
		else if(blueAgentsFound == 8) {
			winningState = true;
			winningTeam = "red";
		}
	}
	
	public boolean getWinningState()
	{
		return winningState;
	}
	public void main(String[] args) {
		startGame();
	}

	public void startGame() {
		makeList();
	}

	public void setCount(int x) {
		count = x;
	}

	public void AssassinFound() {
		for (int i=0; i<board.length; i++) {
			for(int k=0; k<board[0].length; k++) {
				if (((Person)board[i][k].getPersonType()).getPersonType()== "Assassin" && board[i][k].getReveal() == 1) {
					assassinFound = true;
					if (currentPlayer == "red") {
						losingTeam = "red";
					} else {
						losingTeam= "blue";
					}
				}
			}
		}
	}
}
