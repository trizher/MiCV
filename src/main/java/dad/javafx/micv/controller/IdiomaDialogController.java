package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Conocimiento;
import dad.javafx.micv.model.Nivel;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

public class IdiomaDialogController extends Dialog<Conocimiento> implements Initializable {

	private Conocimiento conocimiento = new Conocimiento();

	private ButtonType CREAR_BUTTON_TYPE = new ButtonType("Crear", ButtonData.OK_DONE);


    @FXML
    private TextField denominacionText;

    @FXML
    private ComboBox<Nivel> nivelCombo;

    @FXML
    private Button eliminarNivelButton;

    @FXML
    private TextField certificacionText;


	public IdiomaDialogController() {
		super();
		setTitle("Nuevo idioma");
		setHeaderText(null);
		getDialogPane().getButtonTypes().addAll(
				CREAR_BUTTON_TYPE, // botón personalizado
				ButtonType.CANCEL
			);
		getDialogPane().setContent(loadContent("/fxml/IdiomaDialog.fxml"));
		setResultConverter(dialogButton -> {
		    if (dialogButton.getButtonData() == ButtonData.OK_DONE) {
		    	Conocimiento c = new Conocimiento();
		    	c.setDenominacion(conocimiento.getDenominacion());
		    	c.setNivel(conocimiento.getNivel());
		    	return c;
		    }
		    return null;
		});
	}
	
	private Node loadContent(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
			loader.setController(this);
			return loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@FXML
	void onEliminarNivelAction(ActionEvent event) {
		nivelCombo.getSelectionModel().clearSelection();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nivelCombo.getItems().addAll(Nivel.values());
		conocimiento.denominacionProperty().bind(Bindings.concat(denominacionText.textProperty(), " (", certificacionText.textProperty(), ")"));
		conocimiento.nivelProperty().bind(nivelCombo.valueProperty());
	
		Node crearButton = getDialogPane().lookupButton(CREAR_BUTTON_TYPE);
		crearButton.disableProperty().bind(conocimiento.denominacionProperty().isEmpty()
										.or(conocimiento.nivelProperty().isNull()
										.or(certificacionText.textProperty().isEmpty())));
	}
}
