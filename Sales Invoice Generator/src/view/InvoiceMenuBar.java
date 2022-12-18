package view;

import controller.InvoiceGenerator;
import model.FileOperations;
import model.InvoiceHeader;
import model.InvoiceLine;

import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class InvoiceMenuBar extends JFrame {

    private JMenuBar jMenuBar;
    private JMenu fileMenu;
    private JMenuItem saveMenuItem;
    private JMenuItem openMenuItem;
    private JMenuItem exitMenuItem;
    private InvoiceHeader invoiceHeader;

    public InvoiceMenuBar(InvoiceHeader invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    public JMenuBar createMenuBar(){
        jMenuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openMenuItem = new JMenuItem("Import Invoice");
        openMenuItem.setMnemonic('i');
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke('I', KeyEvent.CTRL_DOWN_MASK));
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (jFileChooser.showDialog(jMenuBar.getComponent(), "Import") == JFileChooser.APPROVE_OPTION){
                    System.out.println("Importing ...");
                    String path = jFileChooser.getSelectedFile().getPath();
                    FileOperations fileOperations = new FileOperations(path);
                    String importedInvoice = fileOperations.readFile();
                    System.out.println(importedInvoice);
                }
            }
        });
        saveMenuItem = new JMenuItem("Export Invoice");
        saveMenuItem.setMnemonic('e');
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke('E', KeyEvent.CTRL_DOWN_MASK));
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (jFileChooser.showDialog(jMenuBar.getComponent(), "Select Folder") == JFileChooser.APPROVE_OPTION){
                    System.out.println("Exporting ...");
                    String path = jFileChooser.getSelectedFile().getPath();
                    new FileOperations(invoiceHeader, path).writeFile();
                }
            }
        });
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_DOWN_MASK));
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Yes", "No", "Cancel"};
                int response = JOptionPane.showOptionDialog(null,
                        "Would you like to export the invoice before exiting?",
                        "Exit",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                switch (response){
                    case JOptionPane.OK_OPTION:
                        JFileChooser jFileChooser = new JFileChooser();
                        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        if (jFileChooser.showDialog(jMenuBar.getComponent(), "Select Folder") == JFileChooser.APPROVE_OPTION){
                            System.out.println("Exporting ...");
                            String path = jFileChooser.getSelectedFile().getPath();
                            new FileOperations(invoiceHeader, path).writeFile();
                            System.exit(0);
                        }
                        break;
                   case JOptionPane.NO_OPTION:
                       System.exit(0);
                       break;
                   case JOptionPane.CANCEL_OPTION:
                        break;
                }
            }
        });

        jMenuBar.add(fileMenu);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);


        return jMenuBar;
    }
}
