package model;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {


    private InvoiceHeader invoiceHeader;
    private String path;

    public FileOperations(InvoiceHeader invoiceHeader, String path) {
        this.invoiceHeader = invoiceHeader;
        this.path = path;
    }

    public FileOperations(String path) {
        this.path = path;
    }

    public String readFile(){
        String importedContent = "";
        String importedContentForInvoiceHeader = "";
        String importedContentForInvoiceLines = "";
        int readChar = 0;
        long linesCount = 0;
        FileReader fileReader = null;
        File fileInvoiceHeader = new File(path + "/InvoiceHeader.csv");
        File fileInvoiceLines = new File(path + "/InvoiceLines.csv");

        // check if file reader can read from files
        if (fileInvoiceHeader.canRead() && fileInvoiceLines.canRead()){
            try {
                fileReader = new FileReader(fileInvoiceHeader);
                while ((readChar = fileReader.read()) != -1) {
                    importedContentForInvoiceHeader += (char)readChar;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                fileReader = new FileReader(fileInvoiceLines);
                linesCount = Files.lines(Paths.get(fileInvoiceLines.getAbsolutePath())).count();
                while ((readChar = fileReader.read()) != -1) {
                    importedContentForInvoiceLines += (char)readChar;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // print as formatted in the Udacity project requirements
            String[] valuesInvoiceHeader = importedContentForInvoiceHeader.split(",");
            importedContentForInvoiceHeader = String.format("%s\n{\n%s, %s\n", valuesInvoiceHeader[0], valuesInvoiceHeader[1], valuesInvoiceHeader[2]);
            String[] valuesInvoiceLines = importedContentForInvoiceLines.split("\n");
            importedContentForInvoiceLines = "";
            for (String valuesInvoiceLine : valuesInvoiceLines) {
                String[] temp = valuesInvoiceLine.split(",");
                importedContentForInvoiceLines += String.format("%s, %s, %s\n", temp[1], temp[2], temp[3]);
            }
            importedContentForInvoiceLines += "}\n";
            importedContent = importedContentForInvoiceHeader + importedContentForInvoiceLines;
            return importedContent;
        }
        else {
            JOptionPane.showMessageDialog(null, "Can not find invoice files or invalid file formats! Import failed.\nFile names must be as follows:\n- InvoiceHeader.csv\n- InvoiceLines.csv", "Import Fail", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public void writeFile() {
        // formatting of strings to be ready for export
        String stringForInvoiceHeader = String.format("%d,%s,%s", invoiceHeader.getInvoiceNum(), invoiceHeader.getInvoiceDate(), invoiceHeader.getCustomerName());
        String stringForInvoiceLines = "";
        for (int i = 0; i < invoiceHeader.getInvoiceLineArrayList().size(); i++){
            stringForInvoiceLines += String.format("%d,%s,%.2f,%d\n", invoiceHeader.getInvoiceNum(), invoiceHeader.getInvoiceLineArrayList().get(i).getItemName(), invoiceHeader.getInvoiceLineArrayList().get(i).getItemPrice(), invoiceHeader.getInvoiceLineArrayList().get(i).getCount());
        }
        FileWriter fileWriter = null;
        // open directory chooser
        File fileInvoiceHeader = new File(path + "/InvoiceHeader.csv");
        File fileInvoiceLines = new File(path + "/InvoiceLines.csv");
        try {
            fileInvoiceHeader.createNewFile();
            fileInvoiceLines.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // check if file writer can write to files
        if (fileInvoiceHeader.canWrite() && fileInvoiceLines.canWrite()){
            try {
                fileWriter = new FileWriter(fileInvoiceHeader);
                fileWriter.write(stringForInvoiceHeader);
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                fileWriter = new FileWriter(fileInvoiceLines);
                fileWriter.write(stringForInvoiceLines);
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Can not export invoice files to this directory! Export failed.\nMake sure write permissions are granted.", "Export Fail", JOptionPane.ERROR_MESSAGE);
        }
    }
}
