package code;

public class Board {
	private Location[][]Board;
	
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
