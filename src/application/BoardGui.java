package application;



import javafx.application.Application;
import javafx.geometry.Pos;
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
import javafx.stage.Stage;



public class BoardGui extends Application{
	private BoardPresenter presenter;
	
	
	private GridPane grid = new GridPane();
	private Button player1Button;
	private Button player2Button;
	public BoardGui() {
		System.out.println("board gui");
		
	}
	
	@Override
	public void init() throws Exception {
		System.out.println("init");
		setPresenter(new BoardPresenter(Integer.parseInt(getParameters().getRaw().get(0).trim()), Integer.parseInt(getParameters().getRaw().get(1).trim())));
		/**
		 * initialize and create the grid
		 * @param rows and cols of the grid
		 */
		
		
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
	public GridPane createGrid(){
		
		setGridPane(presenter.createGrid(Integer.parseInt(getParameters().getRaw().get(0).trim())));
        
		return getGridPane();
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
	
	public void show(Stage primaryStage){
		System.out.println("show");
		
		
		BorderPane root = new BorderPane();
		
		
		root.setCenter(createGrid());
		root.setRight(showRightBoxGUI());
		
		Scene scene = new Scene(root, 700,700);
		//link to the css file
		scene.getStylesheets().add(this.getClass().getResource("/game.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Connect 4");
		primaryStage.show();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");
		show(primaryStage);
		
	}

	

}
