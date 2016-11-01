package application;



import java.util.List;

//import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;



public class BoardGui extends Application{
	private BoardPresenter presenter;
	
	
	private GridPane grid;
	private Button player1Button;
	private Button player2Button;
	private double chipWidth =70;
	private double chipHeight =70;
	private BorderPane root; 
	
	public BoardGui(BoardPresenter presenter) {
		//System.out.println("board gui");
		this.presenter = presenter; 
		presenter.setView(this);
		
		//createGrid(size);
		
	}
	
	public void setGridPane(GridPane grid) {
		this.grid = grid;
	}
	public GridPane getGridPane() {
		return this.grid;
	}
	public void setPresenter(BoardPresenter presenter) {
		this.presenter = presenter;
	}
	public BoardPresenter getPresenter() {
		return this.presenter;
	}
	public Button getPlayer1Button() {
		return this.player1Button;
	}
	public void setPlayer1Button(Button player1Button) {
		this.player1Button = player1Button;
	}
	public Button getPlayer2Button() {
		return this.player2Button;
	}
	public void setPlayer2Button(Button player2Button) {
		this.player2Button = player2Button;
	}
	
	public double getChipWidth(){
		return this.chipWidth;
	}
	
	public double getChipHeight(){
		return this.chipHeight; 
	}
	
	public VBox showRightBoxGUI(){
		VBox rightBox = new VBox(10);
		Label label = new Label("CONNECT FOUR");
		setPlayer1Button(new Button("Player "+presenter.getPlayer1().toString()));
		setPlayer2Button(new Button("Player "+presenter.getPlayer2().toString()));
		
		player1Button.setMinWidth(200);
		player2Button.setMinWidth(200);
		
		player1Button.setDisable(false);
		player2Button.setDisable(true);
		
		Button clearButton = new Button("Clear");
		clearButton.setOnMouseClicked(e-> {
			clear();
		});
		
		rightBox.getChildren().addAll(label, player1Button, player2Button, clearButton);
		rightBox.setAlignment(Pos.TOP_CENTER);
		return rightBox;
	}
	
	public Rectangle rectangleChip(Paint color){
		Rectangle rec = new Rectangle (getChipWidth()-1, getChipHeight()-1);
		//Rectangle rec = new Rectangle();
		//rec.xProperty().bind(grid.heightProperty());
        //rec.yProperty().bind(grid.heightProperty());
		rec.setFill(color);
		return rec ; 
	}
	
	public void promptWinner(String playerId) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Game Over!");		
		alert.setContentText("Player "+playerId + " won.");
		alert.showAndWait();
		clear();
	}
	
	public void promptTie()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Game Over!");		
		alert.setContentText("It's a tie!");
		alert.showAndWait();
		clear();
	}
	
	public void promptInvalidMove()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Invalid Move!");		
		alert.setContentText("Try again!");
		alert.showAndWait();
	}
	
	public void createGrid(int size){
		
		grid = new GridPane();

		grid.getStyleClass().add("game-grid");
		
		//add colums on the grid using numberOfColumns
        for(int i = 0; i < size; i++) {
        	//ColumnConstraints column = new ColumnConstraints(getChipHeight());
        	 ColumnConstraints col = new ColumnConstraints();
             col.setHgrow(Priority.ALWAYS);
        	grid.getColumnConstraints().add(col);
        
            
        }
        //add rows on the grid using numberOfRow
        for(int i = 0; i < size; i++) {
        	//RowConstraints row = new RowConstraints(getChipWidth());
        	RowConstraints row = new RowConstraints();
        	row.setVgrow(Priority.ALWAYS);
        	grid.getRowConstraints().add(row);
        }
     System.out.println(grid.getMinWidth());
        
     // add responsive cell onto the grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Pane pane = new Pane();

                int column= i;
          
                //when the cell is clicked, add a rectangle with chosen color onto the cell
                pane.setOnMouseReleased(e -> {
               	
                 presenter.putChip(column);
                 presenter.checkWinner();
                    
                });
                
                
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
	}
	
	public void putChip (int row, int column)
	{

		for (Node node: grid.getChildren())
		{
			if(GridPane.getColumnIndex(node) == column && GridPane.getRowIndex(node) == row)
			{
				AnchorPane pane = (AnchorPane) node;
				if (presenter.getTurn() ==1){
					player1Button.setDisable(true);
					player2Button.setDisable(false);
				pane.getChildren().add(rectangleChip(presenter.getPlayer1().getChip().getColor()));
			
				}else{
					player1Button.setDisable(false);
					player2Button.setDisable(true);
				pane.getChildren().add(rectangleChip(presenter.getPlayer2().getChip().getColor()));
				}
				
				//pane.setDisable(true);
			}
		}
	}
	
	public void clear()
	{
		grid.getChildren().clear();
		createGrid(presenter.getSize());
		root.setCenter(grid); 
	
		
		player1Button.setDisable(false);
		player2Button.setDisable(true);
		
		presenter.clear();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		createGrid(presenter.getSize());
		root = new BorderPane();
		
		 
		
		//grid.prefHeightProperty().bind(root.heightProperty());
        //grid.prefWidthProperty().bind(root.widthProperty());

		root.setCenter(grid);
	
		root.setRight(showRightBoxGUI());
		
		Scene scene = new Scene(root, 700,700);
		
		
		//link to the css file

		scene.getStylesheets().add(this.getClass().getResource("game.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Connect 4");
		
		primaryStage.show();
	}

	

}
