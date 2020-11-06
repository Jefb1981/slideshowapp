package domaincore;

import domainservices.FileOutputStreamWrapperInterface;
import infrastructure.TxtFileProcessor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class FileOutputStreamWrapper implements FileOutputStreamWrapperInterface {

    public FileOutputStream CreateFileStream(File file) {
        try {
            return new FileOutputStream(file, true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TxtFileProcessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }

    public void CloseOutputStream(FileOutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(TxtFileProcessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void WriteContent(FileOutputStream outputStream, byte[] strToBytes) {
        try {
            outputStream.write(strToBytes);
        } catch (IOException ex) {
            Logger.getLogger(TxtFileProcessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
