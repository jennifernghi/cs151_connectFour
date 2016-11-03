

public class BoardModel {
	/**
	 * fields
	 */
	//board array each cell is a chip
	private Chip[][] boardArray;
	//winning move
	private int winningMove;
	//total of spaces in the grid
	private int spaces;
	//number of chips placed on the grid
	private int numOfChips;

	/**
	 * constructor
	 * @param size - size of the grid
	 * @param winningMove 
	 */
	public BoardModel(int size, int winningMove) {
		boardArray = new Chip[size][size]; 
		spaces = size * size;
		numOfChips = 0;
		this.winningMove = winningMove;
	}
	/**
	 * place chip on the grid when user click on column
	 * @param chip
	 * @param column
	 * @return
	 */
	int putChip(Chip chip, int column) {

		int put = -1; // check if the column is full

		for (int row = boardArray.length - 1; row >= 0; row--) {
			if (boardArray[row][column] == null) {
				boardArray[row][column] = chip;
				//increase numOfChips
				numOfChips++;
				//assign number of row to put
				put = row;
				break;
			}

		}

		return put;
	}
	/**
	 * when user place a chip on the grid, checkWinner will be called 
	 * @return consecutiveChipValue - indicate the winner
	 */
	int checkWinner() {

		//check if it is tie
		if (numOfChips == spaces) 
			return -1;
		else {
			// initialize consecutiveChipValue =0
			int consecutiveChipValue = 0;
			// repeat start at 1
			int repeat = 1;

			// check vertically
			consecutiveChipValue = checkVertically(consecutiveChipValue, repeat);
			
			// check horizontally
			consecutiveChipValue = checkHorizontally(consecutiveChipValue, repeat);
			
			// check negative slope diagonal
			consecutiveChipValue = checkOnAndAboveDiagonalBottomRightToLeft(consecutiveChipValue, repeat);
			consecutiveChipValue = checkBelowDiagonalBottomRightToLeft(consecutiveChipValue, repeat);
			
			// check positive slope diagonal
			consecutiveChipValue = checkOnAndAboveDiagonalBottomLeftToRight(consecutiveChipValue, repeat);
			consecutiveChipValue = checkBelowDiagonalBottomLeftToRight(consecutiveChipValue, repeat);
			
			
			return consecutiveChipValue;
		}
	}
	/**
	 * check vertically
	 * @param consecutiveChipValue
	 * @param repeat
	 * @return consecutiveChipValue - indicate the winner
	 */
	private int checkVertically(int consecutiveChipValue, int repeat) {

		for (int column = 0; column < boardArray.length; column++) {
			for (int row = 1; row < boardArray.length; row++) {
				if (boardArray[row][column] != null && boardArray[row - 1][column] != null) {
					//compare with the cell below
					if (boardArray[row][column].getValue() == boardArray[row - 1][column].getValue())
						++repeat;
					else
						repeat = 1; //reset repeat

					if (repeat == winningMove) {
						// Return chip value of the winner
						consecutiveChipValue = boardArray[row][column].getValue();
					}
				} 
			}
			repeat = 1; 
		}
		return consecutiveChipValue;

	}
	/**
	 * check horizontally
	 * @param consecutiveChipValue
	 * @param repeat
	 * @return consecutiveChipValue - indicate the winner
	 */
	private int checkHorizontally(int consecutiveChipValue, int repeat) {
		for (int row = 0; row < boardArray.length; row++) {
			for (int column = 1; column < boardArray.length; column++) {
				// compare with previous column
				if (boardArray[row][column] != null && boardArray[row][column - 1] != null) {
					
					if (boardArray[row][column].getValue() == boardArray[row][column - 1].getValue())
						++repeat;
					else
						repeat = 1;

					// Check if there are consecutive chip in a row that =
					// winningMove.
					if (repeat == winningMove) {
						// Return chip value of the winner
						consecutiveChipValue = boardArray[row][column].getValue();
					}
				} 
			}
			repeat = 1;
		}
		return consecutiveChipValue;

	}
	/**
	 * check the region on and above negative slope diagonal
	 * @param consecutiveChipValue
	 * @param repeat
	 * @return consecutiveChipValue - indicate the winner
	 */
	private int checkOnAndAboveDiagonalBottomRightToLeft(int consecutiveChipValue, int repeat) {
		for (int column = 0; column < boardArray.length; column++) {
			for (int row = 1; row < boardArray.length; row++) {
				// compare with previous diagonal value
				if (row+ column < boardArray.length && boardArray[row][row+ column] != null && boardArray[row -1][(row + column) - 1] != null) {
					if (boardArray[row][row+ column].getValue() == boardArray[row- 1][(row + column) - 1].getValue())
						++repeat;
					else
						repeat = 1;

					// Check if there are consecutive chip in a row that =
					// winningMove.
					if (repeat == winningMove) {
						// Return color of the winner
						consecutiveChipValue = boardArray[row][row + column].getValue();
					}
				} 
			}
			repeat =1;
		}
		return consecutiveChipValue;
		}
		
	/**
	 * check the region below negative slope diagonal
	 * @param consecutiveChipValue
	 * @param repeat
	 * @return consecutiveChipValue - indicate the winner
	 */
	private int checkBelowDiagonalBottomRightToLeft(int consecutiveChipValue, int repeat) {
		for (int row = 0; row < boardArray.length; row++) {
			for (int column = 1; column < boardArray.length; column++) {
				// compare with previous cell diagonally
				if (row + column < boardArray.length && row+column != column && boardArray[row+column][column] != null && boardArray[((row + column)-1)][column- 1] != null) {
					if (boardArray[row+column][column].getValue() == boardArray[((row + column)-1)][column- 1].getValue())
						++repeat;
					else
						repeat = 1;

					// Check if there are consecutive chip in a row that =
					// winningMove.
					if (repeat == winningMove) {
						// Return color of the winner
						consecutiveChipValue = boardArray[row+column][column].getValue();
					}
				} 
			}
			repeat =1; 
		}
		return consecutiveChipValue;
		}
	/**
	 * check the region on and above positive slope
	 * @param consecutiveChipValue
	 * @param repeat
	 * @return consecutiveChipValue - indicate the winner
	 */
	private int checkOnAndAboveDiagonalBottomLeftToRight(int consecutiveChipValue, int repeat) {
		for (int column = boardArray.length-1; column > 0; column--) {
			for (int row = 1; row < boardArray.length; row++) {
				// compare with previous cell diagonally
				if (column- row >= 0 && boardArray[row][column -row] != null && boardArray[row -1][(column-row) + 1] != null) {
					if (boardArray[row][column -row].getValue() == boardArray[row -1][(column-row) + 1].getValue())
						++repeat;
					else
						repeat = 1;

					// Check if there are consecutive chip in a row that =
					// winningMove.
					if (repeat == winningMove) {
						// Return color of the winner
						consecutiveChipValue = boardArray[row][column -row].getValue();
					}
				} 
			}
			repeat =1; 
		}
		return consecutiveChipValue;
		}
	/**
	 * check the region below positive diagonal
	 * @param consecutiveChipValue
	 * @param repeat
	 * @return consecutiveChipValue - indicate the winner
	 */
	private int checkBelowDiagonalBottomLeftToRight(int consecutiveChipValue, int repeat) {
		for (int row =0; row <boardArray.length; row++) {
			for (int column = boardArray.length-1, i = row +1; column >= 0 && i <=boardArray.length-1; column--, i++) {
				if (boardArray[i][column] != null  && i -1 >=0 && column +1 <boardArray.length && boardArray[i-1][column+1] !=null) 
				{	
					// compare with previous cell diagonally
					if (boardArray[i][column].getValue() == boardArray[i-1][column+1].getValue())
					{
						++repeat;	
					}
					else
					{
						repeat = 1;
					}
					// Check if there are consecutive chip in a row that =
					// winningMove.
					if (repeat == winningMove) {
						// Return color of the winner
						consecutiveChipValue = boardArray[i][column].getValue();
					}
				} 
			}
			repeat =1; 
		}
		return consecutiveChipValue;
		}
	/*
	 * reset the whole boardArray
	 */
	public void clear()
	{
		numOfChips = 0;//reset numOfChips
		
		for (int i =0; i<boardArray.length;i++)
			for (int j =0; j<boardArray.length;j++)
				boardArray[i][j] = null; //set null to every cell
	}
}
