package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Experiencia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

public class ExperienciaDialogController extends Dialog<Experiencia> implements Initializable {
	
	private Experiencia experiencia = new Experiencia();

	private ButtonType CREAR_BUTTON_TYPE = new ButtonType("Crear", ButtonData.OK_DONE);

	@FXML
	private TextField denominacionText;

	@FXML
	private TextField empleadorText;

	@FXML
	private DatePicker desdePicker;

	@FXML
	private DatePicker hastaPicker;

	public ExperienciaDialogController() {
		super();
		setTitle("Nueva experiencia");
		setHeaderText(null);
		getDialogPane().getButtonTypes().addAll(
				CREAR_BUTTON_TYPE, // botón personalizado
				ButtonType.CANCEL
			);
		getDialogPane().setContent(loadContent("/fxml/ExperienciaDialog.fxml"));
		setResultConverter(dialogButton -> {
		    if (dialogButton.getButtonData() == ButtonData.OK_DONE) {
		    	Experiencia e = new Experiencia();
		    	e.setDenominacion(experiencia.getDenominacion());
		    	e.setEmpleador(experiencia.getEmpleador());
		    	e.setDesde(experiencia.getDesde());
		    	e.setHasta(experiencia.getHasta());
		    	return e;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		experiencia.denominacionProperty().bind(denominacionText.textProperty());
		experiencia.empleadorProperty().bind(empleadorText.textProperty());
		experiencia.desdeProperty().bind(desdePicker.valueProperty());
		experiencia.hastaProperty().bind(hastaPicker.valueProperty());
		
		Node crearButton = getDialogPane().lookupButton(CREAR_BUTTON_TYPE);
		crearButton.disableProperty().bind(experiencia.denominacionProperty().isEmpty()
										.or(experiencia.empleadorProperty().isEmpty()
										.or(experiencia.desdeProperty().isNull())
										.or(experiencia.hastaProperty().isNull())));

	}

}
