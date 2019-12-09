package dad.javafx.micv.raiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.contacto.ContactoController;
import dad.javafx.micv.formacion.FormacionController;
import dad.javafx.micv.personal.PersonalController;
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
		
		
	}
	

    public VBox getView() {
		return root;
	}


	public void setRoot(VBox root) {
		this.root = root;
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
    	System.out.println("nuevo");
    }

    @FXML
    void onSalirAction(ActionEvent event) {

    }

}
