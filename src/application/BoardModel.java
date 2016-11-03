package application;

public class BoardModel {

	private Chip[][] boardArray;
	private int winningMove;
	private int spaces;
	private int numOfChips;

	public BoardModel(int size, int winningMove) {
		boardArray = new Chip[size][size]; // no need for setters because it
		spaces = size * size;
		numOfChips = 0;
		this.winningMove = winningMove;
	}

	public int putChip(Chip chip, int column) {

		int put = -1; // check if the column is full

		for (int row = boardArray.length - 1; row >= 0; row--) {
			if (boardArray[row][column] == null) {
				boardArray[row][column] = chip;
				numOfChips++;
				put = row;
				break;
			}

		}

		return put;
	}

	public int checkWinner() {

		//check if it is tie
		if (numOfChips == spaces) 
			return -1;
		else {
			int consecutiveChipValue = 0;
			int repeat = 1;

			// check vertically
			consecutiveChipValue = checkVertically(consecutiveChipValue, repeat);

			// check horizontally
			consecutiveChipValue = checkHorizontally(consecutiveChipValue, repeat);
			// check diagonal left - to - right

			consecutiveChipValue = checkOnAndAboveDiagonalBottomRightToLeft(consecutiveChipValue, repeat);
			
			consecutiveChipValue = checkBelowDiagonalBottomRightToLeft(consecutiveChipValue, repeat);
			// check diagonal right - to - left
			
			consecutiveChipValue = checkOnAndAboveDiagonalBottomLeftToRight(consecutiveChipValue, repeat);
			
			consecutiveChipValue = checkBelowDiagonalBottomLeftToRight(consecutiveChipValue, repeat);
			return consecutiveChipValue;
		}
	}

	private int checkVertically(int consecutiveChipValue, int repeat) {

		for (int column = 0; column < boardArray.length; column++) {
			for (int row = 1; row < boardArray.length; row++) {
				if (boardArray[row][column] != null && boardArray[row - 1][column] != null) {
					if (boardArray[row][column].getValue() == boardArray[row - 1][column].getValue())
						++repeat;
					else
						repeat = 1;

					if (repeat == winningMove) {
						// Return color of the winner
						consecutiveChipValue = boardArray[row][column].getValue();
					}
				} else
					repeat = 1;
			}
		}
		return consecutiveChipValue;

	}

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
						// Return color of the winner
						consecutiveChipValue = boardArray[row][column].getValue();
					}
				} else
					repeat = 1;
			}
		}
		return consecutiveChipValue;

	}
	
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
				} else
					repeat = 1;
			}
		}
		return consecutiveChipValue;
		}
		

	private int checkBelowDiagonalBottomRightToLeft(int consecutiveChipValue, int repeat) {
		for (int row = 0; row < boardArray.length; row++) {
			for (int column = 1; column < boardArray.length; column++) {
				// compare with previous column
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
				} else
					repeat = 1;
			}
		}
		return consecutiveChipValue;
		}
	private int checkOnAndAboveDiagonalBottomLeftToRight(int consecutiveChipValue, int repeat) {
		for (int column = boardArray.length-1; column > 0; column--) {
			for (int row = 1; row < boardArray.length; row++) {
				// compare with previous diagonal value
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
				} else
					repeat = 1;
			}
		}
		return consecutiveChipValue;
		}
	private int checkBelowDiagonalBottomLeftToRight(int consecutiveChipValue, int repeat) {
		for (int row =1; row <=boardArray.length-2; row++) {
			for (int column = boardArray.length-2, i = row +1; column >= 0 && i <=boardArray.length-1; column--, i++) {
				if (boardArray[i][column] != null  && i -1 >=0 && column +1 <boardArray.length && boardArray[i-1][column+1] !=null) {
					
<<<<<<< HEAD
					if (boardArray[i][column].getValue() == boardArray[row][pivot].getValue())
=======
					if (boardArray[i][column].getValue() == boardArray[i-1][column+1].getValue())
					{
						
>>>>>>> bed04566016816b0752def70687f4fe979f54bed
						++repeat;
					else
						repeat = 1;
					// Check if there are consecutive chip in a row that =
					// winningMove.
					if (repeat == winningMove) {
						// Return color of the winner
						consecutiveChipValue = boardArray[i][column].getValue();
					}
				} else
					repeat = 1;
			}
		}
		return consecutiveChipValue;
		}
	public void clear()
	{
		numOfChips = 0;
		
		for (int i =0; i<boardArray.length;i++)
			for (int j =0; j<boardArray.length;j++)
				boardArray[i][j] = null; 
	}
}
