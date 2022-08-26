public class Persona implements Comparable<Persona>{
    ...
    public int compareTo(Persona p){
    	return (this.annoNascita != p.annoNascita) 
    		  ? this.annoNascita - p.annoNascita 
    		  : this.nome.compareTo(p.nome);
    }
}