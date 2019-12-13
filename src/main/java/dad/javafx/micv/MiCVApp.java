package dad.javafx.micv;

import dad.javafx.micv.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MiCVApp extends Application {
	
	private MainController mainController;

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainController = new MainController();

		primaryStage.getIcons().add(new Image("icons/cv64x64.png"));
		primaryStage.setTitle("MiCV");
		primaryStage.setScene(new Scene(mainController.getView()));
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
