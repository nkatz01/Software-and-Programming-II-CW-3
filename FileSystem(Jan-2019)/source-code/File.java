/**
 * A file is a file system entry with a certain size.
 *
 * @author Roman Kontchakov
 * @author Carsten Fuhs
 * @author Nuchem Katz
 */
public class File extends AbstractEntry {

    /** The size of the file. At least 0. */
    private int size;

    /**
     * Constructs a new entry for a file with parent as parent folder and name as
     * name.
     *
     * @param parent the parent folder of this entry; must not be null
     * @param name   the name of this entry; must not be null
     * @param size   the size of the file; must be at least 0
     */
    public File(Folder parent, String name, int size) {
        super(parent, name);
        if (size < 0)
            throw new IllegalArgumentException("size cannot be negative, found: " + size);
        this.size = size;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        return super.hashCode() + prime * size;
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
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof File))
            return false;
        File other = (File) obj;
        return this.size == other.size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getPath() {
        return getParentFolder().getPath() + getName();

    }

    @Override
    public void remove() {
        size = 0;
        super.remove();
   
    }

}