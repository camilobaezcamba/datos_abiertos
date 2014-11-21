/*
 * TICPY Framework
 * Copyright (C) 2012 Plan Director TICs
 *
----------------------------------------------------------------------------
 * Originally developed by SERPRO
 * Demoiselle Framework
 * Copyright (C) 2010 SERPRO
 *
----------------------------------------------------------------------------
 * This file is part of TICPY Framework.
 *
 * TICPY Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 *
----------------------------------------------------------------------------
 * Este archivo es parte del Framework TICPY.
 *
 * El TICPY Framework es software libre; Usted puede redistribuirlo y/o
 * modificarlo bajo los términos de la GNU Lesser General Public Licence versión 3
 * de la Free Software Foundation.
 *
 * Este programa es distribuido con la esperanza que sea de utilidad,
 * pero sin NINGUNA GARANTÍA; sin una garantía implícita de ADECUACION a cualquier
 * MERCADO o APLICACION EN PARTICULAR. vea la GNU General Public Licence
 * más detalles.
 *
 * Usted deberá haber recibido una copia de la GNU Lesser General Public Licence versión 3
 * "LICENCA.txt", junto con este programa; en caso que no, acceda a <http://www.gnu.org/licenses/>
 * o escriba a la Free Software Foundation (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */

package py.org.vue.datos.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.json.JSONArray;
import org.json.JSONObject;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;

import py.org.vue.datos.domain.Dataset;
import py.org.vue.datos.util.UserFunctions;

@ViewController
@NextView("/diccionario_list.xhtml")
@PreviousView("/tabla_list.xhtml")
public class RankingExportacionesListMB extends AbstractListPageBean<Dataset, Integer> {

	private static final long serialVersionUID = 1L;

	private UserFunctions funciones = new UserFunctions();

	private List<HashMap<String, Object>> listaImportacionesPorAnho = new ArrayList<HashMap<String, Object>>();

	private String anhomes;
	
	private StreamedContent file;
	private String archivo = "";
	private String extension = "";
	private String tipoJson = "application/json"; // ""
	private String tipoCsv = "application/csv"; // ""
	private String nombre = "rankingExportaciones"; // "application/json"
	private List<HashMap<String, Object>> filtrados;

	private JSONArray jsonArray;

	private List<String> claves;
	
	private String anho = "2006";
	private String mes = "10";
	
	private static String OS = System.getProperty("os.name").toLowerCase();

	private Charset codificacion = Charset.forName("UTF-8");
	
	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}
	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}
	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS
				.indexOf("aix") > 0);
	}
	public static boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}
	
	@Override
	protected List<Dataset> handleResultList() {
		// TODO Auto-generated method stub
		return null;
	}

	@PostConstruct
	public void inicializar(){
		init();
	}
	
	public void init() {
		
		if (isWindows()) {
			codificacion = Charset.forName("ISO_8859_1");
		}
		
		claves = new ArrayList<String>();
		claves.add("anho_mes");
		claves.add("ruc");
		claves.add("razon_social");
		claves.add("valor_fob_dolar");
		claves.add("kilo_neto");
		
		JSONObject json = funciones.getRankingExportaciones(anho+mes);
		HashMap<String, Object> temp = new HashMap<String, Object>();
		this.listaImportacionesPorAnho = new ArrayList<HashMap<String, Object>>();

		if (json != null) {
			jsonArray = json.getJSONArray("objeto");
			JSONObject ob;
			if (jsonArray != null)
				for (int i = 0; i < jsonArray.length(); i++) {
					ob = jsonArray.getJSONObject(i);
					temp = new HashMap<String, Object>();
					for(String clave: claves){
						//temp.put(clave, ob.get(clave));
						Object valor = ob.get(clave);
						if(valor instanceof String)
							temp.put(clave, valor);
						else
							try {
								String aux = valor.toString().indexOf(".")==-1?valor.toString()+".00":valor.toString();
								temp.put(clave, new BigDecimal(aux));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
					}
					
					this.listaImportacionesPorAnho.add(temp);
				}

		}
	}

	public StreamedContent getJson() {
		this.extension = ".txt";
		aplicarFiltros();
		this.archivo = listToJson(filtrados);
		InputStream stream = new ByteArrayInputStream(
				this.archivo.getBytes(codificacion));
		file = new DefaultStreamedContent(stream, tipoJson, nombre + extension);
		return file;
	}

	public StreamedContent getCsv() {
		this.extension = ".csv";
		aplicarFiltros();
		this.archivo = listToCsv(filtrados);
		InputStream stream = new ByteArrayInputStream(
				this.archivo.getBytes(codificacion));
		file = new DefaultStreamedContent(stream, tipoCsv, nombre + extension);
		return file;
	}

	public String listToJson(List<HashMap<String, Object>> filtrados) {
		JSONObject json;
		JSONArray jsonLista = new JSONArray();
		for (HashMap<String, Object> objeto : filtrados) {
			json = new JSONObject();
			for (Iterator<String> it = objeto.keySet().iterator(); it.hasNext();) {
				String clave = it.next();
				Object valor = objeto.get(clave);
				if(valor instanceof Double){
					json.put(clave, new BigDecimal(valor.toString()));
				}else
					json.put(clave, valor);
			}
			jsonLista.put(json);
		}

		return jsonLista.toString();
	}

	public String listToCsv(List<HashMap<String, Object>> filtrados) {
		String csv = "";
		
		for (String clave: claves) {
			csv += clave + ",";
		}
		
		csv = csv.substring(0, csv.length()-1);
		csv += "\r\n";
		
		String fila = "";
		for(HashMap<String, Object> objeto: filtrados){
			fila = "";
			for (String clave: claves) {
				Object valor = objeto.get(clave);
				if(valor instanceof Double){
					fila += "\"" + new BigDecimal(valor.toString()) + "\",";
				}else
					fila += "\"" + valor + "\",";
			}
			fila = fila.substring(0, fila.length() -1);
			csv += fila + "\r\n";
		}
		return csv;
	}

	public void aplicarFiltros() {
		DataTable table = (DataTable) FacesContext.getCurrentInstance()
				.getViewRoot().findComponent("form:list");
		filtrados = new ArrayList<HashMap<String, Object>>();

		Map<String, String> filters = table.getFilters();

		if (filters != null) {
			for (HashMap<String, Object> objeto : this.listaImportacionesPorAnho) {
				boolean match = true;

				if (filters != null) {
					for (Iterator<String> it = filters.keySet().iterator(); it
							.hasNext();) {
						try {
							String filterProperty = it.next();
							String filterValue = (String)filters.get(filterProperty);
							String fieldValue = String.valueOf(objeto.get(filterProperty.substring(5, filterProperty.length() - 2)));

							if (filterValue == null
									|| fieldValue.toLowerCase().contains(
											filterValue.toString()
													.toLowerCase())) {
								match = true;
							} else {
								match = false;
								break;
							}
						} catch (Exception e) {
							match = false;
						}
					}
				}

				if (match) {
					filtrados.add(objeto);
				}
			}
		}

	}

	public List<HashMap<String, Object>> getListaImportacionesPorAnho() {

		return listaImportacionesPorAnho;
	}

	public void setListaImportacionesPorAnho(
			List<HashMap<String, Object>> listaImportacionesPorAnho) {
		this.listaImportacionesPorAnho = listaImportacionesPorAnho;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public String getAnhomes() {
		return anhomes;
	}

	public void setAnhomes(String anhomes) {
		this.anhomes = anhomes;
	}

	public String getAnho() {
		return anho;
	}

	public void setAnho(String anho) {
		this.anho = anho;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
}
