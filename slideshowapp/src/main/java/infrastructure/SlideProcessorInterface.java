 
package infrastructure;

import domaincore.HtmlElement;
import domaincore.Level;
import domainservices.SlideComponentInterface;
import java.util.ArrayList; 

interface SlideProcessorInterface {

    String readLineByLineFileContent(String filePath);

    SlideComponentInterface createSlideElements(String data, Level elementLevel);

    byte[] GetTxtDataFromSlideElement(SlideComponentInterface slideElement);

    String GetHtmlDataFromSlideElement(SlideComponentInterface slideElement);

    ArrayList<SlideComponentInterface> CreateSlideCompositeArray(HtmlElement htmlElement);

}
