import java.util.*;

public class Person {
    
    public static final int LOMBARDIA = 0;
    public static final int EMILIA_ROMAGNA = 1;
    public static final int SICILIA = 2;
    public static final int SARDEGNA = 3;
    ...
    
    private final String name;
    private final String surname;
    private final int region;
	
    public Person(String name, String surname, int region) {
    	this.name = name;
    	this.surname = surname;
    	this.region = region;
    }
	
    private static String regionName(int region){
        switch (region){
    	    case 0: return "Lombardia";
    	    case 1: return "Emilia-Romagna";
    	    ...
        }
    } 
