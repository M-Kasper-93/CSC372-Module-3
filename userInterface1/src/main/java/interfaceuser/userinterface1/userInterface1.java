/* Purpose of userInterface1 class: Houses GUI components and functionality in one class
* Developed by Megan Kasper, due on 1 December 2024 */

package interfaceuser.userinterface1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDateTime;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class userInterface1 extends Application {
    @Override
    public void start(Stage stage) {
        //establish container
        HBox hbox = new HBox(10);
        Scene scene = new Scene(hbox, 600, 400);
        stage.setScene(scene);
        stage.setTitle("User Interface I");
        stage.show();

        //build menu components
        MenuBar menuBar = new MenuBar();
        Menu options = new Menu("Options");
        MenuItem option1 = new MenuItem("Display date and time");
        MenuItem option2 = new MenuItem("Generate .txt file");
        MenuItem option3 = new MenuItem("Change frame color");
        MenuItem option4 = new MenuItem("Exit program");

        //text fields
        TextField dateTimeField = new TextField();
        dateTimeField.setPrefWidth(250);
        dateTimeField.setPrefHeight(10);
        dateTimeField.setEditable(false);
        TextField userInputField = new TextField();

        //add components to container
        hbox.getChildren().addAll(menuBar, userInputField, dateTimeField);

        //first option: Display date and time
        option1.setOnAction(event -> {
            LocalDateTime currentDateTime = LocalDateTime.now();
            dateTimeField.setText("Current date and time: " + currentDateTime);
            dateTimeField.setEditable(false);
        });

        //second option: Write to .txt file
        option2.setOnAction(event -> {
            String textFieldInput = userInputField.getText();
            try (PrintWriter fileOutput = new PrintWriter(new FileWriter("log.txt", true))) {
                fileOutput.println(textFieldInput);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //third option: Change background color to a random green hue
        option3.setOnAction(event -> {
            double randomGreen = Math.random() * 0.5 + 0.5;
            Color randomGreenColor = new Color(0.0, randomGreen, 0.0, 1.0);
            String colorString = String.format("#%02X%02X%02X", (int) (randomGreenColor.getRed() * 255), (int) (randomGreenColor.getGreen() * 255), (int) (randomGreenColor.getBlue() * 255));
            HBox root = (HBox) stage.getScene().getRoot();
            root.setStyle("-fx-background-color: " + colorString + ";");
            stage.getScene().getRoot().requestLayout();
        });

        //fourth option: Exit program
        option4.setOnAction(event -> {
            stage.close();
        });

        //add menu options to menu menuBar
        options.getItems().add(option1);
        options.getItems().add(option2);
        options.getItems().add(option3);
        options.getItems().add(option4);

        menuBar.getMenus().add(options);
    }

    //main method to launch application
    public static void main(String[] args) {
        launch();
    }
}