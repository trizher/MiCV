package dad.javafx.micv.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.MiCVApp;
import dad.javafx.micv.model.CV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController implements Initializable{
	
	private PersonalController personalController = new PersonalController();
	private FormacionController formacionController = new FormacionController();
	private ContactoController contactoController = new ContactoController();
	private ExperienciaController experienciaController = new ExperienciaController();
	private ConocimientoController conocimientoController = new ConocimientoController();
	
	private static CV model = new CV();
	private File file;
	
    @FXML
    private VBox root;
	
	@FXML
	private MenuItem nuevoMenuItem;

	@FXML
	private MenuItem abrirMenuItem;

	@FXML
	private MenuItem guardarMenuItem;

	@FXML
	private MenuItem guardarComoMenuItem;

	@FXML
	private MenuItem salirMenuItem;

	@FXML
	private MenuItem acercaMenuItem;

	@FXML
	private Tab personalTab;

	@FXML
	private Tab contactoTab;

	@FXML
	private Tab formacionTab;

	@FXML
	private Tab experienciaTab;

	@FXML
	private Tab conocimientosTab;
	
	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		personalTab.setContent(personalController.getView());
		formacionTab.setContent(formacionController.getView());
		contactoTab.setContent(contactoController.getView());
		experienciaTab.setContent(experienciaController.getView());
		conocimientosTab.setContent(conocimientoController.getView());
		
	}
	

    public VBox getView() {
		return root;
	}

	public static CV getModel() {
		return model;
	}

	@FXML
    void onAbrirAction(ActionEvent event) {
		try {
			FileChooser fileChooser = new FileChooser();
			ExtensionFilter extFilterXML = new ExtensionFilter("XML", "*.xml");
			ExtensionFilter extFilterAll = new ExtensionFilter("Todos los archivos", ".");
			fileChooser.getExtensionFilters().add(extFilterXML);
			fileChooser.getExtensionFilters().add(extFilterAll);
			file = fileChooser.showOpenDialog(MiCVApp.getPrimaryStage());
			CV nuevo = CV.load(file);
			model.getPersonal().setIdentificacion(nuevo.getPersonal().getIdentificacion());
			model.getPersonal().setNombre(nuevo.getPersonal().getNombre());
			model.getPersonal().setApellidos(nuevo.getPersonal().getApellidos());
			model.getPersonal().setDireccion(nuevo.getPersonal().getDireccion());
			model.getPersonal().setCodigoPostal(nuevo.getPersonal().getCodigoPostal());
			model.getPersonal().setFechaNacimiento(nuevo.getPersonal().getFechaNacimiento());
			model.getPersonal().setLocalidad(nuevo.getPersonal().getLocalidad());
			model.getPersonal().setNacionalidadList(nuevo.getPersonal().nacionalidadListProperty());
			model.getPersonal().setPais(nuevo.getPersonal().getPais());
			model.getContacto().setEmails(nuevo.getContacto().emailsProperty());
			model.getContacto().setTelefonos(nuevo.getContacto().telefonosProperty());
			model.getContacto().setWebs(nuevo.getContacto().websProperty());
			model.setFormacionList(nuevo.formacionListProperty());
			model.setExperienciasList(nuevo.experienciasListProperty());
			model.setHabilidadesList(nuevo.habilidadesListProperty());
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error al abrir archivo");
			alert.setHeaderText(null);
			alert.setContentText("Error al cargar el Currículum.");
			alert.showAndWait();
		}
    }

    @FXML
    void onGuardarAction(ActionEvent event) {
    	if (file != null) {
			try {
				model.save(file);
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error al guardar archivo");
				alert.setHeaderText(null);
				alert.setContentText("Error al guardar el Currículum.");
				alert.showAndWait();
			}
		} else {
			onGuardarComoAction(null);
		}
    }

    @FXML
    void onGuardarComoAction(ActionEvent event) {
    	try {
			FileChooser fileChooser = new FileChooser();
			ExtensionFilter extFilterXML = new ExtensionFilter("XML", "*.xml");
			ExtensionFilter extFilterAll = new ExtensionFilter("Todos los archivos", ".");
			fileChooser.getExtensionFilters().add(extFilterXML);
			fileChooser.getExtensionFilters().add(extFilterAll);
			file = fileChooser.showSaveDialog(MiCVApp.getPrimaryStage());
			model.save(file);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error al guardar archivo");
			alert.setHeaderText(null);
			alert.setContentText("Error al guardar el Currículum.");
			alert.showAndWait();
		}
    }

    @FXML
    void onNuevoAction(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Abrir nuevo archivo");
		alert.setHeaderText("¿Estás seguro de crear un nuevo Currículum?");
		alert.setContentText("Si tienes cambios sin guardar se perderán.");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
	    	model.getPersonal().setIdentificacion("");
	    	model.getPersonal().setNombre("");
	    	model.getPersonal().setApellidos("");
	    	model.getPersonal().setFechaNacimiento(null);
	    	model.getPersonal().setDireccion("");
	    	model.getPersonal().setCodigoPostal("");
	    	model.getPersonal().setLocalidad("");
	    	personalController.getPaisCombo().getSelectionModel().clearSelection();
	    	model.getPersonal().setPais(null);
	    	model.getPersonal().setNacionalidadList(null);
	    	
	    	model.getContacto().emailsProperty().clear();
	    	model.getContacto().telefonosProperty().clear();
	    	model.getContacto().websProperty().clear();
	    	
	    	model.getFormacionList().clear();
	    	model.getExperienciasList().clear();
	    	model.getHabilidadesList().clear();
		}
    	
    	
    }

    @FXML
    void onSalirAction(ActionEvent event) {
    	 MiCVApp.getPrimaryStage().close();
    }

}
