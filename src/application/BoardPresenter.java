package application;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class BoardPresenter {
	BoardGui view;
	BoardModel boardModel;
	AbstractPlayer player1;
	AbstractPlayer player2;
	Integer turn = 1;

	public BoardPresenter(Integer size, Integer winningMove) {

		setBoardModel(new BoardModel(size, winningMove));

		setPlayer1(new Players(1, new Chip(1, Color.GREEN)));
		setPlayer2(new Players(2, new Chip(2, Color.RED)));

	}

	// attach view
	public void setView(BoardGui view) {
		this.view = view;
	}

	public BoardGui getView() {
		return this.view;
	}

	public void setBoardModel(BoardModel boardModel) {
		this.boardModel = boardModel;
	}

	public BoardModel getBoardModel() {
		return this.boardModel;
	}

	public void setPlayer1(AbstractPlayer player1) {
		this.player1 = player1;
	}

	public AbstractPlayer getPlayer1() {
		return this.player1;
	}

	public void setPlayer2(AbstractPlayer player2) {
		this.player2 = player2;
	}

	public AbstractPlayer getPlayer2() {
		return this.player2;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public Integer getTurn() {
		return this.turn;
	}

	public void putChip(int column) {
		// boardModel.putChip();
		int row;
		
		System.out.println("initial player "+getTurn());
		
		if (getTurn() == 1) {
		row = boardModel.putChip(player1.getChip(), column);
			if (row>-1) {
				setTurn(2);
			
			}
		} else {
			row = boardModel.putChip(player2.getChip(), column);
			if (row>-1) {
				setTurn(1);
				view.putChip(row, column);
			}
		}
		

		
		if (row<=-1)
			view.promptInvalidMove();
		
		System.out.println(getTurn()+" "+column + " " + row);
	}
	
	public void checkWinner()
	{
		int winner = boardModel.checkWinner();

		if (winner == 1)
			view.promptWinner("" + player1.getPlayerId());
		else if (winner == 2)
			view.promptWinner("" + player2.getPlayerId());
		else if (winner == -1)
			view.promptTie(); // when the board is filled	
	}

}
