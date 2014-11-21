package py.org.vue.datos.business;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.ticpy.tekoporu.template.DelegateCrud;

import py.org.vue.datos.domain.Visualizacion;
import py.org.vue.datos.persistence.VisualizacionDAO;

public class VisualizacionBC extends DelegateCrud<Visualizacion, Integer, VisualizacionDAO> {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private VisualizacionDAO visualizacionDAO;
	public List<Visualizacion> findPage(int pageSize, int first, String sortField, boolean sortOrderAsc, Map<String, String> filters){
		return visualizacionDAO.findPage(pageSize,first, sortField, sortOrderAsc,filters);
	}
	
	public int count() {
		return visualizacionDAO.count();
	}
	
	
}
