package annotations;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.Element;
import javax.lang.model.SourceVersion;
import javax.tools.Diagnostic.Kind;
import com.sun.tools.javac.code.TypeTags;
import com.sun.tools.javac.code.Symbol.MethodSymbol;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("it.unibo.apice.oop.p13annotations.ToString")
public class ToStringChecker extends AbstractProcessor {

    @Override
	public boolean process(Set<? extends TypeElement> annotations, 
	                       RoundEnvironment roundEnv) {
	    boolean out = true;
	    for (Element e : roundEnv.getElementsAnnotatedWith(ToString.class)){
		    if (!(e instanceof MethodSymbol) || 
				   !((MethodSymbol)e).params.isEmpty() ||
				   ((MethodSymbol)e).getReturnType().tag==TypeTags.VOID){
			    out = false;
			    String msg = "@ToString cannot be applied to "+e+": ";
			    msg + = "it must be a getter method";
				processingEnv.getMessager().printMessage(Kind.ERROR,msg);
			}
		}
		return out;
	}

}
// Dettagli compilazione da linea di comando:
// javac -classpath .:/usr/lib/jvm/java-7-openjdk-amd64/lib/tools.jar\  
// -processorpath ../bin\ 
// -processor it.unibo.apice.oop.p13annotations.ToStringChecker\ 
// it/unibo/apice/oop/p13annotations/*.java
// error: @ToString cannot be applied to m(): it must be a getter method
// 1 error
