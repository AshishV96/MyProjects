package filesystem;

import java.util.List;
import java.util.Map;

public class Folder {

    String name;
    List<String> files;
    Folder prev;
    Folder next;
    Map<String,Folder> folders;

}
