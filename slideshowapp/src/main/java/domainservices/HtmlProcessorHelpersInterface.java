/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainservices;

import org.jsoup.nodes.Document;

/**
 *
 * @author jhane
 */
public interface HtmlProcessorHelpersInterface {

    boolean isElementsByIdFound(Document htmlDocument, String tag);

    String getElementById(Document htmlDocument, String tag);
}
