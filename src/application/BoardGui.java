package application;



import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class BoardGui extends Application{
	private BoardPresenter presenter;
	
	
	private GridPane grid;
	private Button player1Button;
	private Button player2Button;
	private double chipWidth =50;
	private double chipHeight =50;
	public BoardGui(BoardPresenter presenter, int size) {
		//System.out.println("board gui");
		this.presenter = presenter; 
		presenter.setView(this);
		
		createGrid(size);
		
	}
	
	@Override
	public void init() throws Exception {
		//this.chipHeight=50;
		//this.chipWidth=50;
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
	public double getChipWidth() {
		return this.chipWidth;
	}
	public double getChipHeight() {
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
		rightBox.getChildren().addAll(label, player1Button, player2Button);
		rightBox.setAlignment(Pos.TOP_CENTER);
		return rightBox;
	}
	
	public void promptWinner(String playerId) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Game Over!");		
		alert.setContentText(playerId + "won.");
		alert.showAndWait();	
	}
	
	public void promptTie()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Game Over!");		
		alert.setContentText("It's a tie!");
		alert.showAndWait();
	}
	
	public Rectangle rectangleChip(Paint color){
		Rectangle rec = new Rectangle(getChipWidth()-1, getChipHeight()-1);
		rec.setFill(color);
		return rec;
	}
	public void createGrid(int size){
		
		grid = new GridPane();
		grid.getStyleClass().add("game-grid");
		
		//add colums on the grid using numberOfColumns
        for(int i = 0; i < size; i++) {
            ColumnConstraints column = new ColumnConstraints(getChipHeight());
            grid.getColumnConstraints().add(column);
            
        }
        //add rows on the grid using numberOfRow
        for(int i = 0; i < size; i++) {
            RowConstraints row = new RowConstraints(getChipWidth());
            grid.getRowConstraints().add(row);
        }
     
        
     // add responsive cell onto the grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Pane pane = new Pane();
                int column= i;
                int row = j;
          
                //when the cell is clicked, add a rectangle with chosen color onto the cell
                pane.setOnMouseReleased(e -> {
                	
                	presenter.setRow(row);
                 //show whose is playing using button
                 if(presenter.getTurn()==1){
                	 System.out.println("turn: "+presenter.getTurn());
                	 System.out.println("player 1: "+presenter.getPlayer1().getChip().getColor());
                	
                	 player1Button.setDisable(false);
                	 player2Button.setDisable(true);
                	 pane.getChildren().add(rectangleChip(presenter.getPlayer1().getChip().getColor()));
                	 presenter.putChip(column);
                	 pane.setDisable(true);
                 }else{
                	 System.out.println("turn: "+presenter.getTurn());
                	 System.out.println("player 2: "+presenter.getPlayer2().getChip().getColor());
                	 
                	 player1Button.setDisable(true);
                	 player2Button.setDisable(false);
                	 pane.getChildren().add(rectangleChip(presenter.getPlayer2().getChip().getColor()));
                	 presenter.putChip(column);
                	 pane.setDisable(true);
                 }
                   
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
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane root = new BorderPane();

		root.setCenter(grid);
		root.setRight(showRightBoxGUI());
		
		Scene scene = new Scene(root, 700,700);
		//link to the css file
		scene.getStylesheets().add(this.getClass().getResource("/game.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Connect 4");
		primaryStage.show();
	}

	

}
