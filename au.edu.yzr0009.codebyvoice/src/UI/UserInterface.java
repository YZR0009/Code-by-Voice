package UI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.SpeechRecognition;

public class UserInterface extends Application{
	
	Button startButton;
	Button commandButton;
	Button endButton;
	String message;

	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		//launch();
	//}

	public void start(Stage primaryStage) throws FileNotFoundException {
		primaryStage.setTitle("Code by Voice");
		startButton = new Button();
		startButton.setText("start");
		commandButton = new Button();
		commandButton.setText("command");
		endButton = new Button();
		endButton.setText("end");
		
		//Image image = new Image("/logo.jpg");
		Image image = new Image(new FileInputStream("/Users/yunfanrao/Desktop/Master's project/my logo.jpg")); 
		
		ImageView imageView = new ImageView();
		imageView.setImage(image);
        imageView.setX(50); 
        imageView.setY(50);
        imageView.setFitHeight(150); 
        imageView.setFitWidth(300);
		
		message = "\t 1. To print hello world program: hello world or example class\n\n";
		message += "\t 2. To print toString method: toString\n\n";
		message += "\t 3. Create a class: \n\tCreate a class named/called ClassName\n";
		message += "\t\t(replace ClassName with a specific name)\n";
		message += "\t\tfor example: create a class named firstProgram.\n\n";
		message += "\t 4. Create a constructor: \n\tCreate a constructor named/called constructorName\n\n";
		message += "\t 5. Create a method: \n\tCreate a method name MethodName with number parameters para1 para2 ...\n";
		message += "\t\t(replace MethodName, number and para1 with a specific name, a number and a parameter name)\n";
		message += "\t\tfor example: create a method named total with one parameter int length.\n\n";
		message += "\t 6. To pause the application: sleep\n\n";
		message += "\t 7. To continue the application: wake up\n\n";
		
		
		
		//commandButton.setOnAction(e -> AlertBox.display("Command list", message));
		startButton.setOnAction(e -> {
			new SpeechRecognition();
			AlertBox.display("Code by Voice is working", "Welcome! Start your speech...\n", false);
		});
		commandButton.setOnAction(e -> AlertBox.display("Command list", message, false));
		endButton.setOnAction(e -> System.exit(1));
		
		//StackPane layout = new StackPane();
		//layout.getChildren().add(iv1);
		//layout.getChildren().addAll(imageView, startButton);
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(imageView, startButton,commandButton,endButton);
		//scene1 = new Scene(layout1, 300, 200);
		
		//Scene scene = new Scene(layout, 300, 200);
		Scene scene = new Scene(layout1, 300, 320);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
}
