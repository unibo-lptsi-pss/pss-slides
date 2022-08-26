import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented						// genera documentazione javadoc
@Target(ElementType.METHOD)		// usabile solo nei metodi
@Retention(RetentionPolicy.RUNTIME)		// visibile a run-time
public @interface ToString { // elenco proprietà/metodi
    
    // Vogliamo mostrare il nome del metodo?
	boolean showMethodName() default true;	
	
	// Oppure, mostriamo un nome custom
	String customName() default "";
	
	// Simbolo per associare nome a valore
	String associationSymbol() default "->";
	
	// Simbolo separatore
	String separator() default "|";
}
