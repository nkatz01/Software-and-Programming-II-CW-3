/**
 * "Driver class" to exercise some of the functionalities provided by the
 * Entry hierarchy.
 *
 * @author Carsten Fuhs  
 */
public class Coursework3Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        Folder root = fs.getRootFolder();
        Folder a = new Folder(root, "Users");
        File aa = new File(a, "readme.txt", 20);
        Folder ab = new Folder(a, "Adele");
        File aba = new File(ab, "playlist.txt", 40);
        FileLink ac = new FileLink(a, "music.txt", aba);
        FolderLink abb = new FolderLink(ab, "myHome", ab);

        System.out.println(root.getPath() + ": " + root.getSize());
        System.out.println(a.getPath() + ": " + a.getSize());
        System.out.println(aa.getPath() + ": " + aa.getSize());
        System.out.println(ab.getPath() + ": " + ab.getSize());
        System.out.println(aba.getPath() + ": " + aba.getSize());
        System.out.println(ac.getPath() + ": " + ac.getSize() + " -> " + ac.getTarget().getPath() + " valid: " + ac.isValidLink());
        System.out.println(abb.getPath() + ": " + abb.getSize() + " -> " + abb.getTarget().getPath() + " valid: " + abb.isValidLink());

         aba.remove();

         System.out.println(root.getPath() + ": " + root.getSize());
     //  System.out.println(ac.getPath() + ": " + aba.getSize() + " -> " + aba.getPath() + " valid: " + aba.isInFileSystem());//added
      System.out.println(ac.getPath() + ": " + ac.getSize() + " -> " + ac.getTarget().getPath() + " valid: " + ac.isValidLink());
       System.out.println(abb.getPath() + ": " + abb.getSize() + " -> " + abb.getTarget().getPath() + " valid: " + abb.isValidLink());
    }

/*
/: 60
/Users/: 60
/Users/readme.txt: 20
/Users/Adele/: 40
/Users/Adele/playlist.txt: 40
/Users/music.txt: 0 -> /Users/Adele/playlist.txt valid: true
/Users/Adele/myHome/: 0 -> /Users/Adele/ valid: true
/: 20
/Users/music.txt: 0 -> /Users/Adele/playlist.txt valid: false
/Users/Adele/myHome/: 0 -> /Users/Adele/ valid: true
 */
}
