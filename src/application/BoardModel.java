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

	int putChip(Chip chip, int column) {

		int put = -1; // check if the column is full

		for (int row = boardArray.length - 1; row >= 0; row--) {
			if (boardArray[row][column] == null) {
				boardArray[row][column] = chip;
				//System.out.println("put chip at " + row + " " + column);
				numOfChips++;
				put = row;
				break;
			}

		}

		return put;
	}

	int checkWinner() {

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

			// check diagonal right - to - left
			
			return consecutiveChipValue;
		}
	}

	public int checkVertically(int consecutiveChipValue, int repeat) {

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

	public int checkHorizontally(int consecutiveChipValue, int repeat) {
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
	
	public void clear()
	{
		numOfChips = 0;
		
		for (int i =0; i<boardArray.length;i++)
			for (int j =0; j<boardArray.length;j++)
				boardArray[i][j] = null; 
	}
}