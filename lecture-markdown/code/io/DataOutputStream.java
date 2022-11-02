public class DataOutputStream extends OutputStream ... {
     void writeBoolean(boolean v) throws IOException {..}
     void writeByte(int v) throws IOException {..}
     void writeShort(int v) throws IOException {..}
     void writeChar(int v) throws IOException {..}
     void writeInt(int v) throws IOException {..}
     void writeLong(long v) throws IOException {..}
     void writeFloat(float v) throws IOException {..}
     void writeDouble(double v) throws IOException {..}
     void writeBytes(String s) throws IOException {..}
     void writeChars(String s) throws IOException {..}
     void writeUTF(String str) throws IOException {..} // non-standard UTF-8
}

public class FilterOutputStream extends OutputStream {...}

public class DataOutputStream 
        extends FilterOutputStream implements DataOutput {
    ...
    public DataOutputStream(OutputStream out) {..}
    ...
}
