package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.CV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class MainController implements Initializable{
	
	private PersonalController personalController = new PersonalController();
	private FormacionController formacionController = new FormacionController();
	private ContactoController contactoController = new ContactoController();
	private ExperienciaController experienciaController = new ExperienciaController();
	private ConocimientoController conocimientoController = new ConocimientoController();
	
	private static CV model = new CV();
	
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

    }

    @FXML
    void onGuardarAction(ActionEvent event) {

    }

    @FXML
    void onGuardarComoAction(ActionEvent event) {

    }

    @FXML
    void onNuevoAction(ActionEvent event) {
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

    @FXML
    void onSalirAction(ActionEvent event) {
    	 
    }

}
