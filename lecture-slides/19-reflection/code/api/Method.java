public final class Method extends ... {

    public Class<?> getDeclaringClass() {...}
    public String getName() {...}
    public int getModifiers() {...}
    public Class<?> getReturnType() {...}
    public Class<?>[] getParameterTypes() {...}
    public Class<?>[] getExceptionTypes() {...}
    public boolean isVarArgs() {...}
        
    public Object invoke(Object obj, Object... args)
        throws IllegalAccessException, IllegalArgumentException,
           InvocationTargetException {...}
}
