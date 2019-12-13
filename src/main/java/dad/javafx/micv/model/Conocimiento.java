package dad.javafx.micv.model;

import javax.xml.bind.annotation.XmlAttribute;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conocimiento {

	private StringProperty denominacion = new SimpleStringProperty();
	private ObjectProperty<Nivel> nivel = new SimpleObjectProperty<Nivel>();

	public Conocimiento() {
	}
	
	public Conocimiento(StringProperty denominacion, ObjectProperty<Nivel> nivel) {
		this.denominacion = denominacion;
		this.nivel = nivel;
	}

	public StringProperty denominacionProperty() {
		return this.denominacion;
	}

	@XmlAttribute
	public String getDenominacion() {
		return this.denominacionProperty().get();
	}

	public void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}

	public ObjectProperty<Nivel> nivelProperty() {
		return this.nivel;
	}

	@XmlAttribute
	public Nivel getNivel() {
		return this.nivelProperty().get();
	}

	public void setNivel(final Nivel nivel) {
		this.nivelProperty().set(nivel);
	}

}
