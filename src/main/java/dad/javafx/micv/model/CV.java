package dad.javafx.micv.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CV {
	
	private ObjectProperty<Personal> personal = new SimpleObjectProperty<Personal>();
	private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<Contacto>();
	private ListProperty<Conocimiento> habilidadesList = new SimpleListProperty<Conocimiento>(FXCollections.observableArrayList());
	private ListProperty<Experiencia> experienciasList = new SimpleListProperty<Experiencia>(FXCollections.observableArrayList());
	private ListProperty<Titulo> formacionList = new SimpleListProperty<Titulo>(FXCollections.observableArrayList());
	
	
	public ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}
	
	public Personal getPersonal() {
		return this.personalProperty().get();
	}
	
	public void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}
	
	public ObjectProperty<Contacto> contactoProperty() {
		return this.contacto;
	}
	
	public Contacto getContacto() {
		return this.contactoProperty().get();
	}
	
	public void setContacto(final Contacto contacto) {
		this.contactoProperty().set(contacto);
	}
	
	public ListProperty<Conocimiento> habilidadesListProperty() {
		return this.habilidadesList;
	}
	
	public ObservableList<Conocimiento> getHabilidadesList() {
		return this.habilidadesListProperty().get();
	}
	
	public void setHabilidadesList(final ObservableList<Conocimiento> habilidadesList) {
		this.habilidadesListProperty().set(habilidadesList);
	}
	
	public ListProperty<Experiencia> experienciasListProperty() {
		return this.experienciasList;
	}
	
	public ObservableList<Experiencia> getExperienciasList() {
		return this.experienciasListProperty().get();
	}
	
	public void setExperienciasList(final ObservableList<Experiencia> experienciasList) {
		this.experienciasListProperty().set(experienciasList);
	}
	
	public ListProperty<Titulo> formacionListProperty() {
		return this.formacionList;
	}
	
	public ObservableList<Titulo> getFormacionList() {
		return this.formacionListProperty().get();
	}
	
	public void setFormacionList(final ObservableList<Titulo> formacionList) {
		this.formacionListProperty().set(formacionList);
	}
	
	
	
}
