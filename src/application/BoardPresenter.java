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
	Chip chip;
	Integer turn;
	GridPane grid;
	Integer[][] boardData;
	public BoardPresenter() {
		 
		
	}
	public BoardPresenter(Integer size, Integer winningMove) {
		
		//attach view
		setView(new BoardGui());
		
		
		setBoardModel(new BoardModel(size, winningMove));
		
		
		setPlayer1(new Players(1, new Chip(1, Color.GREEN)));
		setPlayer2(new Players(2, new Chip(2, Color.RED)));
		setBoardData(new Integer[size][size]);
		for(int i = 0; i<size; i++){
			for(int j=0; j<size; j++){
				boardData[i][j]=0;
			}
		}
		
		System.out.println("presenter");
		
		
	}
	
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
	public void setChip(Chip chip) {
		this.chip = chip;
	}
	
	public Chip getChip() {
		return this.chip;
	}
	
	public void setTurn(Integer turn) {
		this.turn = turn;
	}
	
	public Integer getTurn() {
		return this.turn;
	}
	public void putChip() {
		boardModel.putChip();
	}
	public void setBoardData(Integer[][] boardData) {
		this.boardData = boardData;
	}
public GridPane createGrid(Integer size){
		GridPane grid = new GridPane();
		grid.getStyleClass().add("game-grid");
		
		//add colums on the grid using numberOfColumns
        for(int i = 0; i < size; i++) {
            ColumnConstraints column = new ColumnConstraints(50);
            grid.getColumnConstraints().add(column);
           
            
        }
        //add rows on the grid using numberOfRow
        for(int i = 0; i < size; i++) {
            RowConstraints row = new RowConstraints(50);
            grid.getRowConstraints().add(row);
        }
     
        
     // add responsive cell onto the grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
           	//create a pane on each cell
                Pane pane = new Pane();
                Label l = new Label(boardData[i][j].toString());
          
                //when the cell is clicked, add a rectangle with chosen color onto the cell
                pane.setOnMouseReleased(e -> {
               	
                 //place chip here
                    
                });
                
                pane.getChildren().add(l);
                pane.getStyleClass().add("game-grid-cell"); // associate each pane with css .game-grid-cell
                if (i == 0) {
                    pane.getStyleClass().add("first-column");
                }
                if (j == 0) {
                    pane.getStyleClass().add("first-row");
                }
            	
            	
                //add cell to the grid
                grid.add(pane, i, j);
              
            }
        }
        return grid;
	}
	
	

}
