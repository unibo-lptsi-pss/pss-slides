public interface DataInput {
     void readFully(byte b[]) throws IOException {..}
     boolean readBoolean() throws IOException {..}
     byte readByte() throws IOException {..}
     int readUnsignedByte() throws IOException {..}
     short readShort() throws IOException {..}
     int readUnsignedShort() throws IOException {..}
     char readChar() throws IOException {..}
     int readInt() throws IOException {..}
     long readLong() throws IOException {..}
     float readFloat() throws IOException {..}
     double readDouble() throws IOException {..}
     String readUTF() throws IOException {..} // non-standard UTF-8
     ...
}

public class FilterInputStream extends InputStream{...}

public class DataInputStream 
        extends FilterInputStream implements DataInput{
    ...
    public DataInputStream(InputStream in){...}
    ...
}
