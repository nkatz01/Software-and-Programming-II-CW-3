/**
 * Abstract superclass for entries in a file system.
 *
 * @author Roman Kontchakov
 * @author Carsten Fuhs
 * @author Nuchem Katz
 */
public abstract class AbstractEntry implements Entry {

    /** The file system in which this entry is stored. */
    private FileSystem fileSystem;

    /** The name of this entry; non-null. */
    private String name;

    /**
     * The name of the folder in which this entry resides (the "parent folder");
     * null means root entry.
     */
    private Folder folder;

    /**
     * Constructs a new entry with folder as parent folder and name as name.
     * 
     * @param folder the parent folder of this entry; must not be null
     * @param name   the name of this entry; must not be null
     */
    public AbstractEntry(Folder folder, String name) {
        if (name == null)
            throw new IllegalArgumentException("name cannot be null");
        this.name = name;
        if (folder == null)
            throw new IllegalArgumentException("folder cannot be null");
        this.folder = folder;
        fileSystem = folder.getFileSystem();
        folder.addEntry(this);
    }

    /**
     * For the root folder only.
     *
     * @param fileSystem the file system for the root folder; non-null
     * @param the        name of the entry; non-null
     */
    protected AbstractEntry(FileSystem fileSystem, String name) {
        if (fileSystem == null)
            throw new IllegalArgumentException("fileSystem cannot be null");
        this.fileSystem = fileSystem;
        if (name == null)
            throw new IllegalArgumentException("name cannot be null");
        this.name = name;
        folder = null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        // relies on name being non-null
        return name.hashCode() + prime * ((folder == null) ? 0 : folder.hashCode());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof AbstractEntry))
            return false;
        AbstractEntry other = (AbstractEntry) obj;
        if (!name.equals(other.name)) // relies on name being non-null
            return false;
        return (folder == null) ? other.folder == null : folder.equals(other.folder);
    }

    @Override
    public String toString() {
        return getPath();
    }

    @Override

    public String getName() {
        return name;
    }

    @Override
    public Folder getParentFolder() {
        return folder;

    }

    @Override
    public FileSystem getFileSystem() {
        return fileSystem;
    }



    @Override
    public boolean isInFileSystem() {
        
        if (folder==null)//case it's the root
            return true; 
        else if (folder.hasEntry(this))
            return true; 
        
        else 
        return false; 
        
      
    }
    
     
    @Override
    public void remove(){
             if (folder == null){
        throw new IllegalArgumentException("root folder cannot be removed");
    }
       else{
        folder.removeEntry(this);
    }
    
    }
  



}
