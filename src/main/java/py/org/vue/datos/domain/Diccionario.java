package py.org.vue.datos.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the datos_diccionario database table.
 * 
 */
@Entity
@Table(name="datos_diccionario")
@NamedQuery(name="Diccionario.findAll", query="SELECT d FROM Diccionario d")
public class Diccionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String atributo;

	private String descripcion;

	private String ejemplo;

	private String referencia;

	private String restricciones;

	@Column(name="tipo_dato")
	private String tipoDato;

	//bi-directional many-to-one association to DatasetDic
	@OneToMany(mappedBy="datosDiccionario")
	private List<DatasetDic> datosDatasetDics;

	public Diccionario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAtributo() {
		return this.atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEjemplo() {
		return this.ejemplo;
	}

	public void setEjemplo(String ejemplo) {
		this.ejemplo = ejemplo;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getRestricciones() {
		return this.restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}

	public String getTipoDato() {
		return this.tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public List<DatasetDic> getDatosDatasetDics() {
		return this.datosDatasetDics;
	}

	public void setDatosDatasetDics(List<DatasetDic> datosDatasetDics) {
		this.datosDatasetDics = datosDatasetDics;
	}

	public DatasetDic addDatosDatasetDic(DatasetDic datosDatasetDic) {
		getDatosDatasetDics().add(datosDatasetDic);
		datosDatasetDic.setDatosDiccionario(this);

		return datosDatasetDic;
	}

	public DatasetDic removeDatosDatasetDic(DatasetDic datosDatasetDic) {
		getDatosDatasetDics().remove(datosDatasetDic);
		datosDatasetDic.setDatosDiccionario(null);

		return datosDatasetDic;
	}

}