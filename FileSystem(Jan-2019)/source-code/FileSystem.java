/**
 * A file system has a root folder as the origin of its folder structure.
 *
 * @author Carsten Fuhs
 */
public class FileSystem {

    /** The root folder. Non-null. */
    private Folder rootFolder;

    /**
     * Constructs a file system with empty root folder.
     */
    public FileSystem() {
        rootFolder = new Folder(this);
    }

    /**
     * Returns the root folder of the file system.
     *
     * @return the root folder of the file system
     */
    public Folder getRootFolder() {
        return rootFolder;
    }
}
