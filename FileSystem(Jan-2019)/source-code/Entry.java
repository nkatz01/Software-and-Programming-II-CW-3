/**
 * Interface for entries in a file system. 
 *
 * @author Roman Kontchakov
 * @author Carsten Fuhs
 */
public interface Entry {
    /**
     * Constant for the separator between a folder and its entry in the
     * textual representation of a path.
     */
    String SEPARATOR = "/";

    /**
     * Returns the name of the entry.
     *
     * @return the name of the entry
     */
    String getName();

    /**
     * Returns the parent folder, i.e., the folder in which this entry is
     * stored.
     *
     * @return the parent folder, i.e., the folder in which this entry is
     *  stored; null means that this entry is the root folder
     */
    Folder getParentFolder();

    /**
     * Returns the file system for this entry.
     *
     * @return the file system for this entry.
     */
    FileSystem getFileSystem();

    /**
     * Returns the total size of all files at or below this Entry in the
     * folder structure.
     *
     * @return the total size of all files at or below this Entry in the
     *  folder structure
     */
    int getSize();

    /**
     * Returns the full path of this entry in the folder structure.
     * Paths to entries that can contain entries (e.g., folders and links to
     * folders) end with SEPARATOR; paths to entries that cannot contain other
     * entries (e.g., files and links to files) do not end with SEPARATOR.
     *
     * @return the full path of this entry in the folder structure
     */
    String getPath();

    /**
     * Returns whether this entry is in the file system. An entry may
     * have been removed by a remove operation at or above the entry.
     *
     * @return whether this entry is in the file system 
     */
    boolean isInFileSystem();

    /**
     * Removes an entry from the folder structure of the file system.
     * Has no effect if the entry has already been removed directly or
     * indirectly. If the method is called on a root folder, an
     * IllegalArgumentException is thrown.
     *
     * @throws IllegalArgumentException if this entry is a root folder.
     */
    void remove();
}
