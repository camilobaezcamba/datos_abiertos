package py.org.vue.datos.business;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.ticpy.tekoporu.template.DelegateCrud;

import py.org.vue.datos.domain.DatasetDic;
import py.org.vue.datos.persistence.DatasetDicDAO;

public class DatasetDicBC extends DelegateCrud<DatasetDic, Integer, DatasetDicDAO> {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DatasetDicDAO datasetDicDAO;
	public List<DatasetDic> findPage(int pageSize, int first, String sortField, boolean sortOrderAsc, Map<String, String> filters){
		return datasetDicDAO.findPage(pageSize,first, sortField, sortOrderAsc,filters);
	}
	
	public int count() {
		return datasetDicDAO.count();
	}
	
	public List<DatasetDic> find() {
		return datasetDicDAO.find();
	}
	
	
}
