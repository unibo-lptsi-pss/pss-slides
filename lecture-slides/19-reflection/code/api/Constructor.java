public final class Constructor<T> extends ... {

    public Class<T> getDeclaringClass() {...}
    public String getName() {...}
    public int getModifiers() {...}
    public Class<?>[] getParameterTypes() {...}
    public Class<?>[] getExceptionTypes() {...}

    public T newInstance(Object ... initargs)
        throws InstantiationException, IllegalAccessException,
               IllegalArgumentException, InvocationTargetException {...}

    public boolean isVarArgs() {...}
    ...
}
