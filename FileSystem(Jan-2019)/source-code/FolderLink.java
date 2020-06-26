
/**
 * A symbolic link to a folder in a file system.
 * 
 * @author Roman Kontchakov
 * @author Carsten Fuhs
 * @author Nuchem Katz
 */
public class FolderLink extends Link<Folder> {

    /**
     * Constructs a new link to a folder.
     *
     * @param parent the parent folder of this link; must not be null
     * @param name   the name of this link; must not be null
     * @param target the folder to which this links points; must not be null
     */
    public FolderLink(Folder parent, String name, Folder target) {
        super(parent, name, target);
    }
    
      @Override
    public String getPath() {

      if (getParentFolder() == null) {
            return this.getName();
         } else{
             return getParentFolder().getPath() + this.getName();
        }
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
        return obj instanceof FolderLink;
    }

}