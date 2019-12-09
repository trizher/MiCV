package dad.javafx.micv.contacto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.models.TipoTelefono;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

public class ContactoController implements Initializable {

	@FXML
	private VBox view;

	@FXML
	private TitledPane telefonosPane;

	@FXML
	private Button aniadirTelefonoButton;

	@FXML
	private Button eliminarTelefonoButton;

	@FXML
	private TitledPane correosPane;

	@FXML
	private Button aniadirCorreoButton;

	@FXML
	private Button eliminarCorreoButton;

	@FXML
	private TitledPane websPane;

	@FXML
	private Button aniadirWebButton;

	@FXML
	private Button eliminarWebButton;

	public ContactoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ContactoView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public VBox getView() {
		return view;
	}

	@FXML
	void onAniadirCorreoAction(ActionEvent event) {

	}

	@FXML
	void onAniadirTelefonoAction(ActionEvent event) {
//		Dialog<Pair<String, String>> dialog = new Dialog<>();
//		dialog.setTitle("Nuevo teléfono");
//		dialog.setHeaderText("Introduzca el nuevo número de teléfono");
//
//		ButtonType aniadirButtonType = new ButtonType("Añadir", ButtonData.OK_DONE);
//		ButtonType cancelarButtonType = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
//		dialog.getDialogPane().getButtonTypes().addAll(aniadirButtonType, cancelarButtonType);
//
//		GridPane grid = new GridPane();
//		grid.setHgap(10);
//		grid.setVgap(10);
//		grid.setPadding(new Insets(20, 150, 10, 10));
//
//		TextField numeroText = new TextField();
//		numeroText.setPromptText("Número de teléfono");
//		ComboBox<TipoTelefono> tipoTelefonoCombo = new ComboBox<TipoTelefono>();
//		tipoTelefonoCombo.getItems().addAll(TipoTelefono.DOMICILIO, TipoTelefono.MOVIL);
//		tipoTelefonoCombo.setPromptText("Seleccione un tipo");
//
//		grid.add(new Label("Número:"), 0, 0);
//		grid.add(numeroText, 1, 0);
//		grid.add(new Label("Tipo:"), 0, 1);
//		grid.add(tipoTelefonoCombo, 1, 1);
//
//		// Enable/Disable login button depending on whether a username was entered.
//		Node loginButton = dialog.getDialogPane().lookupButton(aniadirButtonType);
//		loginButton.setDisable(true);
//
//		// Do some validation (using the Java 8 lambda syntax).
//		numeroText.textProperty().addListener((observable, oldValue, newValue) -> {
//		    loginButton.setDisable(newValue.trim().isEmpty());
//		});
//
//		dialog.getDialogPane().setContent(grid);
//
//		// Request focus on the username field by default.
//		Platform.runLater(() -> numeroText.requestFocus());
//
//		// Convert the result to a username-password-pair when the login button is clicked.
//		dialog.setResultConverter(dialogButton -> {
//		    if (dialogButton == aniadirButtonType) {
//		        return new Pair<>(numeroText.getText(), tipoTelefonoCombo.getSelectionModel().getSelectedItem());
//		    }
//		    return null;
//		});
//
//		Optional<Pair<String, String>> result = dialog.showAndWait();
//
//		result.ifPresent(usernamePassword -> {
//		    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
//		});
	}

	@FXML
	void onAniadirWebAction(ActionEvent event) {

	}

	@FXML
	void onEliminarCorreoAction(ActionEvent event) {

	}

	@FXML
	void onEliminarTelefonoAction(ActionEvent event) {

	}

	@FXML
	void onEliminarWebAction(ActionEvent event) {

	}

}
