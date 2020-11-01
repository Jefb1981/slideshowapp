package userinterface;

import infrastructure.TxtFileProcessor;
import domaincore.Level;
import domainservices.SlideComponentInterface;
import domainservices.SlideComposite;
import domainservices.Title;
import infrastructure.FileProcessor;
import infrastructure.HtmlFileProcessor;
import infrastructure.XmlFileProcessor;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

public class Projector {

    private EditorCanvas canvas;
    private int currentSlideNumber = 0;
    private SlideComponentInterface slideComposite = new SlideComposite();
    private ArrayList<SlideComponentInterface> listSlides = new ArrayList<>();
    private JFileChooser jFileChooser;
    private FileNameExtensionFilter fileNameExtensionFilter;

    public Projector() {
        canvas = new EditorCanvas();
        slideComposite.clear();
    }

    public void startShow() {
        slideComposite.clear();
        // new title object has to be created by a factory
        SlideComponentInterface defaultSlide = (SlideComponentInterface) new Title(Color.BLUE, "Welkom!", new Level(10, 20));
        loadShapes(defaultSlide);
        canvas.refresh();
    }

    public void loadShapes(SlideComponentInterface shapes) {
        slideComposite.clear();
        slideComposite.add(shapes);
        canvas.refresh();
    }

    public void nextSlide() {
        if (currentSlideNumber < (listSlides.size() - 1)) {
            setCurrentSlideNumber(currentSlideNumber + 1);
        }
    }

    public void prevSlide() {
        if (currentSlideNumber > 0) {
            setCurrentSlideNumber(currentSlideNumber - 1);
        }
    }

    public void setCurrentSlideNumber(int number) {
        currentSlideNumber = number;
    }

    public SlideComponentInterface getCurrentSlide() {
        return getSlide(currentSlideNumber);
    }

    public SlideComponentInterface getSlide(int number) {
        return listSlides.get(number);
    }

    private class EditorCanvas extends Canvas {

        private static final long serialVersionUID = 1L;
        JFrame frame;
        JMenu navigation, file;
        JMenuItem next, previous, load;

        private static final int PADDING = 1;

        EditorCanvas() {
            createFrame();
            refresh();
        }

        void createFrame() {
            frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel contentPanel = new JPanel();
            Border padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
            contentPanel.setBorder(padding);
            frame.setContentPane(contentPanel);
            // Create MenuBar
            JMenuBar mb = new JMenuBar();
            file = new JMenu("File");
            navigation = new JMenu("Navigation");

            next = new JMenuItem("Next");
            previous = new JMenuItem("Previuos");
            load = new JMenuItem("Load");
            // Add Actions
            next.addActionListener((evt) -> this.actionNextSlide(evt));
            previous.addActionListener((evt) -> this.actionPreviousSlide(evt));
            load.addActionListener((evt) -> this.actionLoadSlide(evt));
            navigation.add(next);
            navigation.add(previous);
            file.add(load);

            // the terminates the order
            mb.add(file);
            mb.add(navigation);
            // Add Menu to JFrame
            frame.setJMenuBar(mb);
            frame.add(this);
            frame.setVisible(true);
            frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        }

        void refresh() {
            this.setSize(400, 400);
            frame.pack();
        }

        public void paint(Graphics graphics) {
            slideComposite.paint(graphics);
        }

        private void actionNextSlide(ActionEvent evt) {
            if (listSlides.size() != 0) {
                nextSlide();
                loadShapes(listSlides.get(currentSlideNumber));
                repaint();
            }
        }

        private void actionPreviousSlide(ActionEvent evt) {
            if (listSlides.size() != 0) {
                prevSlide();
                loadShapes(listSlides.get(currentSlideNumber));
                repaint();
            }
        }

        private void actionLoadSlide(ActionEvent evt) {
            LoadFile();
            repaint();
        }
    }

    private void LoadFile() {
        jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jFileChooser.setDialogTitle("Select an Text, Html or Xml file");
        jFileChooser.setAcceptAllFileFilterUsed(false);
        fileNameExtensionFilter = new FileNameExtensionFilter("xml", "Html", "txt");
        jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);

        jFileChooser.setMultiSelectionEnabled(true);
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnValue = jFileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            listSlides.clear();
            File[] files = jFileChooser.getSelectedFiles();
            FileProcessor dataProcessor
                    = getInstanceFileProcessor(getFileExtension(jFileChooser.getSelectedFile()));

            if (dataProcessor != null && files.length > 0) {
                for (File file : files) {
                    if (file.isFile()) {
                        listSlides.addAll(dataProcessor.loadFile(file.getAbsolutePath()));
                    }
                }

                if (!listSlides.isEmpty()) {
                    loadShapes(listSlides.get(currentSlideNumber));
                }
            }
        }
    }

    private FileProcessor getInstanceFileProcessor(String extension) {
        switch (extension) {
            case "txt":
                return new TxtFileProcessor();
            case "html":
                return new HtmlFileProcessor();
            case "xml":
                return new XmlFileProcessor();
            default:
                return null;
        }
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return "";
    }

    public SlideComponentInterface getSlideComposite() {
        return slideComposite;
    }

    public String testFileExtension() {
        File file = new File("C:\\Users\\Phillip\\Documents\\NetBeansProjects\\slideshow\\Documents\\Slide_txt_example.txt");
        return getFileExtension(file);
    }
}
