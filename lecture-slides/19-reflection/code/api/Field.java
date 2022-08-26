public final class Field extends ... {

    public Class<?> getDeclaringClass() {...}
    public String getName() {...}
    public int getModifiers() {...}
    public boolean isEnumConstant() {...}
    public Class<?> getType() {...}

    public Object get(Object obj)
        throws IllegalArgumentException, IllegalAccessException{...}
    public boolean getBoolean(Object obj)
        throws IllegalArgumentException, IllegalAccessException{...}
    public byte getByte(Object obj)
        throws IllegalArgumentException, IllegalAccessException{...}
    ...
    
    public void set(Object obj, Object value)
        throws IllegalArgumentException, IllegalAccessException{...}
    ...
}
