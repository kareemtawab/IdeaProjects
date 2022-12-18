package controller;

import model.FileOperations;
import model.InvoiceHeader;
import model.InvoiceLine;
import view.InvoiceHeaderPart;
import view.InvoiceMenuBar;
import view.InvoiceTablePart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class InvoiceGenerator extends JFrame {

    private InvoiceGenerator(InvoiceHeader invoiceHeader) {
        super("Sales Invoice");
        setSize(850, 450);
        setResizable(false);
        // center the window
        setLocationRelativeTo(null);
        // action listener to run actions on main window create and exit
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Welcome to the MartZilla Invoice Generator", "Welcome", JOptionPane.PLAIN_MESSAGE);
            }

            //prompt user to export invoice files before exiting
            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {"Yes", "No"};
                int response = JOptionPane.showOptionDialog(null,
                        "Would you like to export the invoice before exiting?",
                        "Exit",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                switch (response){
                    case JOptionPane.OK_OPTION:
                        JFileChooser jFileChooser = new JFileChooser();
                        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        if (jFileChooser.showDialog(null, "Select Folder") == JFileChooser.APPROVE_OPTION){
                            System.out.println("Exporting ...");
                            String path = jFileChooser.getSelectedFile().getPath();
                            new FileOperations(invoiceHeader, path).writeFile();
                            System.exit(0);
                        }
                        else {
                            System.exit(0);
                        }
                        break;
                    case JOptionPane.NO_OPTION:
                        System.exit(0);
                        break;
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setJMenuBar(new InvoiceMenuBar(invoiceHeader).createMenuBar());

        //adding top and bottom parts of main window
        add(new InvoiceHeaderPart(invoiceHeader).createHeader());
        add(new InvoiceTablePart(invoiceHeader).createTable());

        //pack();
    }

    public static void main(String[] args) {

        // extract date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        // create arraylist of items
        ArrayList<InvoiceLine> invoiceLineArrayList = new ArrayList<>();
        invoiceLineArrayList.add(new InvoiceLine("Biscuits", 5.99f, 5));
        invoiceLineArrayList.add(new InvoiceLine("Oranges", 12.49f, 10));
        invoiceLineArrayList.add(new InvoiceLine("Mutton", 259.0f, 2));
        invoiceLineArrayList.add(new InvoiceLine("Coffee", 35.99f, 1));
        invoiceLineArrayList.add(new InvoiceLine("Chocolate", 15.35f, 6));
        invoiceLineArrayList.add(new InvoiceLine("Diapers", 240.15f, 2));
        invoiceLineArrayList.add(new InvoiceLine("Bread", 3.99f, 5));
        invoiceLineArrayList.add(new InvoiceLine("Body Spray", 29.99f, 3));
        InvoiceHeader invoiceHeader = new InvoiceHeader(246291, dtf.format(now), "Kareem Adel", "Fifth Settlement, New Cairo", "Cairo, Egypt",  invoiceLineArrayList);

        // run main window
        new InvoiceGenerator(invoiceHeader).setVisible(true);

    }
}
