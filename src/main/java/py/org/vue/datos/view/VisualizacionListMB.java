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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;

import py.org.vue.datos.business.VisualizacionBC;
import py.org.vue.datos.domain.Visualizacion;

@ViewController
@PreviousView("./index.xhtml")
public class VisualizacionListMB {

	@Inject
	private VisualizacionBC bc;

	List<Visualizacion> lista = new ArrayList<Visualizacion>();
	List<Visualizacion> lista2 = new ArrayList<Visualizacion>();

	public List<Visualizacion> getLista2() {
		return lista2;
	}

	public void setLista2(List<Visualizacion> lista2) {
		this.lista2 = lista2;
	}

	public List<Visualizacion> getLista() {
		return this.lista;
	}

	public void setLista(List<Visualizacion> lista) {
		this.lista = lista;
	}

	public String getLink(String link){
		link=link.substring(0,link.length()-4);
		return "/"+link + ".xhtml";
	}
	@PostConstruct
	public void init(){
		List<Visualizacion> lista = bc.findAll();
		for(int i=0; i < 3 ; i++){
			this.lista.add(lista.get(i));
		}
		for(int i=3; i < 5 ; i++){
			this.lista2.add(lista.get(i));
		}
		
	}
}
