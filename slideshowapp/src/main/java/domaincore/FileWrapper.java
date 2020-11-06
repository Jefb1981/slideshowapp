package domaincore;

import domainservices.FileWrapperInterface;
import java.io.File;
import java.io.IOException;

public class FileWrapper implements FileWrapperInterface{

    public File CreateTextFile(String fileInformation) {
        try {

            File newTxtFile = new File(fileInformation);
            if (newTxtFile.createNewFile()) {
                return newTxtFile;
            } else {
                System.out.println("File already exists.");
                return null;
            }

        } catch (IOException ex) {
            return null;
        }
    }
}
