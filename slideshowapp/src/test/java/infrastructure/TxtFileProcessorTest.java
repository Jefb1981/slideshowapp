/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

import domainservices.SlideComponentInterface;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Phillip
 */
public class TxtFileProcessorTest {

    public TxtFileProcessorTest() {
    }

    /**
     * Test of loadFile method, of class TxtFileProcessor.
     */
    @Test
    public void testLoadFile() {
        System.out.println("load text file");
        String filePath = "C:\\Users\\Phillip\\Documents\\NetBeansProjects\\slideshow\\Documents\\Slide_txt_example.txt";
        TxtFileProcessor txtFileProcessor = new TxtFileProcessor();
        TxtFileProcessor txtFileProcessor2 = new TxtFileProcessor() {
            @Override
            public String loadFileTest(String fileLocation) {
                return "<slide>:\n"
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
            }
        };
        
        assertEquals(txtFileProcessor.loadFileTest(filePath), txtFileProcessor2.loadFileTest(filePath));
    }

}
