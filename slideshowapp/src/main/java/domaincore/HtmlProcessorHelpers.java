/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaincore;

import domainservices.HtmlProcessorHelpersInterface;
import org.jsoup.nodes.Document;

/**
 *
 * @author jhane
 */
public class HtmlProcessorHelpers implements HtmlProcessorHelpersInterface{
    
    public boolean isElementsByIdFound(Document htmlDocument, String tag) {
        // the Jsoup checks for empty or hastext are always returning false.
        // the jsoup library is not working correctly
        try {
            // if the tag is not found in th html body an exception will be raised and false will be returned
            String element = htmlDocument.body().getElementById(tag).text();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
        
    public String getElementById(Document htmlDocument, String tag) {
        return htmlDocument.body().getElementById(tag).text();
    }
}
