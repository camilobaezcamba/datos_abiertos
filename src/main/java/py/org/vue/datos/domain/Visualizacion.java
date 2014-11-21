package py.org.vue.datos.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the datos_visualizacion database table.
 * 
 */
@Entity
@Table(name="datos_visualizacion")
@NamedQuery(name="Visualizacion.findAll", query="SELECT v FROM Visualizacion v")
public class Visualizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private String link;

	private String nombre;

	private String numero;

	@Column(name="vista_previa")
	private String vistaPrevia;

	public Visualizacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVistaPrevia() {
		return this.vistaPrevia;
	}

	public void setVistaPrevia(String vistaPrevia) {
		this.vistaPrevia = vistaPrevia;
	}

}