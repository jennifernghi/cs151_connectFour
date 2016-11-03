package application;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class BoardPresenter {
	private BoardGui view;
	private BoardModel boardModel;
	private AbstractPlayer player1;
	private AbstractPlayer player2;
	private Integer turn = 1;
	private Integer size; 
	private Integer player1Win;
	private Integer player2Win; 

	public BoardPresenter(Integer size, Integer winningMove) {

		this.size = size; 
		
		setBoardModel(new BoardModel(size, winningMove));

		player1 = new Players(1, new Chip(1, Color.GREEN));
		player2 = new Players(2, new Chip(2, Color.RED));
		
		player1Win =0;
		player2Win = 0;

	}

	// attach view
	public void setView(BoardGui view) {
		this.view = view;
	}
	
	public int getSize()
	{
		return size;
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

	public AbstractPlayer getPlayer1() {
		return this.player1;
	}

	public AbstractPlayer getPlayer2() {
		return this.player2;
	}

	private void setTurn(Integer turn) {
		this.turn = turn;
	}

	public Integer getTurn() {
		return this.turn;
	}
	
	public Integer getPlayer1Win(){
		return player1Win;
	}
	
	public Integer getPlayer2Win(){
		return player2Win;
	}

	public void putChip(int column) {
		int row;

		if (getTurn() == 1) {
			row = boardModel.putChip(player1.getChip(), column);
			
			if (row>-1) {
				setTurn(2);	
			}
		} else {
			row = boardModel.putChip(player2.getChip(), column);
			if (row>-1) {
				setTurn(1);
			}
			
		}
		view.putChip(row, column);

		
		if (row<=-1)
			view.promptInvalidMove();

	}
	
	public void checkWinner()
	{
		int winner = boardModel.checkWinner();

		if (winner == 1){
			view.promptWinner("" + player1.getPlayerId());
			view.updatePlayer1Win(++player1Win);
		}
		else if (winner == 2){
			view.promptWinner("" + player2.getPlayerId());
			view.updatePlayer2Win(++player2Win);
		}
		else if (winner == -1)
			view.promptTie(); // when the board is filled	
	}
	
	public void resetWins()
	{
		player1Win = 0;
		player2Win = 0; 
	}
	
	public void clear()
	{
		setTurn(1);
		boardModel.clear();
	}
	

}
