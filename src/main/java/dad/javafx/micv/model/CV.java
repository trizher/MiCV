package dad.javafx.micv.model;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlRootElement
@XmlType
public class CV {
	
	private ObjectProperty<Personal> personal = new SimpleObjectProperty<Personal>();
	private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<Contacto>();
	private ListProperty<Conocimiento> habilidadesList = new SimpleListProperty<Conocimiento>(FXCollections.observableArrayList());
	private ListProperty<Experiencia> experienciasList = new SimpleListProperty<Experiencia>(FXCollections.observableArrayList());
	private ListProperty<Titulo> formacionList = new SimpleListProperty<Titulo>(FXCollections.observableArrayList());
	
	
	public ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}
	
	@XmlElement
	public Personal getPersonal() {
		return this.personalProperty().get();
	}
	
	public void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}
	
	public ObjectProperty<Contacto> contactoProperty() {
		return this.contacto;
	}
	
	@XmlElement
	public Contacto getContacto() {
		return this.contactoProperty().get();
	}
	
	public void setContacto(final Contacto contacto) {
		this.contactoProperty().set(contacto);
	}
	
	public ListProperty<Conocimiento> habilidadesListProperty() {
		return this.habilidadesList;
	}
	
	@XmlElement(name = "habilidades")
	public ObservableList<Conocimiento> getHabilidadesList() {
		return this.habilidadesListProperty().get();
	}
	
	public void setHabilidadesList(final ObservableList<Conocimiento> habilidadesList) {
		this.habilidadesListProperty().set(habilidadesList);
	}
	
	public ListProperty<Experiencia> experienciasListProperty() {
		return this.experienciasList;
	}
	
	@XmlElement(name = "experiencias")
	public ObservableList<Experiencia> getExperienciasList() {
		return this.experienciasListProperty().get();
	}
	
	public void setExperienciasList(final ObservableList<Experiencia> experienciasList) {
		this.experienciasListProperty().set(experienciasList);
	}
	
	public ListProperty<Titulo> formacionListProperty() {
		return this.formacionList;
	}
	
	@XmlElement(name = "formacion")
	public ObservableList<Titulo> getFormacionList() {
		return this.formacionListProperty().get();
	}
	
	public void setFormacionList(final ObservableList<Titulo> formacionList) {
		this.formacionListProperty().set(formacionList);
	}
	
	public void save(File file) throws Exception {
		JAXBContext context = JAXBContext.newInstance(CV.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(this, file);
	}

	public static CV load(File file) throws Exception {
		JAXBContext context = JAXBContext.newInstance(CV.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (CV) unmarshaller.unmarshal(file);
	}	
	
}
