package infrastructure;

import domaincore.Level;
import domainservices.FileOutputStreamWrapperInterface;
import domainservices.FileWrapperInterface;
import domainservices.HtmlProcessorHelpersInterface;
import domainservices.SlideComponentInterface;
import domainservices.SlideComposite;
import domainservices.Title;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HtmlFileProcessorTest {

    @Mock
    private SlideProcessorInterface slideProcessorMock;
    private FileOutputStreamWrapperInterface fileOutputStreamWrapperInterfaceMock;
    private FileWrapperInterface fileWrapperInterfaceMock;
    private HtmlProcessorHelpersInterface htmlProcessorHelpersMock;

    public HtmlFileProcessorTest() {
        // mocking interfaces to be added through the constructor, thus by injection
        slideProcessorMock = mock(SlideProcessorInterface.class);
        fileWrapperInterfaceMock = mock(FileWrapperInterface.class);
        fileOutputStreamWrapperInterfaceMock = mock(FileOutputStreamWrapperInterface.class);
        htmlProcessorHelpersMock = mock(HtmlProcessorHelpersInterface.class);
    }

    @Test
    public void WhenMethodSaveFileIscalled_ThenFileAndOutputFileMethodsAreHitMultipleTimes() {
        // Arrange
        HtmlFileProcessor htmlFileProcessor = new HtmlFileProcessor(htmlProcessorHelpersMock,
                slideProcessorMock,
                fileWrapperInterfaceMock,
                fileOutputStreamWrapperInterfaceMock);
        ArrayList<SlideComponentInterface> slides = new ArrayList<>();
        SlideComposite composite = new SlideComposite();
        composite.add(new Title(Color.yellow, "test strinig", new Level(1, 10, 20)));
        slides.add(composite);
        File file = new File("dummy file");
        FileOutputStream fileStream = null;

        try {
            fileStream = new FileOutputStream(file, false);
        } catch (IOException ex) {
        }
        String expectedString = "DummyHelloString";

        when(fileWrapperInterfaceMock.CreateTextFile(Matchers.anyString())).thenReturn(file);
        when(fileOutputStreamWrapperInterfaceMock.CreateFileStream(Matchers.anyObject())).thenReturn(fileStream);
        when(slideProcessorMock.GetHtmlDataFromSlideElement(Matchers.anyObject())).thenReturn(expectedString);

        // Act
        htmlFileProcessor.saveFile("dummyFile.txt", slides);

        // Assert
        verify(fileOutputStreamWrapperInterfaceMock, times(1)).CreateFileStream(Matchers.anyObject());
        verify(fileOutputStreamWrapperInterfaceMock, times(1)).WriteContent(Matchers.anyObject(), Matchers.anyString().getBytes());
        verify(fileOutputStreamWrapperInterfaceMock, times(1)).CloseOutputStream(Matchers.anyObject());
    }

}
