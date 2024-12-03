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
import java.time.LocalDateTime;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
/*import javafx.scene.layout.GridPane;*/

public class GUIClass {
	public class GUIClass extends Application {
		Label label = null;
		Button button = null;
		@Override
		public void start(Stage stage) {
			Scene scene = null;
			TextField dateTime = null;
			TextField userInput = null;
			
			MenuItem option1 = new MenuItem("Display date and time");
			MenuItem option2 = new MenuItem("Generate .txt file");
			MenuItem option3 = new MenuItem("Change frame color");
			MenuItem option4 = new MenuItem("Exit program");
			
			//First option displays date and time
			option1.setOnAction(EventHandlerActionEvent) new EventHandlerActionEvent() {
				@Override
				public void handle(ActionEvent event) {
					dateTime = new TextField();
					LocalDateTime currentDateTime = LocalDateTime.now();
					dateTime.setText("Current date and time: " + currentDateTime);
					dateTime.setEditable(false);
				}
			}
			
			//Second option writes text box contents to a text file named "log.txt"
			option2.setOnAction(EventHandlerActionEvent) new EventHandlerActionEvent() {
				@Override
				public void handle(ActionEvent event) {
					String textFieldInput = userInput.getText();
					PrintWriter fileOutput = new PrintWriter(new FileWriter("log.txt", true)))
					try (fileOutput) {
						fileOutput.println(textFieldInput);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
			/*GridPane gridPane = null;
			
			gridPane = new GridPane();
			scene = new Scene(gridPane);*/
			
			
			
			
			
			
			
			stage.setScene(scene);
			stage.setTitle("User Interface I");
			stage.show();
		}
	}
}
