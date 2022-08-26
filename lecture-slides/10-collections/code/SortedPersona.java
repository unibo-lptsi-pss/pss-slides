public class Persona implements Comparable<Persona>{
    ...
    // Esempio di implementazione di compareTo:
    // - ordine di anno di nascita, e poi per nome..
    public int compareTo(Persona p){
    	return (this.annoNascita != p.annoNascita) 
    		  ? this.annoNascita - p.annoNascita 
    		  : this.nome.compareTo(p.nome);
    }
}