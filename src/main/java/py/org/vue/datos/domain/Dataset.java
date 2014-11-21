package py.org.vue.datos.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the datos_dataset database table.
 * 
 */
@Entity
@Table(name="datos_dataset")
@NamedQuery(name="Dataset.findAll", query="SELECT d FROM Dataset d")
public class Dataset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private String link;

	private String nombre;

	private String numero;

	private String servicio;
	
	//bi-directional many-to-one association to DatasetDic
	@OneToMany(mappedBy="datosDataset")
	private List<DatasetDic> datosDatasetDics;

	public Dataset() {
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

	public List<DatasetDic> getDatosDatasetDics() {
		return this.datosDatasetDics;
	}

	public void setDatosDatasetDics(List<DatasetDic> datosDatasetDics) {
		this.datosDatasetDics = datosDatasetDics;
	}

	public DatasetDic addDatosDatasetDic(DatasetDic datosDatasetDic) {
		getDatosDatasetDics().add(datosDatasetDic);
		datosDatasetDic.setDatosDataset(this);

		return datosDatasetDic;
	}

	public DatasetDic removeDatosDatasetDic(DatasetDic datosDatasetDic) {
		getDatosDatasetDics().remove(datosDatasetDic);
		datosDatasetDic.setDatosDataset(null);

		return datosDatasetDic;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

}