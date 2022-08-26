 public class File implements Serializable, Comparable<File> {

    public File(String pathname) {...}
    public File(String parent, String child) {...}
    public File(File parent, String child) {...}
    
    /* -- Path-component accessors -- */
    public String getName() {...}
    public String getParent() {...}
    public File getParentFile() {...}
    public String getPath() {...}

    /* -- Path operations -- */
    public boolean isAbsolute() {...}
    public String getAbsolutePath() {...}
    public File getAbsoluteFile() {...}
    public String getCanonicalPath() throws IOException {...}
    public File getCanonicalFile() throws IOException {...}
    
    /* -- Attribute accessors -- */
    public boolean canRead() {...}
    public boolean canWrite() {...}
    public boolean exists() {...}
    public boolean isDirectory() {...}
    public boolean isFile() {...}
    public boolean isHidden() {...}
    public long lastModified() {...}
    public long length() {...}

    /* -- File operations -- */

    public boolean createNewFile() throws IOException {...}
    public boolean delete() {...}
    public void deleteOnExit() {...}
    public String[] list() {...}
    public String[] list(FilenameFilter filter) {...}
    public boolean mkdir() {...}
    public boolean renameTo(File dest) {...}
    public boolean setLastModified(long time) {...}
    public boolean setReadOnly() {...}
    public boolean setWritable(boolean writable, boolean ownerOnly) {...}
    public boolean setWritable(boolean writable) {...}
    public boolean setReadable(boolean readable, boolean ownerOnly) {...}
    public boolean setReadable(boolean readable) {...}
    public boolean setExecutable(boolean executable, boolean ownerOnly) {...}
    public boolean setExecutable(boolean executable) {...}
    public boolean canExecute() {...}
    
    /* -- Disk usage -- */
    public long getTotalSpace() {...}
    public long getFreeSpace() {...}
    public long getUsableSpace() {...}
}
