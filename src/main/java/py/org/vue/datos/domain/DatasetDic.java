package py.org.vue.datos.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the datos_dataset_dic database table.
 * 
 */
@Entity
@Table(name="datos_dataset_dic")
@NamedQuery(name="DatasetDic.findAll", query="SELECT d FROM DatasetDic d")
public class DatasetDic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Dataset
	@ManyToOne
	@JoinColumn(name="id_dataset")
	private Dataset datosDataset;

	//bi-directional many-to-one association to Diccionario
	@ManyToOne
	@JoinColumn(name="id_diccionario")
	private Diccionario datosDiccionario;

	public DatasetDic() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dataset getDatosDataset() {
		return this.datosDataset;
	}

	public void setDatosDataset(Dataset datosDataset) {
		this.datosDataset = datosDataset;
	}

	public Diccionario getDatosDiccionario() {
		return this.datosDiccionario;
	}

	public void setDatosDiccionario(Diccionario datosDiccionario) {
		this.datosDiccionario = datosDiccionario;
	}

}