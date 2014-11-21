function formatoMiles(name)
        {
            var nums = new Array();
            var decimal = new Array();
            var simb = "."; //Éste es el separador
            var valor = name.toString();
            decimal = valor.split(".");
            if(decimal.length!=1){
            	valor=decimal[0];
            }
            valor = valor.replace(/\D/g, "");   //Ésta expresión regular solo permitira ingresar números
            nums = valor.split(""); //Se vacia el valor en un arreglo
            var longi = nums.length - 1; // Se saca la longitud del arreglo
            var patron = 3; //Indica cada cuanto se ponen las comas
            var prox = 2; // Indica en que lugar se debe insertar la siguiente coma
            var res = "";
 
            while (longi > prox) {
                nums.splice((longi - prox),0,simb); //Se agrega la coma
                prox += patron; //Se incrementa la posición próxima para colocar la coma
            }
 
            for (var i = 0; i <= nums.length-1; i++) {
                res += nums[i]; //Se crea la nueva cadena para devolver el valor formateado
            }
            if(decimal.length!=1){
            	res=res+','+decimal[1];
            }
            return res;
        }

function JSONToCSVConvertor(JSONData, nombreArchivo) {
	// If JSONData is not an object then JSON.parse will parse the JSON string
	// in an Object
	var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;

	var CSV = '';

	var row = "";

	// This loop will extract the label from 1st index of on array
	for ( var index in arrData[0]) {

		// Now convert each value to string and comma-seprated
		row += index + ',';
	}

	row = row.slice(0, -1);

	// append Label row with line break
	CSV += row + '\r\n';

	// 1st loop is to extract each row
	for (var i = 0; i < arrData.length; i++) {
		var row = "";

		// 2nd loop will extract each column and convert it in string
		// comma-seprated
		for ( var index in arrData[i]) {
			row += '"' + arrData[i][index] + '",';
		}

		row.slice(0, row.length - 1);

		// add a line break after each row
		CSV += row + '\r\n';
	}

	if (CSV == '') {
		alert("Invalid data");
		return;
	}

	// Generate a file name
	var fileName = nombreArchivo;

	// Initialize file format you want csv or xls
	var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);

	// Now the little tricky part.
	// you can use either>> window.open(uri);
	// but this will not work in some browsers
	// or you will not get the correct file extension

	// this trick will generate a temp <a /> tag
	var link = document.createElement("a");
	link.href = uri;

	// set the visibility hidden so it will not effect on your web-layout
	link.style = "visibility:hidden";
	link.download = fileName + ".csv";

	// this part will append the anchor tag and remove it after automatic click
	document.body.appendChild(link);
	link.click();
	document.body.removeChild(link);
}
function JSONToCSVConvertorMapa(JSONData, nombreArchivo) {
	// If JSONData is not an object then JSON.parse will parse the JSON string
	// in an Object
	var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;

	var CSV = '';

	var row = "";

	// This loop will extract the label from 1st index of on array
	for ( var index in arrData[0]) {
		
		// Now convert each value to string and comma-seprated
		row += index + ',';
	}
	
	row = 'Comprador, Pais Destino, Importador, Pais Origen, Exportador, Valor FOB,';
	row = row.slice(0, -1);
	var cabecera = ["comprador", "pais_destino", "importador", "pais_origen", "exportador", "valor_fob_dolar"];
	// append Label row with line break
	CSV += row + '\r\n';

	// 1st loop is to extract each row
	for (var i = 0; i < arrData.length; i++) {
		var row = "";

		// 2nd loop will extract each column and convert it in string
		// comma-seprated
		for (var aux = 0; aux < 6; aux++){
			var temp = arrData[i][cabecera[aux]]+'';
			if(temp==""){
				temp="KO";
			}else{
				temp = temp.replace(/"/g, "");
			}
			row += '"' + temp + '",';
		}
		/*
		for ( var index in arrData[i]) {
			row += '"' + arrData[i][index] + '",';
		}
*/
		row.slice(0, row.length - 1);

		// add a line break after each row
		CSV += row + '\r\n';
	}

	if (CSV == '') {
		alert("Invalid data");
		return;
	}

	// Generate a file name
	var fileName = nombreArchivo;

	// Initialize file format you want csv or xls
	/*var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);

	// Now the little tricky part.
	// you can use either>> window.open(uri);
	// but this will not work in some browsers
	// or you will not get the correct file extension

	// this trick will generate a temp <a /> tag
	var link = document.createElement("a");
	link.href = uri;

	// set the visibility hidden so it will not effect on your web-layout
	link.style = "visibility:hidden";
	link.download = fileName + ".csv";

	// this part will append the anchor tag and remove it after automatic click
	document.body.appendChild(link);
	link.click();
	document.body.removeChild(link);*/
	return CSV;
}