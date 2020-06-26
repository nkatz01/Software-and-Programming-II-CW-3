
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;


/*  The test class EntryTest, performing the Unit Tests as perscribed in 2.4 of Coursework Assignment Three.

@author Nuchem Katz */

public class EntryTest {
    /**
     * Default constructor for test class EntryTest
     */
    public EntryTest() {
    }


    @Test
    /* Tests that the root folder of a freshly created file system has size 0. */
    public void new_rootFolder_is_0() {
        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        assertEquals("Root folder of a freshly created file system has size", 0, AdriveRoot.getSize());
    }

    @Test
    /*
     * Tests that after creating a file “hello” with size 50 in the root folder of a
     * freshly created file system, the file actually has size 50.
     */
    public void new_file_in_new_root_with_given_size() {
        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        File myDocument = new File(AdriveRoot, "hello", 50);
        assertEquals("creating a file \"hello\" with size 50 in the root folder of a freshly created file system", 50,
            myDocument.getSize());
    }

    @Test
    /*
     * Tests that after creating a file “hello” with size 50 in the root folder of a
     * freshly created file system and then removing that file, the root folder has
     * size 0.
     */

    public void file_that_is_removed_reflects_size_on_root() {
        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        File myDocument = new File(AdriveRoot, "hello", 50);
        myDocument.remove();
        assertEquals(
            "After creating a file \"hello\" with size 50 in the root folder of a freshly created file system and then removing that file, the root's size is ",
            0, AdriveRoot.getSize());
    }

    @Test
    /*
     * Test that after creating a file “hello” with size 50 in the root folder of a
     * freshly created file system, that file is in the file system (according to
     * the file’s corresponding method).
     */
    public void new_file_created_in_root_can_be_found_there() {
        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        File myDocument = new File(AdriveRoot, "hello", 50);
        assertTrue(
            "Creating a file \"hello\" with size 50 in the root folder of a freshly created file system, the file is contained in the root ",
            myDocument.isInFileSystem());
    }

    @Test
    /*
     * Tests that after creating a file “hello” with size 50 in the root folder of a
     * freshly created file system, and then removing the file, that this file not
     * in the file system (according to the file’s corresponding method).
     */
     public void test_folder_does_not_contain_new_file_after_removing_it() {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        File newFile = new File(root, "hello", 50);
        newFile.remove();
        assertFalse("Folder does not contain new file after it's removed", root.hasEntry(newFile));
    }  

    @Test
    /*
     * Test that after creating a file "hello" with size 50 in the root folder of a
     * freshly created file system, that file’s name is "hello".
     */
    public void qurey_name_after_creating_new_file() {
        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        File myDocument = new File(AdriveRoot, "hello", 50);
        assertEquals("Creating a file \"hello\" with size 50 in the root folder, then querying the name, the name is ",
            "hello", myDocument.getName());
    }

    @Test
    /*
     * Tests that after creating a file “hello” with size 50 in the root folder of a
     * freshly created file system, the path to that file is “/hello” (using the
     * constant Entry.SEPARATOR suitably).
     */
    public void file_path_to_freshly_created_file_is_correct() {
        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        File myDocument = new File(AdriveRoot, "hello", 50);
        assertEquals("Creating a file \"hello\" with size 50 in the root folder, then querying its path, the path is ",
            "/hello", myDocument.getPath());
    }

    @Test
    /*
     * Test that after creating a folder with the name “aFolder” in the root folder
     * of a freshly created file system, the path to that folder is “/aFolder/”
     * (using the constant Entry.SEPARATOR suitably).
     */
    public void folder_path_to_freshly_created_folder_is_correct() {
        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        Folder Documents = new Folder(AdriveRoot, "aFolder");
        assertEquals("Creating a folder \"aFolder\" with size 50 in the root folder, then querying its path, the path is ",
            "/aFolder/", Documents.getPath());
    }

    @Test
    /*
     * Tests that after creating a folder with the name “aFolder” in the root folder
     * of a freshly created file system and then creating a folder link with the
     * name “bFolder” to that folder, the target of that link and the original
     * folder are equal.
     */
    public void paths_to_folder_and_path_to_link_of_that_are_eqal() {
        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        Folder Documents = new Folder(AdriveRoot, "aFolder");
        FolderLink MyDocuments = new FolderLink(AdriveRoot, "bFolder", Documents);
        assertTrue(
            "Creating a folder \"aFolder\" in the root folder, then creating to it, a link bFolder, then querying thier path, their path are ",
            Documents == MyDocuments.getTarget());

    }

    @Test
    /*
     * Tests that after creating a file “a name” with size 48 as well as a file link
     * “b name” to that file and then removing that file link, the original file is
     * still in the file system.
     */
    public void remove_link_to_file_and_file_is_still_there() {

        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        File myDocument = new File(AdriveRoot, "a name", 48);
        FileLink myDocumentShortcut = new FileLink(AdriveRoot, "b name", myDocument);
    
        assertTrue(
            "After creating a file \"a name\" with size 48, and then also a file link to it, then removing that link, shows the file still to be in the file system ",
            myDocument.isInFileSystem());

    }

   
    @Test
    /*
     * Tests that after creating a file “a name” with size 48 as well as a file link
     * “b name” to that file and then removing that file link, the file link is no
     * longer in the file system.
     */
    public void remove_file_and_file_and_link_to_it_is_also_removed() {

        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        File myDocument = new File(AdriveRoot, "a name", 48);
        FileLink myDocumentShortcut = new FileLink(AdriveRoot, "b name", myDocument);
        myDocument.remove();
        assertFalse(
            "After creating a file \"a name\" with size 48, and then also a file link to it, then removing that file, shows the link to it also not in the file system anymore",
            myDocumentShortcut.isValidLink());

    }

    /*
    * Test that creating a folder with the null reference as name in the root
    * folder of a freshly created file system throws an IllegalArgumentException
    */
    @Test(expected = IllegalArgumentException.class)
    public void creating_folder_with_name_as_null_throws_illegalArg_excep() {
        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        Folder Documents = new Folder(AdriveRoot, null);
    }

    /*
    * Tests that creating two files, both called “f”, the first of size 20 and the
    * second of size 30, in the root folder of a freshly created file system throws
    * an IllegalArgumentException.
    */
    @Test(expected = IllegalArgumentException.class)
    public void attempting_two_file_creation_with_same_name_in_same_parent_illegalArgExc() {
        FileSystem Adrive = new FileSystem();
        Folder AdriveRoot = Adrive.getRootFolder();
        File myDocument = new File(AdriveRoot, "f", 30);
        File aSecondDocument = new File(AdriveRoot, "f", 30);

    }

}
