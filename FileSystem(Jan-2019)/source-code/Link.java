/**
 * A symbolic link is a pointer to an entry in the file system.
 * 
 * @author Roman Kontchakov
 * @author Carsten Fuhs
 * @author Nuchem Katz
 *
 * @param <T> The type of file system entry to which this Link points.
 */
public abstract class Link<T extends Entry> extends AbstractEntry {

    /** The file system entry to which this link points. */
    private final T target;

    /**
     * Constructs a new link to an entity.
     *
     * @param folder the parent folder of this link; must not be null
     * @param name   the name of this link; must not be null
     * @param entity the entity to which this links points; must not be null
     */
    public Link(Folder folder, String name, T entity) {
        super(folder, name);
        if (entity == null)
            throw new IllegalArgumentException("entity cannot be null");
        target = entity;
    }

    /**
     * Returns the entity to which this Link points (the target of the link).
     *
     * @return the entity to which this Link points.
     */
    public T getTarget() {
        return target;
    }

    /**
     * Returns whether this Link is valid for the current file system.
     *
     * @return whether this Link is valid for the current file system, i.e., whether
     *         it links to an entry currently stored in the file system
     */

   
    
    public boolean isValidLink() {
    return target.isInFileSystem();
}

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        // relies on entity != null
        return super.hashCode() + prime * target.hashCode();
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
        if (!(obj instanceof Link))
            return false;
        Link other = (Link) obj; // no generic type here :(
        return target.equals(other.target); // relies on entity != null
    }

    @Override
    public int getSize()
    {
        return 0;
    }

    /*@Override
    public boolean isInFileSystem(){
        if (isValidLink()==true)
            return super.isInFileSystem();
        else 
            return false; 
    }*/ 

}