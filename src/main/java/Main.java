
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		final String appName = "Kalkulator 0.1";
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("fxml/MainPane.fxml"));
		AnchorPane anchorPane = loader.load();
		Scene scene = new Scene(anchorPane);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle(appName);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
