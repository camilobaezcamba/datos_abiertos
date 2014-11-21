package py.org.vue.datos.business;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.ticpy.tekoporu.template.DelegateCrud;

import py.org.vue.datos.domain.Dataset;
import py.org.vue.datos.persistence.DatasetDAO;

public class DatasetBC extends DelegateCrud<Dataset, Integer, DatasetDAO> {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DatasetDAO datasetDAO;
	public List<Dataset> findPage(int pageSize, int first, String sortField, boolean sortOrderAsc, Map<String, String> filters){
		return datasetDAO.findPage(pageSize,first, sortField, sortOrderAsc,filters);
	}
	
	public int count() {
		return datasetDAO.count();
	}
	
	
}
