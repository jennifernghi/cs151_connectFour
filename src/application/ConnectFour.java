

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * entry point to run the game
 *
 *
 */
public class ConnectFour extends Application {

	private static Integer[] arguments = new Integer[2];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
				//get args[0] and args[1] and add them into arguments[] after parse them into Integer
			
				arguments[0] = Integer.parseInt(args[0].trim());
				arguments[1] = Integer.parseInt(args[1].trim());
				//if winningmove < size
				if (arguments[1] < arguments[0]) {
					launch(args);//launch gui
				} else {
					//show error
					System.out.println("winner move must smaller than size");
					System.exit(0);
				}
			

		} catch (Exception e) {
			//show errors
			System.out.println("Invalid argument type. check command line!");
			System.out.println("java ConnectFour size winningmove");
			System.out.println("or java -jar Connect4.jar size winningmove");
			System.exit(0);
		}

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BoardGui app = new BoardGui(new BoardPresenter(arguments[0], arguments[1]));
		app.start(primaryStage);

	}

}
