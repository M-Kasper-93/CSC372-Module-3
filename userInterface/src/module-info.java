module userInterface {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	
	opens userInterface to javafx.fxml;
	
	exports userInterface;
}