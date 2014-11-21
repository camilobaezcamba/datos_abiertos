package py.org.vue.datos.business;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.ticpy.tekoporu.template.DelegateCrud;

import py.org.vue.datos.domain.Diccionario;
import py.org.vue.datos.persistence.DiccionarioDAO;

public class DiccionarioBC extends DelegateCrud<Diccionario, Integer, DiccionarioDAO> {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DiccionarioDAO diccionarioDAO;
	public List<Diccionario> findPage(int pageSize, int first, String sortField, boolean sortOrderAsc, Map<String, String> filters){
		return diccionarioDAO.findPage(pageSize,first, sortField, sortOrderAsc,filters);
	}
	
	public int count() {
		return diccionarioDAO.count();
	}
	
	
}
