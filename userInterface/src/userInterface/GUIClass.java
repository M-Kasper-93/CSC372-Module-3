/*Purpose of GUI class: To contain all GUI functionality */

package userInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GUIClass extends Application {
    @Override
    public void start(Stage stage) {
        HBox hbox = new HBox(10);
   
        MenuBar menuBar = new MenuBar();
        Menu options = new Menu("Options");
        MenuItem option1 = new MenuItem("Display date and time");
        MenuItem option2 = new MenuItem("Generate .txt file");
        MenuItem option3 = new MenuItem("Change frame color");
        MenuItem option4 = new MenuItem("Exit program");
        
        TextField dateTimeField = new TextField();
        TextField userInputField = new TextField();
 
        hbox.getChildren().addAll(menuBar, userInputField, dateTimeField);

        //First option: Display date and time
        option1.setOnAction(event -> {
            LocalDateTime currentDateTime = LocalDateTime.now();
            dateTimeField.setText("Current date and time: " + currentDateTime);
            dateTimeField.setEditable(false);
        });

        //Second option: Write to .txt file
        option2.setOnAction(event -> {
            String textFieldInput = userInputField.getText();
            try (PrintWriter fileOutput = new PrintWriter(new FileWriter("log.txt", true))) {
                fileOutput.println(textFieldInput);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //Third option: Change background color to a random green hue
        option3.setOnAction(event -> {
            GreenColorRandomizer randomGreenColor = new GreenColorRandomizer();
            Color randomGreenColor = greenColorRandomizer.getRandomGreenColor();
            stage.getScene().setFill(randomGreenColor);
        });

        //Fourth option: Exit program
        option4.setOnAction(event -> {
            stage.close();
        });

        options.getItems().add(option1);
        options.getItems().add(option2);
        options.getItems().add(option3);
        options.getItems().add(option4);

        menuBar.getMenus().add(options);

        Scene scene = new Scene(hbox, 600, 400);
        stage.setScene(scene);
        stage.setTitle("User Interface I");
        stage.show();
    }
    
    //launch application
	public static void main(String[] args) {
		launch(args);
	}
}