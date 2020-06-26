/**
 * A symbolic link to a file in a file system.
 * 
 * @author Roman Kontchakov
 * @author Carsten Fuhs
 * @author Nuchem Katz
 */
public class FileLink extends Link<File> {

    /**
     * Constructs a new link to a file.
     *
     * @param parent the parent folder of this link; must not be null
     * @param name   the name of this link; must not be null
     * @param target the file to which this links points; must not be null
     */
    public FileLink(Folder parent, String name, File target) {
        super(parent, name, target);
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
        return obj instanceof FileLink;
    }

    @Override
    public String getPath() {

        return getParentFolder().getPath() + getName();

    }
    
}

