public final class Class<T> implements ...  {
    
    public static Class<?> forName(String className) throws ClassNotFoundException {...}
    
    public boolean isInterface();
    public boolean isArray();
    public boolean isPrimitive();
    public boolean isAnonymousClass() {...}
    public boolean isLocalClass() {...}
    public boolean isMemberClass() {...}
    public boolean isEnum() {...}
    
    public T[] getEnumConstants() {...}
    public Class<?> getComponentType();
    public T cast(Object obj) {...}
    
    public T newInstance() throws ...{...}
        
    // Accessing the structure.. can throw SecurityException
    public Field[] getFields() throws ... {...}
    public Method[] getMethods() throws ... {...}
    public Constructor<?>[] getConstructors() throws ... {...}

    public Field getField(String name) throws NoSuchFieldException, .. {...}
    public Method getMethod(String name, Class<?>... parameterTypes)
        throws NoSuchMethodException, .. {...}
    public Constructor<T> getConstructor(Class<?>... parameterTypes)
        throws NoSuchMethodException, .. {...}

    public Field[] getDeclaredFields() throws SecurityException {...}
    ... // All versions with 'Declared'
}
