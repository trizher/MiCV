package dad.javafx.micv.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import dad.javafx.adapter.LocalDateAdapter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Experiencia {
	private ObjectProperty<LocalDate> desde = new SimpleObjectProperty<>();
	private ObjectProperty<LocalDate> hasta = new SimpleObjectProperty<>();
	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty empleador = new SimpleStringProperty();
	
	public ObjectProperty<LocalDate> desdeProperty() {
		return this.desde;
	}
	
	@XmlAttribute
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDesde() {
		return this.desdeProperty().get();
	}
	
	public void setDesde(final LocalDate desde) {
		this.desdeProperty().set(desde);
	}
	
	public ObjectProperty<LocalDate> hastaProperty() {
		return this.hasta;
	}

	@XmlAttribute
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getHasta() {
		return this.hastaProperty().get();
	}
	
	public void setHasta(final LocalDate hasta) {
		this.hastaProperty().set(hasta);
	}
	
	public StringProperty denominacionProperty() {
		return this.denominacion;
	}
	
	@XmlElement
	public String getDenominacion() {
		return this.denominacionProperty().get();
	}
	
	public void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	
	public StringProperty empleadorProperty() {
		return this.empleador;
	}
	
	@XmlElement
	public String getEmpleador() {
		return this.empleadorProperty().get();
	}
	
	public void setEmpleador(final String empleador) {
		this.empleadorProperty().set(empleador);
	}
	
	
}
