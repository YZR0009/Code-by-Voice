package UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	
	public static void display(String title, String message, boolean isblock) {
		Stage stage = new Stage();
		
		if(isblock == true)
			stage.initModality(Modality.APPLICATION_MODAL);
		else
			stage.initModality(Modality.NONE);
		stage.setTitle(title);
		stage.setMinWidth(500);
		
		Label label = new Label();
		label.setText(message);
		Button closeButton = new Button("close");
		closeButton.setOnAction(e -> stage.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		stage.showAndWait(); // need to close before go back to main stage
	}
}
