import java.util.*;

public class Persona {
    
    public static final int LOMBARDIA = 0;
    public static final int EMILIA_ROMAGNA = 1;
    public static final int SICILIA = 2;
    public static final int SARDEGNA = 3;
    ...
    
    private final String nome;
    private final String cognome;
    private final int regione;
	
    public Persona(String nome, String cognome, int regione) {
    	this.nome = nome;
    	this.cognome = cognome;
    	this.regione = regione;
    }
	
    private static String nomeRegione(int regione){
        switch (regione){
    	    case 0: return "Lombardia";
    	    case 1: return "Emilia-Romagna";
    	    ...
        }
    } 
