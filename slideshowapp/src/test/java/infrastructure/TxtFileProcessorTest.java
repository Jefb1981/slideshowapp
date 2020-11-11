/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

import domaincore.Level;
import domainservices.FileOutputStreamWrapperInterface;
import domainservices.FileWrapperInterface;
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

public class TxtFileProcessorTest {

    public TxtFileProcessorTest() {
        // mocking interfaces to be added through the constructor, thus by injection
        slideProcessorMock = mock(SlideProcessorInterface.class);
        slideComponentInterfaceMock = mock(SlideComponentInterface.class);
        fileWrapperInterfaceMock = mock(FileWrapperInterface.class);
        fileOutputStreamWrapperInterfaceMock = mock(FileOutputStreamWrapperInterface.class);
    }

    @Mock
    private SlideProcessorInterface slideProcessorMock;
    private SlideComponentInterface slideComponentInterfaceMock;
    private FileOutputStreamWrapperInterface fileOutputStreamWrapperInterfaceMock;
    private FileWrapperInterface fileWrapperInterfaceMock;

    @Test
    public void WhenMethodLoadFileIsCalledWithAnSlideElement_ThenAnArrayWithThreeElementsIsReturned() {
        // Arrange
        String expected = "<slide>:\n"
                + "<title>: Presentatie\n"
                + "<subtitle>: Slide Show JabberPoint\n"
                + "<level1>: Welkom!\n"
                + "<level2>: Het is een genoegen om u hier te zien!\n"
                + "<level3>: Datum: 20 OKtober 2020\n"
                + "<level3>: Jhaner en Phillip\n"
                + "<level4>: Open Universiteit\n"
                + "<level4>: Locatie Heerlen\n"
                + "<figure>: http://www.slide1.nl.image\n"
                + "\n"
                + "<slide>:\n"
                + "<title>: Agenda\n"
                + "<subtitle>:\n"
                + "<level1>: 10:00 Slide Show JabberPoint Presentatie\n"
                + "<level2>: 10:15 Werkwijze\n"
                + "<level2>: 10:30 Demo\n"
                + "<level2>: 10:45 Vragen\n"
                + "<level2>: 11:00 Einde\n"
                + "<figure>: http://www.slide2.nl\n"
                + "\n"
                + "<slide>:\n"
                + "<title>: Hello World!\n"
                + "<subtitle>:\n"
                + "<level1>: Slide Show JabberPoint Presentatie\n"
                + "<level2>: \n"
                + "<level3>:\n"
                + "<level4>: This is a Java Application\n"
                + "<figure>: http://www.slide3.nl\n"
                + "";

        // returning values of methods with our own responses
        // Matcher any betekent hier dat het niet uitmaakt met welke string dit method wordt aangeroepen.
        // als het maar een string is
        when(slideProcessorMock.readLineByLineFileContent(Matchers.anyString())).thenReturn(expected);
        // the object that with every call will be returned
        Title title = new Title(Color.yellow, "test strinig", new Level(1, 10, 20));
        when(slideProcessorMock.createSlideElements(Matchers.anyString(), Matchers.anyObject())).thenReturn(title);
        // maak instantie van het object aan om de methode aan te roepen
        TxtFileProcessor txtFileProcessor = new TxtFileProcessor(slideProcessorMock,
                slideComponentInterfaceMock,
                fileWrapperInterfaceMock,
                fileOutputStreamWrapperInterfaceMock);

        // Act
        ArrayList<SlideComponentInterface> result = txtFileProcessor.loadFile("dummy string");

        // Assert
        // Controleren of the method de gewenste waarden teruggeeft
        assertNotNull(result);
        assertEquals(3, result.size());
        // mogelijk controleren van de inhoud waarden van de array
    }

    @Test
    public void WhenMethodSaveFileIscalled_ThenFileAndOutputFileMethodsAreHitMultipleTimes() {
        // Arrange
        TxtFileProcessor txtFileProcessor = new TxtFileProcessor(slideProcessorMock,
                slideComponentInterfaceMock,
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

        when(fileWrapperInterfaceMock.CreateTextFile(Matchers.anyString())).thenReturn(file);
        when(fileOutputStreamWrapperInterfaceMock.CreateFileStream(Matchers.anyObject())).thenReturn(fileStream);
        // Act
        txtFileProcessor.saveFile("dummy string", slides);

        // Assert
        verify(fileOutputStreamWrapperInterfaceMock, times(2)).WriteContent(Matchers.anyObject(), Matchers.anyObject());
        verify(fileOutputStreamWrapperInterfaceMock, times(1)).CloseOutputStream(Matchers.anyObject());
    }
}
