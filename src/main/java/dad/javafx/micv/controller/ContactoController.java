package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.model.CV;
import dad.javafx.micv.model.Contacto;
import dad.javafx.micv.model.Email;
import dad.javafx.micv.model.Telefono;
import dad.javafx.micv.model.TipoTelefono;
import dad.javafx.micv.model.Web;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;

public class ContactoController implements Initializable {

	private CV cv;
	private Web webSeleccionada = new Web();
	private Telefono telSeleccionado = new Telefono();
	private Email correoSeleccionado = new Email();
	
	@FXML
    private VBox view;

    @FXML
    private TableView<Telefono> telefonosTable;

    @FXML
    private TableColumn<Telefono, String> numeroColumn;

    @FXML
    private TableColumn<Telefono, TipoTelefono> tipoColumn;

    @FXML
    private Button aniadirTelefonoButton;

    @FXML
    private Button eliminarTelefonoButton;

    @FXML
    private TableView<Email> correosTable;

    @FXML
    private TableColumn<Email, String> mailColumn;

    @FXML
    private Button aniadirCorreoButton;

    @FXML
    private Button eliminarCorreoButton;

    @FXML
    private TableView<Web> websTable;

    @FXML
    private TableColumn<Web, String> urlColumn;

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
		cv = MainController.getModel();
		cv.setContacto(new Contacto());

		telefonosTable.itemsProperty().bindBidirectional(cv.getContacto().telefonosProperty());
		numeroColumn.setCellValueFactory(v -> v.getValue().numeroProperty());
		tipoColumn.setCellValueFactory(v -> v.getValue().tipoProperty());
		numeroColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		tipoColumn.setCellFactory(ComboBoxTableCell.forTableColumn(TipoTelefono.values()));
		
		correosTable.itemsProperty().bindBidirectional(cv.getContacto().emailsProperty());
		mailColumn.setCellValueFactory(v -> v.getValue().direccionProperty());
		mailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		websTable.itemsProperty().bindBidirectional(cv.getContacto().websProperty());
		urlColumn.setCellValueFactory(v -> v.getValue().urlProperty());
		urlColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		eliminarTelefonoButton.disableProperty().bind(telefonosTable.getSelectionModel().selectedItemProperty().isNull());
		eliminarCorreoButton.disableProperty().bind(correosTable.getSelectionModel().selectedItemProperty().isNull());
		eliminarWebButton.disableProperty().bind(websTable.getSelectionModel().selectedItemProperty().isNull());

	}

	public VBox getView() {
		return view;
	}

	@FXML
	void onAniadirCorreoAction(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Nuevo e-mail");
		dialog.setHeaderText("Crear una nueva dirección de correo.");
		dialog.setContentText("E-mail:");
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(mail -> {
			Email correo = new Email();
			correo.setDireccion(mail);
			cv.getContacto().emailsProperty().add(correo);
		});
	}

	@FXML
	void onAniadirTelefonoAction(ActionEvent event) {
		TelefonoDialogController tlfDialogController = new TelefonoDialogController();
		Optional<Telefono> result = tlfDialogController.showAndWait();
		result.ifPresent(tlf -> {
			cv.getContacto().telefonosProperty().add(tlf);
		});
		
	}	

	@FXML
	void onAniadirWebAction(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog("http://");
		dialog.setTitle("Nueva web");
		dialog.setHeaderText("Crea una nueva dirección web.");
		dialog.setContentText("URL:");
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(url -> {
			Web web = new Web();
			web.setUrl(url);
			cv.getContacto().websProperty().add(web);
		});
	}

	@FXML
	void onEliminarCorreoAction(ActionEvent event) {
		correoSeleccionado = correosTable.getSelectionModel().getSelectedItem();
		if(correoSeleccionado != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Borrar e-mail");
			alert.setHeaderText("Confirmacion de borrado de e-mail.");
			alert.setContentText("¿Está seguro de que desea borrar el correo: "+ correoSeleccionado.getDireccion() +"?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				cv.getContacto().emailsProperty().remove(correoSeleccionado);
			}
		}
	}

	@FXML
	void onEliminarTelefonoAction(ActionEvent event) {
		telSeleccionado = telefonosTable.getSelectionModel().getSelectedItem();
		if(telSeleccionado != null){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Borrar teléfono");
			alert.setHeaderText("Confirmacion de borrado de teléfono.");
			alert.setContentText("¿Está seguro de que desea borrar el teléfono: "
									+ telSeleccionado.getNumero() 
									+ "(" + telSeleccionado.getTipo() +")?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				cv.getContacto().telefonosProperty().remove(telSeleccionado);
			}
		}
	}

	@FXML
	void onEliminarWebAction(ActionEvent event) {
		webSeleccionada = websTable.getSelectionModel().getSelectedItem();
		if(webSeleccionada != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Borrar web");
			alert.setHeaderText("Confirmacion de borrado de página web.");
			alert.setContentText("¿Está seguro de que desea borrar la web: "+ webSeleccionada.getUrl() +"?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				cv.getContacto().websProperty().remove(webSeleccionada);
			}
		}
	}

}
