package enums4;
import static enums4.Zona.*;

public class RegioneEquiv {
	public static final ABRUZZO = new Regione(CENTRO,"Abruzzo",0);
	public static final BASILICATA = new Regione(SUD,"Basilicata",1);
	...
	public static final VENETO = new Regione(NORD,"Veneto",19);
	
	private static String[] strings = new String[]{
	    "ABRUZZO", "BASILICATA",...,"VENETO"
	};
	private static RegioneEquiv[] values = new RegioneEquiv[]{
	    ABRUZZO, BASILICATA,...,VENETO
	};
	
	private Zona z;
	private String name;
	private int ordinal;
	
	private Regione(Zona z, String actualName,int ordinal){
		... // usuale implementazione
	}
	...
	public static RegioneEquiv[] values(){ return values;}
	public int ordinal(){ return this.ordinal;} 
	public string name(){ return strings[ordinal];}
}
