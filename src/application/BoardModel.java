package application;


public class BoardModel {
	
	//fields
	private Integer size;
	private Integer winningMove;
	Chip[][] board;// each cell of the board is a Chip
	
	/**
	 * constructor - create a square board
	 * @param size - rows and columns
	 * @param winningMove 
	 */
	public BoardModel(Integer size, Integer winningMove){
		this.size = size;
		this.winningMove= winningMove;
		this.board = new Chip[size][size];
		System.out.println("boardmodel constructor");
	}
	/**
	 * set size of the board
	 * @param size - rows and columns
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
	/**
	 * get the size
	 * @return size
	 */
	public Integer getSize(){
		return this.size;
	}
	/**
	 * set winning move
	 * @param winningMove
	 */
	public void setWinningMove(Integer winningMove) {
		this.winningMove = winningMove;
	}
	/**
	 * get winning move
	 * @return winningMove
	 */
	public Integer getWinningMove() {
		return this.winningMove;
	}
	/**
	 * set board with rows and cols
	 * @param size
	 */
	public void setBoard(Integer size) {
		this.board = new Chip[size][size];
	}
	/**
	 * get board
	 * @return board
	 */
	public Chip[][] getBoard() {
		return this.board;
	}
	
	
	public void putChip(){
		// fully implemetation here
	}
}
