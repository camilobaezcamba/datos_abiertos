package py.org.vue.datos.util;
 
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;
 
public class UserFunctions {
     
    private JSONParser jsonParser;
     
    // Testing in localhost using wamp or xampp
    // use http://10.0.2.2/ to connect to your localhost ie http://localhost/
    private static String url = "http://localhost:8080/opendata-ws-restful/";
    private static String importaciones_por_anho = "importacionesPorAnho/";
    private static String exportaciones_por_anho = "exportacionesPorAnho/paginado/";
    private static String total_exportaciones_por_anho = "exportacionesPorAnho/paginado/total";
    private static String ranking_importaciones = "ranking/importacion";
    private static String ranking_exportaciones = "ranking/exportacion";
    private static String ranking_productos_importados = "ranking/producto/importados";
    private static String exportaciones_categoria = "exportacionesPorCategoria";
    private static String exportaciones_pais = "exportacionesPorPais";
 
    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }
     
    /**
     * function make Login Request
     * @param email
     * @param password
     * */
     
    
    public JSONObject getImportacionesPorAnho(String anho){
        JSONObject json = jsonParser.getJSONFromUrl(url+importaciones_por_anho+(anho.equals("%")? "": anho));
        return json;
    }
    

	public JSONObject getExportacionesPorAnhoPaginado(String anho, int first, int pageSize,
			String sortField, String order, Map<String, String> filters) {
		String params = "?";
		params += "anho="+anho;
		params += "&first="+first;
		params += "&pageSize="+pageSize;
		params += "&sortField="+sortField;
		params += "&order="+order;
		params += "&filters=";
		if (filters != null && filters.size() > 0) {
			for (Iterator<String> it = filters.keySet().iterator(); it
					.hasNext();) {
				String filterProperty = it.next();
				String filterValue = (String) filters.get(filterProperty);
				filterProperty = filterProperty.substring(5,
						filterProperty.length() - 2);
				params += filterProperty + "--" + filterValue + "xx" ;
			}
			params = params.substring(0, params.length()-2);
		}else{
			params += "a";
		}
		
        JSONObject json = jsonParser.getJSONFromUrl(url+exportaciones_por_anho+params);
        return json;
	}
	public JSONObject getTotalExportacionesPorAnho(String anho) {
        JSONObject json = jsonParser.getJSONFromUrl(url+total_exportaciones_por_anho+"/"+anho);
        return json;
	}
	
	public JSONObject getRankingImportaciones(String anhomes) {
        JSONObject json = jsonParser.getJSONFromUrl(url+ranking_importaciones+ "/"+ anhomes);
        return json;
	}
	
	public JSONObject getRankingExportaciones(String anhomes) {
        JSONObject json = jsonParser.getJSONFromUrl(url+ranking_exportaciones+ "/"+ anhomes);
        return json;
	}
	
	public JSONObject getRankingProductosImportados(String anhomes) {
        JSONObject json = jsonParser.getJSONFromUrl(url+ranking_productos_importados+ "/"+ anhomes);
        return json;
	}
	
	public JSONObject getExportacionesPorPais(String anhomesDesde, String anhomesHasta) {
        JSONObject json = jsonParser.getJSONFromUrl(url+exportaciones_pais+ "/"+ anhomesDesde +"-" + anhomesHasta);
        return json;
	}
	
	public JSONObject getExportacionesPorCategoria(String anhomes) {
        JSONObject json = jsonParser.getJSONFromUrl(url+exportaciones_categoria+ "/"+ anhomes);
        return json;
	}
	
}