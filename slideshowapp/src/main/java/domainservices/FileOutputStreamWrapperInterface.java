package domainservices;

import java.io.File;
import java.io.FileOutputStream;

public interface FileOutputStreamWrapperInterface {

    FileOutputStream CreateFileStream(File file);

    void CloseOutputStream(FileOutputStream outputStream);

    void WriteContent(FileOutputStream outputStream, byte[] strToBytes);
}
