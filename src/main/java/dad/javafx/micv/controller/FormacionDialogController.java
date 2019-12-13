package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Titulo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

public class FormacionDialogController extends Dialog<Titulo> implements Initializable {
	
	private Titulo titulo = new Titulo();
	
	private ButtonType CREAR_BUTTON_TYPE = new ButtonType("Crear", ButtonData.OK_DONE);

	@FXML
	private TextField denominacionText;

	@FXML
	private TextField organizadorText;

	@FXML
	private DatePicker desdePicker;

	@FXML
	private DatePicker hastaPicker;
	
	public FormacionDialogController() {
		super();
		setTitle("Nuevo título");
		setHeaderText(null);
		getDialogPane().getButtonTypes().addAll(
				CREAR_BUTTON_TYPE, // botón personalizado
				ButtonType.CANCEL
			);
		getDialogPane().setContent(loadContent("/fxml/FormacionDialog.fxml"));
		setResultConverter(dialogButton -> {
		    if (dialogButton.getButtonData() == ButtonData.OK_DONE) {
		    	Titulo t = new Titulo();
		    	t.setDenominacion(titulo.getDenominacion());
		    	t.setOrganizador(titulo.getOrganizador());
		    	t.setDesde(titulo.getDesde());
		    	t.setHasta(titulo.getHasta());
		    	return t;
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
		titulo.denominacionProperty().bind(denominacionText.textProperty());
		titulo.organizadorProperty().bind(organizadorText.textProperty());
		titulo.desdeProperty().bind(desdePicker.valueProperty());
		titulo.hastaProperty().bind(hastaPicker.valueProperty());
		
		Node crearButton = getDialogPane().lookupButton(CREAR_BUTTON_TYPE);
		crearButton.disableProperty().bind(titulo.denominacionProperty().isEmpty()
											.or(titulo.organizadorProperty().isEmpty()
											.or(titulo.desdeProperty().isNull()
											.or(titulo.hastaProperty().isNull()))));
	}
	
	
}
