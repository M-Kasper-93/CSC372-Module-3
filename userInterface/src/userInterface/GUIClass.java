/*Purpose of GUI class: To contain all GUI functionality */

package userInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;

public class GUIClass {
	public class GUIClass extends Application {
		Label label = null;
		Button button = null;
		@Override
		public void start(Stage stage) {
			Scene scene = null;
			GridPane gridPane = null;
			
			gridPane = new GridPane();
			scene = new Scene(gridPane);
			
			
			
			
			
			
			
			stage.setScene(scene);
			stage.setTitle("User Interface I");
			stage.show();
		}
	}
}
