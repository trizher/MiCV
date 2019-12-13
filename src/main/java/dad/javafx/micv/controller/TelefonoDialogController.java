package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Telefono;
import dad.javafx.micv.model.TipoTelefono;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

public class TelefonoDialogController extends Dialog<Telefono> implements Initializable  {

	private Telefono telefono = new Telefono();

	private ButtonType ANIADIR_BUTTON_TYPE = new ButtonType("Añadir", ButtonData.OK_DONE);
	
    @FXML
    private TextField numeroText;

    @FXML
    private ComboBox<TipoTelefono> tipoCombo;
    
    public TelefonoDialogController() {
		super();
		setTitle("Nuevo teléfono");
		setHeaderText("Introduzca el nuevo número de teléfono.");
		getDialogPane().getButtonTypes().addAll(
				ANIADIR_BUTTON_TYPE, // botón personalizado
				ButtonType.CANCEL
			);
		getDialogPane().setContent(loadContent("/fxml/TelefonoDialog.fxml"));
		setResultConverter(dialogButton -> {
		    if (dialogButton.getButtonData() == ButtonData.OK_DONE) {
		    	Telefono tlf = new Telefono();
		    	tlf.setNumero(telefono.getNumero());
		    	tlf.setTipo(telefono.getTipo());
		        return tlf;
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
		tipoCombo.getItems().addAll(TipoTelefono.values());
		
		telefono.numeroProperty().bind(numeroText.textProperty());
		telefono.tipoProperty().bind(tipoCombo.valueProperty());
		
		Node aniadirButton = getDialogPane().lookupButton(ANIADIR_BUTTON_TYPE);
		aniadirButton.disableProperty().bind(telefono.numeroProperty().isEmpty()
											.or(telefono.tipoProperty().isNull()));
	}

}
