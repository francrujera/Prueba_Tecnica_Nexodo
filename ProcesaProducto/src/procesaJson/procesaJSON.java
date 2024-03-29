package procesaJson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class procesaJSON {

	//Atributos que usara el JTABLE
	public static String[] column = null;
	public static Object[][] data = new Object[10][10];
	

	public static void recorreJSON(String ruta){
		
		JSONParser parser = new JSONParser();
		
		
		try {
			
			//Object obj = parser.parse(new FileReader("C:\\Users\\fjcrujera\\Downloads\\Prueba t�cnica Nexodo Digital\\products.json"));			
			//Object obj = parser.parse(new FileReader("C:\\Users\\fjcrujera\\Downloads\\Prueba t�cnica Nexodo Digital\\otro.json"));
			Object obj = parser.parse(new FileReader(ruta));
					
			if(obj.getClass().getName().equals("org.json.simple.JSONArray")){

			//Si el tipo de JSON es un ARRAY
			JSONArray jsonArray = (JSONArray) obj;
			
			int nCol = 0;			
			
			//Iteramos sobre el array del JSON [{Elem1}{Elem2}{Elem3}]
			for(int i = 0; i<jsonArray.size();i++) {
				
				//Obtenemos el elemento i del array del JSON
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				
				int key = 0;				
			
				if(i==0){
				//Configuramos el tama�o del Array que contendran las columnas	
				column = new String[jsonObject.size()];
				}
				
				//Recorremos el elemento i del JSON y obtenemos sus atributos y valores
				for(Object o:jsonObject.entrySet()){
									
				//Obtenemos las columnas
				String col = o.toString().split("=")[0]; 
				
				
				//A�adimos las columnas para mostrarlo en la tabla (solo en la primera iteracion para que no se repita)
				if(i==0){		
				column[nCol]=col;
				nCol++;				
				}	
				
				//Obtenemos el valor
				String val = o.toString().split("=")[1];
				
				//Lo a�adimos a los datos que va a utilizar la tabla
				data[i][key]=val;
				key++;
				}				
				
			}

			//Excepcionalmente: Si el tipo de JSON no es un ARRAY lo recorremos sin llamar a JSONARRAY
			}else{
				JSONObject jsonObject = (JSONObject) obj;
				for(Object o:jsonObject.entrySet()){
					System.out.println(o);
				}
			}
				
		}catch (ClassCastException e){
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
	

