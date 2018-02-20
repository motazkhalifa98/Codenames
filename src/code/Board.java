package code;

public class Board {
	private Location[][]Board = new Location[5][5];
	
	public Board(Location[][] theboard) {
		this.Board = theboard;
	}

	public Location[][] getBoard() {
		return Board;
	}

	public void setBoard(Location[][] board) {
		Board = board;
	}
	

}
