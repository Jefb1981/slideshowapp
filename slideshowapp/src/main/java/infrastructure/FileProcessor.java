package infrastructure;

import domainservices.SlideComponentInterface;
import java.util.ArrayList;

public abstract class FileProcessor {

    abstract public ArrayList<SlideComponentInterface> loadFile(String fileLocation); 

    abstract public void saveFile(String fileName, ArrayList<SlideComponentInterface> Slides);
}
