public abstract class OutputStream implements Closeable, Flushable{
    /**
     * ..The byte to be written is the eight
     * low-order bits of the argument <code>b</code>. The 24
     * high-order bits of <code>b</code> are ignored.
     */
    public abstract void write(int b) throws IOException;

    public void write(byte b[]) throws IOException {...}

    public void write(byte b[], int off, int len) throws IOException {...}

    public void flush() throws IOException {...}
    
    public void close() throws IOException {...}
}
