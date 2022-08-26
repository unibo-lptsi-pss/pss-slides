// Accetta qualunque Vector<T> con T <: Number
// Vector<Integer>, Vector<Double>, Vector<Float>,...
void m(Vector<? extends Number> arg){...}

// Accetta qualunque Vector<T>
void m(Vector<?> arg){...}

// Accetta qualunque Vector<T> con Integer <: T 
// Vector<Integer>, Vector<Number>, e Vector<Object> solo!
void m(Vector<? super Integer> arg){...}


