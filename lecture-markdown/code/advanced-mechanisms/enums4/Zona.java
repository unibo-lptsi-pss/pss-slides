package enums4;
import java.util.*;

public enum Zona {
	NORD, CENTRO, SUD;
	
	List<Regione> getRegioni(){
		ArrayList<Regione> list=new ArrayList<>();
		for (Regione r: Regione.values()){
			if (r.getZona()==this){
				list.add(r);
			}
		}
		return list;
	}
}
