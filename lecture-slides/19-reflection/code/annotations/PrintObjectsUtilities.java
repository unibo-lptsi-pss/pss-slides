import java.lang.reflect.Method;

public class PrintObjectsUtilities {

	public static String objectToString(Object o) {
		try {
			String out = "";
			for (Method m : o.getClass().getMethods()) {
				if (m.isAnnotationPresent(ToString.class) && m.getParameterTypes().length==0){
					ToString annotation = m.getAnnotation(ToString.class);
					if (annotation.showMethodName()){
						out += m.getName() + annotation.associationSymbol();
					}
					if (!annotation.showMethodName() && annotation.customName()!=null){
						out += annotation.customName() + annotation.associationSymbol();
					}
					out += m.invoke(o) + annotation.separator();
				}
			}
			return out;
		} catch (Exception e) {
			return null;
		}
	}
}
