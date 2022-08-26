public abstract class InputStream implements Closeable {

    // Reads the next byte (0 to 255, -1 is end-of-stream)
    public abstract int read() throws IOException;

    public int read(byte b[]) throws IOException {...}
    
    public int read(byte b[], int off, int len) throws IOException {...}
    
    public long skip(long n) throws IOException {...}
    
    public int available() throws IOException {...}
    
    public void close() throws IOException {...}
    
    public synchronized void mark(int readlimit) {...}
    
    public synchronized void reset() throws IOException {...}
    
    public boolean markSupported() {...}
}
