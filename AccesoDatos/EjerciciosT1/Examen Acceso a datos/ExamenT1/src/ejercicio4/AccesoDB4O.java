package ejercicio4;

import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class AccesoDB4O {
	
	static final String BDContactos = "DB4O/contactos.yap";
	private ObjectContainer db;
	
	public AccesoDB4O() {
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDContactos);
	}
	
	public void insertarDatos(Contacto con) {
		
		db.store(con);
		
	}
	
	private ArrayList<Contacto> consultarDatos2(String grupo) {
		
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		Contacto cDefault = new Contacto();
		cDefault.setGrupo(grupo);
		
		ObjectSet<Contacto> result = db.queryByExample(cDefault);
		
		if (result.size() == 0) {
			System.out.println("No existen registro con grupo" + grupo);
		} else {
			System.out.println("Número de registros de Contacto: " + result.size());
			while (result.hasNext()) {
				cDefault = result.next();
				lista.add(cDefault);
				
				
			}
		}
		
		return lista;
		
	}
	
	private static void modificarDatos(String grupoOld, String grupoNew) {
		
		Contacto cDefault = new Contacto();
		cDefault.setGrupo(grupoOld);
		
		ObjectSet<Contacto> result = db.queryByExample(cDefault);
		
		if (result.size() == 0) {
			System.out.println("No existen registro de contactos del grupo " + grupoOld);
		} else {
			System.out.println("Número de registros de Contactos: " + result.size());
			cDefault = result.next();
				
			cDefault.setGrupo(grupoNew);
			db.store(cDefault);
			
			result = db.queryByExample(new Contacto(null,null,null,null, grupoNew));
			while (result.hasNext()) {
				cDefault = result.next();
			}

		}
		
	}

}
