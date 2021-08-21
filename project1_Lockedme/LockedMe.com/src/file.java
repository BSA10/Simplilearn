import java.io.File;
import java.io.IOException;

public interface file {

    String[] getFiles() ;

    File getFile(String fileName);

    void addFile(String fileName);

    void searchFile(String fileName);

    void deleteFile(String fileName);

    boolean createFile (String fileName) throws IOException;

    boolean fileExist (String fileName);

    void checkContinue();




}
