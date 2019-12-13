package dad.javafx.micv;

import dad.javafx.micv.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MiCVApp extends Application {
	
	private static Stage primaryStage;
	
	private MainController mainController;

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainController = new MainController();
		MiCVApp.primaryStage = primaryStage;

		primaryStage.getIcons().add(new Image("icons/cv64x64.png"));
		primaryStage.setTitle("MiCV");
		primaryStage.setScene(new Scene(mainController.getView()));
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);

	}

}
