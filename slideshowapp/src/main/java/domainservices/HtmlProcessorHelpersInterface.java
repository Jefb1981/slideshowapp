package domainservices;

import org.jsoup.nodes.Document;

public interface HtmlProcessorHelpersInterface {

    boolean isElementsByIdFound(Document htmlDocument, String tag);

    String getElementById(Document htmlDocument, String tag);
}
